package co.trycore.galaxy.core.usecases;

import co.trycore.galaxy.core.dto.PersonDTO;
import co.trycore.galaxy.core.dto.ResponseDTO;
import co.trycore.galaxy.core.exceptions.GalaxyException;

public interface PersonUseCase {

    ResponseDTO save(PersonDTO personDTO) throws GalaxyException;

}
