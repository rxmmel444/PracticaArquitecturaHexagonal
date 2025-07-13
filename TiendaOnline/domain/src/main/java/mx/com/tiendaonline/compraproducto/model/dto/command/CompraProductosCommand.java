package mx.com.tiendaonline.compraproducto.model.dto.command;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompraProductosCommand {
    private Long productoId;
    private Integer cantidad;
}