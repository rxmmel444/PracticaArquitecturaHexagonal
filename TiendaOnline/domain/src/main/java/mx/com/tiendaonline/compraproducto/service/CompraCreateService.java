
package mx.com.tiendaonline.compraproducto.service;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;
import mx.com.tiendaonline.compraproducto.model.dto.CompraDTO;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraCreateCommand;

import mx.com.tiendaonline.compraproducto.model.dto.command.CompraProductoCommand;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProducto;
import mx.com.tiendaonline.compraproducto.model.entity.FechaCompra;
import mx.com.tiendaonline.compraproducto.model.entity.PrecioTotal;
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
/*obtener lista de productos comprados y crea objectos nuevos en lista del dominio*/
        List<CompraProducto> productosComprados = new ArrayList<>();

 Double total = 0.0;
        for (CompraCreateCommand.CompraProductoCommand p : command.getProducto()) {

            Producto producto = productoDAO.getById(p.getProductoId());

            double precioUnitario = producto.getPrecio().doubleValue();

            int cantidad = p.getCantidad();
            total += precioUnitario * cantidad;

            productosComprados.add(new CompraProducto(
                    producto,
                    cantidad,
                    precioUnitario));
        }

        Compra compra= new Compra(

               cliente,
                productosComprados,
                total,LocalDateTime.now()

        );
        return compraRespository.create(compra);
    }
}



