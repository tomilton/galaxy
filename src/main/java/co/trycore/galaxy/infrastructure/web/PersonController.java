package co.trycore.galaxy.infrastructure.web;


import co.trycore.galaxy.core.dto.PersonDTO;
import co.trycore.galaxy.core.dto.ResponseDTO;
import co.trycore.galaxy.core.exceptions.GalaxyException;
import co.trycore.galaxy.core.usecases.PersonUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/persona")
@Api(tags = "Api de personas")
@CrossOrigin(origins = "*")
public class PersonController {

    @Autowired
    private PersonUseCase personUseCase;

    /**
     * save person
     *
     * @param personDTO
     * @return
     */
    @PostMapping
    @ApiOperation(value = "Guarda una persona")
    public ResponseEntity<ResponseDTO> save(@RequestBody PersonDTO personDTO) {
        try {
            ResponseDTO responseDTO = this.personUseCase.save(personDTO);
            return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
        } catch (GalaxyException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(exception.getMessage(), Boolean.FALSE, ""));
        }
    }

    /**
     * @return persons
     * @author Milton Sanchez
     */
    @GetMapping
    public ResponseEntity<List<PersonDTO>> listPersons() {
        return ResponseEntity.ok(this.personUseCase.listPersons());
    }


    @GetMapping("/sumarVisita")
    @ApiOperation(value = "Suma una visita a la persona")
    public ResponseEntity<ResponseDTO> sumarVisita(@RequestParam(name = "pkpersona") Integer pkpersona) {
        try {
            ResponseDTO responseDTO = this.personUseCase.sumarVisita(pkpersona);
            return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
        } catch (GalaxyException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(exception.getMessage(), Boolean.FALSE, ""));
        }
    }

}
