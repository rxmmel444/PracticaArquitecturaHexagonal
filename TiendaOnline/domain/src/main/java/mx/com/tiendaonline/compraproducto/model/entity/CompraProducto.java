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

    private Producto producto;
    private CantidadProductos cantidad;
    private PrecioUnitario precioUnitario;

    public CompraProducto(Producto producto, Integer cantidad, Double precioUnitario) {
        this.producto = producto;
        this.cantidad = new CantidadProductos(cantidad);
        this.precioUnitario = new PrecioUnitario(precioUnitario);
    }
}
