package co.trycore.galaxy.infrastructure.web;


import co.trycore.galaxy.core.dto.PersonDTO;
import co.trycore.galaxy.core.dto.ResponseDTO;
import co.trycore.galaxy.core.exceptions.GalaxyException;
import co.trycore.galaxy.core.usecases.PersonUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/persona")
public class PersonController {

    @Autowired
    private PersonUseCase personUseCase;

    @PostMapping
    public ResponseEntity<ResponseDTO> save(@RequestBody PersonDTO personDTO) {
        try {
            ResponseDTO responseDTO = this.personUseCase.save(personDTO);
            return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
        } catch (GalaxyException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(exception.getMessage()));
        }
    }

}
