package mx.com.tiendaonline.producto.mapper;

import javax.annotation.processing.Generated;
import mx.com.tiendaonline.producto.model.dto.ProductoDTO;
import mx.com.tiendaonline.producto.model.dto.command.ProductoCreateCommand;
import mx.com.tiendaonline.producto.model.entity.Producto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-10T00:58:47-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class ProductoDtoMapperImpl implements ProductoDtoMapper {

    @Override
    public ProductoDTO domainToDto(Producto domain) {
        if ( domain == null ) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setId( domain.getId() );
        productoDTO.setNombre( domain.getNombre() );
        productoDTO.setPrecio( domain.getPrecio() );
        productoDTO.setStock( domain.getStock() );

        return productoDTO;
    }

    @Override
    public ProductoCreateCommand toCommand(ProductoDTO productoDTO) {
        if ( productoDTO == null ) {
            return null;
        }

        ProductoCreateCommand productoCreateCommand = new ProductoCreateCommand();

        productoCreateCommand.setId( productoDTO.getId() );
        productoCreateCommand.setNombre( productoDTO.getNombre() );
        productoCreateCommand.setPrecio( productoDTO.getPrecio() );
        productoCreateCommand.setStock( productoDTO.getStock() );

        return productoCreateCommand;
    }
}
