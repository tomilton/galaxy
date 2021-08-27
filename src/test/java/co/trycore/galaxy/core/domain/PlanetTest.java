package co.trycore.galaxy.core.domain;

import co.trycore.galaxy.core.exceptions.GalaxyException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {

    @Test
    void validarNombre() {
        Planet planet = new Planet(null, null,
                "2 AÑOS", BigDecimal.TEN, "NUBLADO",
                "PLANO", 12, 2);
        Exception exception = assertThrows(GalaxyException.class, () -> {
            planet.validarNombre();
        });
        String actual = exception.getMessage();
        String expected = "Nombre de planeta requerido";
        assertEquals(expected, actual);
    }
}