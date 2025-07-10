

package mx.com.tiendaonline.compraproducto.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.tiendaonline.cliente.model.entity.Cliente;


import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compra {
    private CompraId id;
    private Cliente cliente;

    private PrecioTotal precioTotal;
    private FechaCompra fechaCompra;
    private List<CompraProducto> productos;


    public Compra(Cliente cliente, List<CompraProducto> productos, Double precioTotal, LocalDateTime fechaCompra) {
        this.cliente = cliente;
        this.productos = productos;
        this.precioTotal = new PrecioTotal(precioTotal);
        this.fechaCompra = new FechaCompra(fechaCompra);
    }

    public Compra(Long id, Cliente cliente, Double precioTotal, LocalDateTime fechaCompra, List<CompraProducto> productos) {
        this.id = new CompraId(id);
        this.cliente = cliente;
        this.precioTotal = new PrecioTotal(precioTotal);
        this.fechaCompra =  new FechaCompra(fechaCompra);
        this.productos = productos;
    }
}
