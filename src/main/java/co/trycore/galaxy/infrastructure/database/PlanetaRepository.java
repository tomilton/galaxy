package co.trycore.galaxy.infrastructure.database;

import co.trycore.galaxy.core.domain.Planet;
import co.trycore.galaxy.core.gateway.PlanetRepository;

import co.trycore.galaxy.infrastructure.database.crud.PlanetaCrudRepository;
import co.trycore.galaxy.infrastructure.database.crud.PlanetaJpaRepository;
import co.trycore.galaxy.infrastructure.database.entity.Planeta;
import co.trycore.galaxy.infrastructure.database.mapper.PlanetaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanetaRepository implements PlanetRepository {

    @Autowired
    private PlanetaCrudRepository planetaCrudRepository;
    @Autowired
    private PlanetaJpaRepository planetaJpaRepository;
    @Autowired
    private PlanetaMapper mapper;

    @Override
    public Planet save(Planet planet) {
        Planeta planeta = mapper.toPlaneta(planet);
        return mapper.toPlanet(this.planetaCrudRepository.save(planeta));
    }

    @Override
    public Planet edit(Planet planet) {
        Planeta planeta = mapper.toPlaneta(planet);
        return mapper.toPlanet(this.planetaCrudRepository.save(planeta));
    }

    @Override
    public List<Planet> listPlanets() {
        List<Planeta> planetas = planetaCrudRepository.getAllPlanetas();
        return this.mapper.toPlanets(planetas);
    }

    @Override
    public Planet getPlanetByPk(Integer pkplanet) {
        Planeta planeta = planetaCrudRepository.getPlanetaByPk(pkplanet);
        return this.mapper.toPlanet(planeta);
    }

    @Override
    public List<Planet> getPlanetasMasVisitados(int top) {
        List<Planeta> planetas = planetaJpaRepository.getPlanetasMasVisitados(top);
        return this.mapper.toPlanets(planetas);
    }
}
