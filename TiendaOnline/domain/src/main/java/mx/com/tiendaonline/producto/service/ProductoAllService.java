package mx.com.tiendaonline.producto.service;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;

import java.util.List;

@RequiredArgsConstructor
public class ProductoAllService {

    private final ProductoDAO productoDAO;

    public List<Producto> getProductos(){
        return productoDAO.getAllClientes();
    }

}
