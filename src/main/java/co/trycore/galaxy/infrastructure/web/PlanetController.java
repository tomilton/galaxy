package co.trycore.galaxy.infrastructure.web;

import co.trycore.galaxy.core.dto.PlanetDTO;
import co.trycore.galaxy.core.dto.ResponseDTO;
import co.trycore.galaxy.core.exceptions.GalaxyException;
import co.trycore.galaxy.core.usecases.PlanetUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/planeta")
@Api(tags = "Api de planetas")
@CrossOrigin(origins = "*")
public class PlanetController {

    @Autowired
    private PlanetUseCase planetUseCase;

    /**
     * save planet
     *
     * @param planetDTO
     * @return
     */
    @PostMapping
    @ApiOperation(value = "Guarda una persona")
    public ResponseEntity<ResponseDTO> save(@RequestBody PlanetDTO planetDTO) {
        try {
            ResponseDTO responseDTO = this.planetUseCase.save(planetDTO);
            return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
        } catch (GalaxyException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(exception.getMessage(), Boolean.FALSE, ""));
        }
    }

    /**
     * @return planets
     * @author Milton Sanchez
     */
    @GetMapping
    @ApiOperation(value = "Retorna todos los planetas")
    public ResponseEntity<List<PlanetDTO>> listPlanets() {
        return ResponseEntity.ok(this.planetUseCase.listPlanets());
    }


    @GetMapping("/sumarVisita")
    @ApiOperation(value = "Suma una visita a la persona")
    public ResponseEntity<ResponseDTO> sumarVisita(@RequestParam(name = "pkplaneta") Integer pkplaneta) {
        try {
            ResponseDTO responseDTO = this.planetUseCase.sumarVisita(pkplaneta);
            return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
        } catch (GalaxyException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(exception.getMessage(), Boolean.FALSE, ""));
        }
    }

    /**
     * @return planetas
     * @author Milton Sanchez
     */
    @GetMapping("/planetasMasVisitados")
    @ApiOperation(value = "Retorna el top de planetas con mas visitas")
    public ResponseEntity<List<PlanetDTO>> getPlanetasMasVisitados(@RequestParam(name = "top") int top) {
        return ResponseEntity.ok(this.planetUseCase.getPlanetasMasVisitados(top));
    }


}
