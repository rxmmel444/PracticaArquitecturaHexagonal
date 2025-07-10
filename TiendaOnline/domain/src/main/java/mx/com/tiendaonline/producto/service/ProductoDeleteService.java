package mx.com.tiendaonline.producto.service;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;
import mx.com.tiendaonline.producto.port.repository.ProductoRepository;

@RequiredArgsConstructor
public class ProductoDeleteService {
private final ProductoRepository repository;
private final ProductoDAO productoDAO;

public void ejecutar (Long id){

var producto = productoDAO.getById(id);
repository.delete(producto.getId());
}
}
