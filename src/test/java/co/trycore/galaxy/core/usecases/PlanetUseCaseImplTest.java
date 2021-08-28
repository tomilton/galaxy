package co.trycore.galaxy.core.usecases;

import co.trycore.galaxy.core.domain.Person;
import co.trycore.galaxy.core.domain.Planet;
import co.trycore.galaxy.core.dto.PlanetDTO;
import co.trycore.galaxy.core.dto.ResponseDTO;
import co.trycore.galaxy.core.gateway.PlanetRepository;
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
class PlanetUseCaseImplTest {

    // @Mock
    @MockBean
    PlanetRepository planetRepository;

    // @InjectMocks
    @Autowired
    PlanetUseCase planetUseCase;

    @Test
    void testSave() {

        Planet planet = new Planet(1, "TIERRA", "2 AÑOS", BigDecimal.TEN, "NUBLADO", "PLANO", 12, 2);

        PlanetDTO planetDTO = new PlanetDTO(1, "TIERRA", "2 AÑOS", BigDecimal.TEN, "NUBLADO", "PLANO", 12, 2);

        when(planetRepository.save(any(Planet.class))).thenReturn(planet);

        ResponseDTO responseDTO = planetUseCase.save(planetDTO);

        assertNotNull(responseDTO.getRespuesta());

        Boolean expected = Boolean.TRUE;

        assertEquals(expected, responseDTO.getExito());

        verify(planetRepository).save(any(Planet.class));

    }


}