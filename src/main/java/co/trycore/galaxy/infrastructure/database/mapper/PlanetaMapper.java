package co.trycore.galaxy.infrastructure.database.mapper;

import co.trycore.galaxy.core.domain.Planet;
import co.trycore.galaxy.infrastructure.database.entity.Planeta;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PlanetaMapper {
    @Mappings({
            @Mapping(source = "pkPlaneta", target = "pkPlaneta"),
            @Mapping(source = "periodoRotacion", target = "periodoRotacion"),
            @Mapping(source = "diametro", target = "diametro"),
            @Mapping(source = "clima", target = "clima"),
            @Mapping(source = "terreno", target = "terreno"),
            @Mapping(source = "cantidadPersona", target = "cantidadPersona"),
            @Mapping(source = "contador", target = "contador"),
    })
    Planet toCategory(Planeta planeta);

    @InheritInverseConfiguration
    @Mapping(target = "personaList", ignore = true)
    Planeta toPlaneta(Planet planet);
}