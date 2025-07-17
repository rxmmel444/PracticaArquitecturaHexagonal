package mx.com.tiendaonline.compraproducto.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CompraProducto {
private CProductoId productoId;
private CProductoNombre nombre;
private CProductoCantidad cantidad;
private CProductoPrecio precioUnitario;

    public CompraProducto(Long productoId, String nombre, Integer cantidad, BigDecimal precioUnitario) {
        this.productoId = new CProductoId(productoId);
        this.nombre = new CProductoNombre(nombre);
        this.cantidad = new CProductoCantidad(cantidad);
        this.precioUnitario = new CProductoPrecio(precioUnitario);
    }
    public CompraProducto(CProductoId productoId,
                          CProductoNombre nombre,
                          CProductoCantidad cantidad,
                          CProductoPrecio precioUnitario) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
}
