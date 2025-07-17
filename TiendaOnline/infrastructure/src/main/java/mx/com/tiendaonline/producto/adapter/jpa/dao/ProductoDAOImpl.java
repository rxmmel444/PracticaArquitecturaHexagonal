package mx.com.tiendaonline.producto.adapter.jpa.dao;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mx.com.tiendaonline.producto.adapter.entity.ProductoEntity;
import mx.com.tiendaonline.producto.adapter.jpa.ProductoJpaAdapterRepository;
import mx.com.tiendaonline.producto.adapter.mapper.ProductoDboMapper;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
public class ProductoDAOImpl implements ProductoDAO {

   private final ProductoJpaAdapterRepository adapterRepository;
   private final ProductoDboMapper productoDboMapper;



    @Override
    public List<Producto> getAllClientes() {
       return adapterRepository.findAll()
               .stream()
               .map(productoDboMapper::toDomain)
               .collect(Collectors.toList());
    }

    @Override
    public Producto getById(Long id) {
        ProductoEntity entity = adapterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto con ID " + id + " no encontrado"));
        return productoDboMapper.toDomain(entity);
    }
@Transactional
    @Override
    public void actualziarStock(Long id, Integer cantidad) {
        ProductoEntity entity = adapterRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("Producto no encontrado con Id " + id  ));
        entity.setStock(cantidad);
        adapterRepository.save(entity);
    }
}
