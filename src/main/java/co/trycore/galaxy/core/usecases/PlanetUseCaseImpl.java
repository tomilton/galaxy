package co.trycore.galaxy.core.usecases;

import co.trycore.galaxy.core.common.constants.Constants;
import co.trycore.galaxy.core.domain.Planet;
import co.trycore.galaxy.core.dto.PlanetDTO;
import co.trycore.galaxy.core.dto.ResponseDTO;
import co.trycore.galaxy.core.exceptions.GalaxyException;
import co.trycore.galaxy.core.gateway.PlanetRepository;
import co.trycore.galaxy.core.mapper.PlanetDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanetUseCaseImpl implements PlanetUseCase {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private PlanetDTOMapper planetDTOMapper;

    @Transactional
    @Override
    public ResponseDTO save(PlanetDTO planetDTO) throws GalaxyException {
        try {
            final Planet planet = this.planetDTOMapper.toPlanet(planetDTO);
            planet.validarNombre();
            this.planetRepository.save(planet);
            return new ResponseDTO(Constants.REGISTRO_EXITOSO, Boolean.TRUE, planet);
        } catch (GalaxyException runtimeException) {
            throw runtimeException;
        } catch (Exception exception) {
            throw new GalaxyException(exception.getLocalizedMessage(), exception);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<PlanetDTO> listPlanets() {
        List<Planet> personList = this.planetRepository.listPlanets();
        return this.planetDTOMapper.toPlanetsDTO(personList);
    }

    @Transactional
    @Override
    public ResponseDTO sumarVisita(Integer pkplaneta) {
        try {
            final Planet planet = this.planetRepository.getPlanetByPk(pkplaneta);
            planet.sumarVisita(Constants.INCREMENTO_VISITA_PLANETA);
            this.planetRepository.edit(planet);
            return new ResponseDTO(Constants.REGISTRO_EXITOSO, Boolean.TRUE, planet.getContador());
        } catch (Exception exception) {
            throw new GalaxyException(exception.getMessage(), exception);
        }
    }
}
