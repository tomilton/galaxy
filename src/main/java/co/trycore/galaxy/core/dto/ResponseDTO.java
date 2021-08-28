package co.trycore.galaxy.core.dto;

import lombok.*;

/**
 * @author Milton Sánchez
 * Objeto de transferencia de datos DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ResponseDTO {
    private String respuesta;
    private Boolean exito;
    private Object any;
}
