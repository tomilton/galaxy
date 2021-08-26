package co.trycore.galaxy.core.domain;

import co.trycore.galaxy.infrastructure.database.entity.Planeta;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class Person {

    private Integer pkPersona;
    private String nombre;
    private String apellido;
    private Integer edad;
    private BigDecimal altura;
    private BigDecimal peso;
    private String genero;
    private String fechaNacimiento;
    private Integer contador;
    private Planet planeta;

    public Person(Integer pkPersona, String nombre, String apellido, Integer edad, BigDecimal altura, BigDecimal peso, String genero, String fechaNacimiento, Integer contador, Planet planeta) {
        this.pkPersona = pkPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.contador = contador;
        this.planeta = planeta;
    }
}
