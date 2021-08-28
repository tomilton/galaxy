package co.trycore.galaxy.infrastructure.web;

import co.trycore.galaxy.core.dto.PlanetDTO;
import co.trycore.galaxy.core.dto.ResponseDTO;
import co.trycore.galaxy.core.usecases.PlanetUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlanetController.class)
class PlanetControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PlanetUseCase planetUseCase;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void testSave() throws Exception {

        when(planetUseCase.save(any())).thenReturn(new ResponseDTO("Registro exitoso", Boolean.TRUE, ""));

        // Given
        PlanetDTO planetDTO = new PlanetDTO(1, "TIERRA", "2 AÑOS", BigDecimal.TEN, "NUBLADO", "PLANO", 12, 2);

        // When
        mvc.perform(post("/api/planeta")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(planetDTO)))
                // Then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.respuesta").value("Registro exitoso"));

        verify(planetUseCase).save(any());

    }


}