package mx.com.tiendaonline.compraproducto.service;

import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.compraproducto.model.entity.*;
import mx.com.tiendaonline.producto.model.entity.Producto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CompraProductoService {

    public CompraProducto crearDetalleCompra(Producto producto,Integer cantidad){
     return new CompraProducto(
             producto.getId(),
             producto.getNombre(),
             cantidad,
             producto.getPrecio()
     );
    }

    public Compra crearCompra(Cliente cliente, List<CompraProducto> productos, BigDecimal total){
        Compra compra = new Compra();
        compra.setId(new CompraId());
        compra.setCliente(cliente);


        compra.setFechaCompra(new CompraFechaCompra(LocalDateTime.now()));
        compra.setPrecioTotal(new CompraPrecioTotal(total));
        compra.setProductos(new CompraProductos(productos));

        return compra;
    }
}
