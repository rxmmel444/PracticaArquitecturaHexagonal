package mx.com.tiendaonline.producto.adapter.jpa.repository;

import mx.com.tiendaonline.cliente.adapter.entity.ClienteEntity;
import mx.com.tiendaonline.cliente.adapter.jpa.ClienteJpaAdapterRepository;
import mx.com.tiendaonline.cliente.adapter.mapper.ClienteDboMapper;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.repository.ClienteRepository;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.repository.ProductoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRespositoryImpl implements ProductoRepository {
   private final ClienteJpaAdapterRepository adapterRepository;
   private final ClienteDboMapper clienteDboMapper;

    public ProductoRespositoryImpl(ClienteJpaAdapterRepository adapterRepository, ClienteDboMapper clienteDboMapper) {
        this.adapterRepository = adapterRepository;
        this.clienteDboMapper = clienteDboMapper;
    }


    @Override
    public Producto create(Producto producto) {
        return null;
    }

    @Override
    public Producto update(Long id, Producto producto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
