package co.trycore.galaxy.infrastructure.database.crud;

import co.trycore.galaxy.infrastructure.database.entity.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanetaCrudRepository extends JpaRepository<Planeta, Integer> {

    @Query("SELECT p FROM Planeta p ")
    List<Planeta> getAllPlanetas();

    @Query("SELECT p FROM Planeta p WHERE p.pkplaneta = ?1")
    Planeta getPlanetaByPk(Integer pkplaneta);

}