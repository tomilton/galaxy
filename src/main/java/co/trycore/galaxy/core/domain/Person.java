package co.trycore.galaxy.core.domain;

import co.trycore.galaxy.core.common.constants.Constants;
import co.trycore.galaxy.core.common.util.UtilityDate;
import co.trycore.galaxy.core.common.util.UtilityString;
import co.trycore.galaxy.core.exceptions.FechaException;
import co.trycore.galaxy.core.exceptions.GalaxyException;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Person {

    private Integer pkpersona;
    private String nombre;
    private String apellido;
    private Integer edad;
    private BigDecimal altura;
    private BigDecimal peso;
    private String genero;
    private String fechaNacimiento;
    private Integer contador;
    private Planet planeta;

    public void validarNombre() throws GalaxyException {
        if (UtilityString.cadenaVacia(nombre)) {
            throw new GalaxyException("Nombre de persona requerido");
        }
    }

    public void validarFechaNacimiento() throws FechaException {
        Integer year = UtilityDate.getYearFromDate(this.fechaNacimiento, 1);
        if (!UtilityDate.isDate(this.fechaNacimiento) || year == null || year < Constants.MIN_YEAR || year > Constants.MAX_YEAR) {
            throw new FechaException("Formato de fecha de nacimiento incorrecto");
        }
    }


}
