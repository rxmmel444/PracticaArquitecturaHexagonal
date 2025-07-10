
/*
package mx.com.tiendaonline.compraproducto.service;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;
import mx.com.tiendaonline.compraproducto.model.dto.CompraDTO;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraCreateCommand;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProducto;
import mx.com.tiendaonline.compraproducto.port.dao.CompraDAO;
import mx.com.tiendaonline.compraproducto.port.repository.CompraRespository;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CompraCreateService {

    private final ClienteDAO clienteDAO;
    private final ProductoDAO productoDAO;
    private final CompraRespository compraRespository;

    public Compra crearCompra(CompraCreateCommand command){
        Cliente cliente = clienteDAO.getById(command.getClienteId());

        List<CompraProducto> productosComprados = new ArrayList<>();


        for (CompraCreateCommand.ProductoCompraCommand p : command.getProductos()) {
            Producto producto = productoDAO.getById(p.getProductoId());
            double precioUnitario = producto.getPrecio().doubleValue();
            int cantidad = p.getCantidad();
            total += precioUnitario * cantidad;

            productosComprados.add(new CompraProducto(producto, cantidad, precioUnitario));
        }

        return ventaRepository.save(new Compra(cliente, productosComprados, total, LocalDateTime.now()));
    }
}


 */