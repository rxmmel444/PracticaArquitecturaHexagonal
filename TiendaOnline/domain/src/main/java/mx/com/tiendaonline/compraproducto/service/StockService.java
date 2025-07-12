package mx.com.tiendaonline.compraproducto.service;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;
import mx.com.tiendaonline.producto.port.repository.ProductoRepository;

@RequiredArgsConstructor
public class StockService {
    private final ProductoDAO productoDAO;
    private  final ProductoRepository repository;

    public void descontarStock(Long productoId,Integer cantidad){
        Producto producto= productoDAO.getById(productoId);
        if (producto == null){
            throw new IllegalArgumentException("producto no disponible por ahora");
        }
        if(producto.getStock() < cantidad){
            throw new IllegalStateException("no hay stock suficiente por el momento");
        }

        productoDAO.actualziarStock(productoId,producto.getStock() - cantidad);
        repository.create(producto);

    }

}
