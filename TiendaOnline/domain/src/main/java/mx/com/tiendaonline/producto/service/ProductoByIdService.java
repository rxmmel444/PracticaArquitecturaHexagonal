package mx.com.tiendaonline.producto.service;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;

@RequiredArgsConstructor
public class ProductoByIdService {


    private final ProductoDAO productoDAO;
    public Producto ejecutar (Long id){
        return productoDAO.getById(id);
    }
}
