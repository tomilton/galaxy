package co.trycore.galaxy.infrastructure.web;

import co.trycore.galaxy.core.dto.PersonDTO;
import co.trycore.galaxy.core.dto.PlanetDTO;
import co.trycore.galaxy.core.dto.ResponseDTO;
import co.trycore.galaxy.core.usecases.PersonUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonUseCase personUseCase;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void testSave() throws Exception {

        when(personUseCase.save(any())).thenReturn(new ResponseDTO("Registro exitoso", Boolean.TRUE));

        // Given
        PlanetDTO planetDTO = new PlanetDTO(1, "TIERRA", "2 AÑOS", BigDecimal.TEN, "NUBLADO", "PLANO", 12, 2);
        PersonDTO personDTO = new PersonDTO(null, "Milton", "Sanchez", 31, BigDecimal.ONE, BigDecimal.TEN, "M", "18/05/1990", 0, planetDTO);

        // When
        mvc.perform(post("/api/persona")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(personDTO)))
                // Then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.respuesta").value("Registro exitoso"));

        verify(personUseCase).save(any());

    }

    @Test
    void listPersons() throws Exception {

        PlanetDTO planetDTO = new PlanetDTO(1, "TIERRA", "2 AÑOS", BigDecimal.TEN, "NUBLADO", "PLANO", 12, 2);
        PersonDTO personDTO = new PersonDTO(1, "Milton", "Sanchez", 31, BigDecimal.ONE, BigDecimal.TEN, "M", "18/05/1990", 0, planetDTO);

        final List<PersonDTO> PERSONSDTO_CONTROLLER = Arrays.asList(personDTO);

        // Given
        when(personUseCase.listPersons()).thenReturn(PERSONSDTO_CONTROLLER);
        // when
        mvc.perform(get("/api/persona").contentType(MediaType.APPLICATION_JSON))
                // Then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));

        verify(personUseCase).listPersons();
    }
}
