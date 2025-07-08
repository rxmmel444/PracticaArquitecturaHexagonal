package mx.com.tiendaonline.producto.adapter.mapper;

import mx.com.tiendaonline.cliente.adapter.entity.ClienteEntity;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.producto.adapter.entity.ProductoEntity;
import mx.com.tiendaonline.producto.model.entity.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoDboMapper {

    public ProductoEntity toEntity(Producto domain){
        if(domain == null) {
            return null;
        }
        return new ProductoEntity(
                domain.getId(),
                domain.getNombre(),
                domain.getPrecio(),
                domain.getStock()

        );
    }

    public Cliente toDomain(ClienteEntity entity) {
        if (entity == null)
            return null;

        return new Cliente(
                entity.getId(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getEmail(),
                entity.getTelefono(),
                entity.getDireccion()
        );
    }
    public ProductoEntity toEntityWithId(Producto domain) {
        if (domain == null)
            return null;

        ProductoEntity entity = toEntity(domain);
        entity.setId(entity.getId());
        return entity;
    }
}