package co.trycore.galaxy.infrastructure.database.mapper;

import co.trycore.galaxy.core.domain.Person;
import co.trycore.galaxy.infrastructure.database.entity.Persona;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PlanetaMapper.class})
public interface PersonaMapper {

    @Mapping(source = "pkPersona", target = "pkPersona")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "edad", target = "edad")
    @Mapping(source = "altura", target = "altura")
    @Mapping(source = "peso", target = "peso")
    @Mapping(source = "genero", target = "genero")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento", dateFormat = "dd/MM/yyyy")
    @Mapping(source = "contador", target = "contador")
    @Mapping(source = "planeta", target = "planeta")
    Person toPayment(Persona persona);

    List<Person> toPersons(List<Persona> personas);

    @InheritInverseConfiguration
    Persona toPersona(Person person);

}
