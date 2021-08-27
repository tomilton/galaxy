package co.trycore.galaxy.core.usecases;

import co.trycore.galaxy.core.domain.Person;
import co.trycore.galaxy.core.domain.Planet;
import co.trycore.galaxy.core.dto.PersonDTO;
import co.trycore.galaxy.core.dto.PlanetDTO;
import co.trycore.galaxy.core.dto.ResponseDTO;
import co.trycore.galaxy.core.gateway.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class PersonUseCaseImplTest {

    // @Mock
    @MockBean
    PersonRepository personRepository;

    // @InjectMocks
    @Autowired
    PersonUseCase personUseCase;

    @Test
    void testSave() {
        Planet planet = new Planet(1, "TIERRA", "2 AÑOS", BigDecimal.TEN, "NUBLADO", "PLANO", 12, 2);
        Person person = new Person(null, "Milton", "Sanchez", 31, BigDecimal.ONE, BigDecimal.TEN, "M", "18/05/1990", 0, planet);

        PlanetDTO planetDTO = new PlanetDTO(1, "TIERRA", "2 AÑOS", BigDecimal.TEN, "NUBLADO", "PLANO", 12, 2);
        PersonDTO personDTO = new PersonDTO(null, "Milton", "Sanchez", 31, BigDecimal.ONE, BigDecimal.TEN, "M", "18/05/1990", 0, planetDTO);

        when(personRepository.save(any(Person.class))).thenReturn(person);

        ResponseDTO responseDTO = personUseCase.save(personDTO);

        assertNotNull(responseDTO.getRespuesta());

        Boolean expected = Boolean.TRUE;

        assertEquals(expected, responseDTO.getExito());

        verify(personRepository).save(any(Person.class));
    }


}