package co.trycore.galaxy.core.gateway;

import co.trycore.galaxy.core.domain.Planet;

import java.util.List;

public interface PlanetRepository {

    Planet save(Planet planet);

    Planet edit(Planet planet);

    List<Planet> listPlanets();

}
