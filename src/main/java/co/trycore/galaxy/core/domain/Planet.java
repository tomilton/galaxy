package co.trycore.galaxy.core.domain;

import co.trycore.galaxy.core.common.util.UtilityString;
import co.trycore.galaxy.core.exceptions.GalaxyException;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Planet {
    private Integer pkplaneta;
    private String nombre;
    private String periodoRotacion;
    private BigDecimal diametro;
    private String clima;
    private String terreno;
    private Integer cantidadPersona;
    private Integer contador;

    public void validarNombre() throws GalaxyException {
        if (UtilityString.cadenaVacia(nombre)) {
            throw new GalaxyException("Nombre de planeta requerido");
        }
    }

    public void sumarVisita(Integer valor) {
        if (valor <= 0) {
            throw new GalaxyException("El valor debe ser mayor de cero");
        }
        if (this.contador == null) {
            this.contador = 0;
        }
        Integer nuevoConteo = this.contador + valor;
        this.contador = nuevoConteo;
    }

}
