package co.trycore.galaxy.infrastructure.database.crud;


import co.trycore.galaxy.infrastructure.database.entity.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaCrudRepository extends JpaRepository<Persona, Integer> {

    @Query("SELECT p FROM Persona p JOIN FETCH p.planeta pl ")
    List<Persona> getAllPersons();
    
}