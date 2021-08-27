package co.trycore.galaxy.core.mapper;


import co.trycore.galaxy.core.domain.Person;
import co.trycore.galaxy.core.dto.PersonDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PlanetDTOMapper.class})
public interface PersonDTOMapper {

    @Mapping(source = "pkpersona", target = "pkpersona")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "edad", target = "edad")
    @Mapping(source = "altura", target = "altura")
    @Mapping(source = "peso", target = "peso")
    @Mapping(source = "genero", target = "genero")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "contador", target = "contador")
    @Mapping(source = "planeta", target = "planeta")
    PersonDTO toPersonDTO(Person person);

    List<PersonDTO> toPersonsDTO(List<Person> persons);

    @InheritInverseConfiguration
    Person toPerson(PersonDTO personDTO);
}
