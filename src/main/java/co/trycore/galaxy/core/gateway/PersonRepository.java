package co.trycore.galaxy.core.gateway;

import co.trycore.galaxy.core.domain.Person;

import java.util.List;

public interface PersonRepository {

    Person save(Person person);

    Person edit(Person person);

    List<Person> listPersons();

    Person getPersonByPk(Integer pkpersona);

}
