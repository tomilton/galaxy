package co.trycore.galaxy.core.mapper;

import co.trycore.galaxy.core.domain.Planet;
import co.trycore.galaxy.core.dto.PersonDTO;
import co.trycore.galaxy.core.dto.PlanetDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlanetDTOMapper {

    @Mapping(source = "pkplaneta", target = "pkplaneta")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "periodoRotacion", target = "periodoRotacion")
    @Mapping(source = "diametro", target = "diametro")
    @Mapping(source = "clima", target = "clima")
    @Mapping(source = "terreno", target = "terreno")
    @Mapping(source = "cantidadPersona", target = "cantidadPersona")
    @Mapping(source = "contador", target = "contador")
    PlanetDTO toPersonDTO(Planet planet);

    List<PlanetDTO> toPlanetsDTO(List<Planet> planets);

    @InheritInverseConfiguration
    Planet toPlanet(PlanetDTO planetDTO);

}
