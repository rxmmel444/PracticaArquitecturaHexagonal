
package mx.com.tiendaonline.compraproducto.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;
import mx.com.tiendaonline.compraproducto.model.dto.CompraProductoDTO;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraCreateCommand;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraProductoCommand;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraProductosCommand;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProducto;
import mx.com.tiendaonline.compraproducto.port.repository.CompraRespository;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor

public class CompraCreateService {

    private final ClienteDAO clienteDAO;
    private final ProductoDAO productoDAO;
    private final CompraRespository compraRespository;


    @Transactional
    public Compra crearCompra(CompraCreateCommand command) {
        List<CompraProducto> compraDetalle = new ArrayList<>();
        Cliente cliente = clienteDAO.getById(command.getClienteId());

        if (cliente == null) {
            throw new IllegalArgumentException(("Cliente no encontrado con el id " + command.getClienteId()));

        }
        List<CompraProducto> detalles = new ArrayList<>();
        BigDecimal precioTotal = BigDecimal.ZERO;

        for (CompraProductosCommand productosCompra : command.getProductos()) {
            Producto producto = productoDAO.getById(productosCompra.getProductoId());
            if (producto == null) {
                throw new IllegalArgumentException("Producto no encontrado con el ID" + command.getClienteId());
            }
            if (producto.getStock() < productosCompra.getCantidad()) {
                throw new IllegalStateException("Stock insuficiente, no hay mas por el momento" + producto.getNombre());
            }

            /*actualizamos el stock */
            productoDAO.actualziarStock(producto.getId(), producto.getStock() - productosCompra.getCantidad());

            CompraProducto detalle = new CompraProducto();
            detalle.setProductoId(producto.getId());
            detalle.setNombre(producto.getNombre());
            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setCantidad(productosCompra.getCantidad());

            compraDetalle.add(detalle);
            BigDecimal subtotal = producto.getPrecio().multiply(BigDecimal.valueOf(productosCompra.getCantidad()));
            precioTotal = precioTotal.add(subtotal);
        }
        Compra compra = new Compra();
        compra.setClienteId(cliente.getId());
        compra.setFechaCompra(LocalDateTime.now());
        compra.setPrecioTotal(precioTotal);
        compra.setProductos(compraDetalle);
        return compraRespository.create(compra);
    }
}


