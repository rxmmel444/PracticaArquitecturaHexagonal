package mx.com.tiendaonline.producto.service;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.producto.model.dto.command.ProductoUpdateCommand;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;
import mx.com.tiendaonline.producto.port.repository.ProductoRepository;

@RequiredArgsConstructor
public class ProductoUpdateService {

    private final ProductoDAO productoDAO;
    private final ProductoRepository repository;

    public Producto ejecutar(Long id, ProductoUpdateCommand command){
        var productoActual = productoDAO.getById(id);
        var productoUpdate = new Producto(
                productoActual.getId(),
                command.getNombre(),
                command.getPrecio(),
                command.getStock());
        return repository.update(id,productoUpdate);
    }
}
