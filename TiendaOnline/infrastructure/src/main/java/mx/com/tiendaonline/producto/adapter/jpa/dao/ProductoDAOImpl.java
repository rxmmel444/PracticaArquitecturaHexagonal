package mx.com.tiendaonline.producto.adapter.jpa.dao;

import mx.com.tiendaonline.cliente.adapter.jpa.ClienteJpaAdapterRepository;
import mx.com.tiendaonline.cliente.adapter.mapper.ClienteDboMapper;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.producto.adapter.jpa.ProductoJpaAdapterRepository;
import mx.com.tiendaonline.producto.adapter.mapper.ProductoDboMapper;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;

import java.util.List;


public class ProductoDAOImpl implements ProductoDAO {

   private final ProductoJpaAdapterRepository adapterRepository;
   private final ProductoDboMapper clienteDboMapper;

    public ProductoDAOImpl(ProductoJpaAdapterRepository adapterRepository, ProductoDboMapper clienteDboMapper) {
        this.adapterRepository = adapterRepository;
        this.clienteDboMapper = clienteDboMapper;
    }


    @Override
    public List<Producto> getAllClientes() {
        return List.of();
    }

    @Override
    public Producto getById(Long id) {
        return null;
    }
}
