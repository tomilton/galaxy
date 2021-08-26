package co.trycore.galaxy.infrastructure.database.crud;

import co.trycore.galaxy.infrastructure.database.entity.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetaCrudRepository extends JpaRepository<Planeta, Integer> {
}