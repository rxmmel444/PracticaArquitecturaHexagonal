package mx.com.tiendaonline.producto.port.dao;

import mx.com.tiendaonline.producto.model.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoDAO {

    List<Producto> getAllClientes();
    Producto getById (Long id);
    void actualziarStock(Long id,Integer cantidad);
}
