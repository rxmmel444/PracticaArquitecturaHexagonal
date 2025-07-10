
/*
package mx.com.tiendaonline.compraproducto.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.model.entity.CompraProducto;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compra {
    private CompraId id;
    private Cliente cliente;
    private List<CompraProducto> productos;
    private PrecioTotal precioTotal;
    private FechaCompra fechaCompra;

    public Compra(Cliente cliente, List<CompraProducto> productos, double precioTotal, LocalDateTime fechaCompra) {
        this.cliente = cliente;
        this.productos = productos;
        this.precioTotal = new PrecioTotal(precioTotal);
        this.fechaCompra = new FechaCompra(fechaCompra);
    }
}
*/