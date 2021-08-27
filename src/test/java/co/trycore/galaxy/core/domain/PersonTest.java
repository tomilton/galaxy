package co.trycore.galaxy.core.domain;

import co.trycore.galaxy.core.exceptions.FechaException;
import co.trycore.galaxy.core.exceptions.GalaxyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void validarNombre() {
        Person person = new Person(null, null,
                "Sanchez", 31, BigDecimal.ONE,
                BigDecimal.TEN, "M", "18/05/1990",
                0, new Planet());
        Exception exception = assertThrows(GalaxyException.class, () -> {
            person.validarNombre();
        });
        String actual = exception.getMessage();
        String expected = "Nombre de persona requerido";
        assertEquals(expected, actual);
    }


    static List<String> fechaList() {
        return Arrays.asList("", "32/01/1920", "01/13/2121", "11-03-2020", "11-2-2020", " ", "", "19/12/0", "01/01/1920", "01/01/2122", "21/08/202");
    }

    @ParameterizedTest
    @MethodSource("fechaList")
    @DisplayName("El formato de la fecha de nacimiento debe ser dd/mm/yyyy")
    void testFechaNacimiento(String fecha) {
        Person person = new Person(null, null,
                "Sanchez", 31, BigDecimal.ONE,
                BigDecimal.TEN, "M", "18/05/199",
                0, new Planet());
        Exception exception = assertThrows(FechaException.class, () -> {
            person.validarFechaNacimiento();
        });
        assertNotNull(person.getFechaNacimiento());
        String actual = exception.getMessage();
        String expected = "Formato de fecha de nacimiento incorrecto";
        assertEquals(expected, actual);
    }


}