package co.trycore.galaxy.core.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class PlanetDTO {
    private Integer pkPlaneta;
    private String nombre;
    private String periodoRotacion;
    private BigDecimal diametro;
    private String clima;
    private String terreno;
    private Integer cantidadPersona;
    private Integer contador;

    public PlanetDTO(Integer pkPlaneta, String nombre, String periodoRotacion, BigDecimal diametro, String clima, String terreno, Integer cantidadPersona, Integer contador) {
        this.pkPlaneta = pkPlaneta;
        this.nombre = nombre;
        this.periodoRotacion = periodoRotacion;
        this.diametro = diametro;
        this.clima = clima;
        this.terreno = terreno;
        this.cantidadPersona = cantidadPersona;
        this.contador = contador;
    }
}
