package mx.com.tiendaonline.compraproducto.model.dto;

import lombok.*;
import mx.com.tiendaonline.producto.model.entity.Producto;

import java.math.BigDecimal;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompraProductoDTO {
        private Long productoId;
        private String nombre;
    private Integer cantidad;
    private BigDecimal precioUnitario;
}
