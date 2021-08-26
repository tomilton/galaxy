package co.trycore.galaxy.infrastructure.database.crud;


import co.trycore.galaxy.infrastructure.database.entity.Persona;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaCrudRepository extends JpaRepository<Persona, Integer> {

}