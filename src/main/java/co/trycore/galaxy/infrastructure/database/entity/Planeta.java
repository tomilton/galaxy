package co.trycore.galaxy.infrastructure.database.entity;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Usuario
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "planeta")
public class Planeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_planeta")
    private Integer pkplaneta;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "periodo_rotacion")
    private String periodoRotacion;

    @Column(name = "diametro")
    private BigDecimal diametro;

    @Column(name = "clima")
    private String clima;

    @Column(name = "terreno")
    private String terreno;
    @Column(name = "cantidad_persona")
    private Integer cantidadPersona;
    @Column(name = "contador")
    private Integer contador;
    @OneToMany(mappedBy = "planeta", fetch = FetchType.LAZY)
    private List<Persona> personaList;
}

