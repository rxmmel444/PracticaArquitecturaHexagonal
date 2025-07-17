package mx.com.tiendaonline.compraproducto.service;


import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.model.exception.ClienteException;
import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;

@RequiredArgsConstructor
public class ValidarCompraService {

    private final ClienteDAO clienteDAO;
    private final ProductoDAO productoDAO;

    public Cliente validarCliente(Long clienteId){
        Cliente cliente = clienteDAO.getById(clienteId);
        if(cliente == null){
            throw new ClienteException("cliente no encontrado con el iD" + clienteId);
        }
        return cliente;
    }

    public Producto validarProductoStock(Long productoId, Integer cantidad){
        Producto producto = productoDAO.getById(productoId);
        if (producto==null){
            throw  new IllegalArgumentException("producto no encontrado con el id " + producto);
        }
        if (producto.getStock() < cantidad){
            throw new IllegalStateException("stock insuficiente no se puede vender el producto" + producto.getNombre());
        }
        return producto;
    }

}
