package mx.com.tiendaonline.producto.adapter.jpa.repository;

import lombok.AllArgsConstructor;
import mx.com.tiendaonline.cliente.adapter.entity.ClienteEntity;
import mx.com.tiendaonline.cliente.adapter.jpa.ClienteJpaAdapterRepository;
import mx.com.tiendaonline.cliente.adapter.mapper.ClienteDboMapper;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.repository.ClienteRepository;
import mx.com.tiendaonline.producto.adapter.entity.ProductoEntity;
import mx.com.tiendaonline.producto.adapter.jpa.ProductoJpaAdapterRepository;
import mx.com.tiendaonline.producto.adapter.mapper.ProductoDboMapper;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.repository.ProductoRepository;
import org.springframework.stereotype.Repository;
@AllArgsConstructor
@Repository
public class ProductoRespositoryImpl implements ProductoRepository {
   private final ProductoJpaAdapterRepository adapterRepository;
   private final ProductoDboMapper productoDboMapper;



    @Override
    public Producto create(Producto producto) {
        ProductoEntity entity = productoDboMapper.toEntity(producto);
        ProductoEntity save = adapterRepository.save(entity);
        return  productoDboMapper.toDomain(save);

    }

    @Override
    public Producto update(Long id, Producto producto) {
       ProductoEntity entity = productoDboMapper.toEntity(producto);
       ProductoEntity update = adapterRepository.save(entity);
       return productoDboMapper.toDomain(update);
    }

    @Override
    public void delete(Long id) {
adapterRepository.deleteById(id);
    }
}
