package co.trycore.galaxy.core.usecases;

import co.trycore.galaxy.core.domain.Person;
import co.trycore.galaxy.core.domain.Planet;
import co.trycore.galaxy.core.dto.PersonDTO;
import co.trycore.galaxy.core.dto.ResponseDTO;
import co.trycore.galaxy.core.exceptions.GalaxyException;
import co.trycore.galaxy.core.gateway.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonUseCaseImpl implements PersonUseCase {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public ResponseDTO save(final PersonDTO personDTO) throws GalaxyException {

        final Planet planet = new Planet(
                personDTO.getPlaneta().getPkPlaneta(),
                personDTO.getPlaneta().getNombre(),
                personDTO.getPlaneta().getPeriodoRotacion(),
                personDTO.getPlaneta().getDiametro(),
                personDTO.getPlaneta().getClima(),
                personDTO.getPlaneta().getTerreno(),
                personDTO.getPlaneta().getCantidadPersona(),
                personDTO.getPlaneta().getContador()
        );

        final Person person = new Person(
                personDTO.getPkPersona(),
                personDTO.getNombre(),
                personDTO.getApellido(),
                personDTO.getEdad(),
                personDTO.getAltura(),
                personDTO.getPeso(),
                personDTO.getGenero(),
                personDTO.getFechaNacimiento(),
                personDTO.getContador(),
                planet
        );

        personRepository.save(person);
        return new ResponseDTO("ok");
    }


}
