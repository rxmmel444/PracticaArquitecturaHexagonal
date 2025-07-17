package mx.com.tiendaonline.producto.port.repository;



import mx.com.tiendaonline.producto.model.dto.command.ProductoCreateCommand;
import mx.com.tiendaonline.producto.model.entity.Producto;

public interface ProductoRepository {

    Producto create (Producto producto);
    Producto update (Long id, Producto producto);
    void delete (Long id);
}
