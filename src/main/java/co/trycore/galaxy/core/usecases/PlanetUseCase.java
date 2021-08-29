package co.trycore.galaxy.core.usecases;

import co.trycore.galaxy.core.dto.PlanetDTO;
import co.trycore.galaxy.core.dto.ResponseDTO;
import co.trycore.galaxy.core.exceptions.GalaxyException;

import java.util.List;

public interface PlanetUseCase {

    ResponseDTO save(PlanetDTO planetDTO) throws GalaxyException;

    List<PlanetDTO> listPlanets();

    ResponseDTO sumarVisita(Integer pkplaneta);

    List<PlanetDTO> getPlanetasMasVisitados(int top);

}
