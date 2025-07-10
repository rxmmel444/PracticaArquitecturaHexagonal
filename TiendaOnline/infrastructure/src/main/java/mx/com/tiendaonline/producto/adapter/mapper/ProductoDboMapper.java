package mx.com.tiendaonline.producto.adapter.mapper;
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

    public Producto toDomain(ProductoEntity entity) {
        if (entity == null)
            return null;

        return new Producto(
                entity.getId(),
                entity.getNombre(),
                entity.getPrecio(),
                entity.getStock()
        );
    }
    public ProductoEntity toEntityWithId(Producto domain) {
        if (domain == null)
            return null;

        ProductoEntity entity = toEntity(domain);
        entity.setId(entity.getId());
        return entity;
    }

    public
}