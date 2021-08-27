package co.trycore.galaxy.core.usecases;

import co.trycore.galaxy.core.domain.Person;
import co.trycore.galaxy.core.domain.Planet;
import co.trycore.galaxy.core.dto.PersonDTO;
import co.trycore.galaxy.core.dto.ResponseDTO;
import co.trycore.galaxy.core.exceptions.GalaxyException;
import co.trycore.galaxy.core.gateway.PersonRepository;
import co.trycore.galaxy.core.mapper.PersonDTOMapper;
import co.trycore.galaxy.core.mapper.PlanetDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonUseCaseImpl implements PersonUseCase {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonDTOMapper personDTOMapper;

    @Autowired
    private PlanetDTOMapper planetDTOMapper;

    @Transactional
    @Override
    public ResponseDTO save(final PersonDTO personDTO) throws GalaxyException {
        try {
            final Person person = this.personDTOMapper.toPerson(personDTO);
            final Planet planet = this.planetDTOMapper.toPlanet(personDTO.getPlaneta());
            person.validarNombre();
            person.validarFechaNacimiento();
            planet.validarNombre();
            personRepository.save(person);
            return new ResponseDTO("Registro exitoso", Boolean.TRUE);
        } catch (GalaxyException runtimeException) {
            throw runtimeException;
        } catch (Exception exception) {
            throw new GalaxyException(exception.getLocalizedMessage(), exception);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<PersonDTO> listPersons() {
        List<Person> personList = this.personRepository.listPersons();
        return this.personDTOMapper.toPersonsDTO(personList);
    }


}
