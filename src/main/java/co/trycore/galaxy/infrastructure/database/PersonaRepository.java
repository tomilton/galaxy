package co.trycore.galaxy.infrastructure.database;

import co.trycore.galaxy.core.domain.Person;
import co.trycore.galaxy.core.gateway.PersonRepository;
import co.trycore.galaxy.infrastructure.database.crud.PersonaCrudRepository;
import co.trycore.galaxy.infrastructure.database.entity.Persona;
import co.trycore.galaxy.infrastructure.database.mapper.PersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRepository implements PersonRepository {

    @Autowired
    private PersonaCrudRepository personaCrudRepository;
    @Autowired
    private PersonaMapper mapper;

    @Override
    public Person save(Person person) {
        Persona persona = mapper.toPersona(person);
        return mapper.toPayment(this.personaCrudRepository.save(persona));
    }

    @Override
    public Person edit(Person person) {
        return null;
    }

    @Override
    public List<Person> listPersons() {
        return null;
    }
}
