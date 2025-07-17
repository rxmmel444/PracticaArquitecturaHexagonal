package mx.com.tiendaonline.compraproducto.service;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;
import mx.com.tiendaonline.producto.port.repository.ProductoRepository;

@RequiredArgsConstructor
public class StockService {
    private final ProductoDAO productoDAO;
    private  final ProductoRepository repository;

    public Producto descontarStock(Long productoId,Integer cantidad){
        var producto= productoDAO.getById(productoId);
        if (producto == null){
            throw new IllegalArgumentException("producto no disponible por ahora");
        }
  int actualizarStock = producto.getStock() - cantidad;
        if (actualizarStock < 0){
            throw new IllegalArgumentException("Stock insuficiente");

        }

        return    repository.update(productoId,producto);

    }

}
