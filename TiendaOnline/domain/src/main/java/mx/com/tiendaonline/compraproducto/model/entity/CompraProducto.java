package mx.com.tiendaonline.compraproducto.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.tiendaonline.producto.model.entity.Producto;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraProducto {
private Long productoId;
private String nombre;
private BigDecimal precioUnitario;
private Integer cantidad;
}
