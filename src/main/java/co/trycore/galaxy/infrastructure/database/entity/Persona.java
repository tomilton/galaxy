package co.trycore.galaxy.infrastructure.database.entity;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Milton
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_persona")
    private Integer pkPersona;
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;
    @Column(name = "edad")
    private Integer edad;

    @Column(name = "altura")
    private BigDecimal altura;
    @Column(name = "peso")
    private BigDecimal peso;

    @Column(name = "genero")
    private String genero;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "contador")
    private Integer contador;
    @JoinColumn(name = "fk_planeta", referencedColumnName = "pk_planeta")
    @ManyToOne(fetch = FetchType.LAZY)
    private Planeta planeta;

}

