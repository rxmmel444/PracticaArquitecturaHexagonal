package mx.com.tiendaonline.producto.mapper;

import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.producto.command.ProductoCreateCommand;
import mx.com.tiendaonline.producto.dto.ProductoDTO;
import mx.com.tiendaonline.producto.model.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProductoDtoMapper {


    @Mapping(source = "id" , target = "id")
    @Mapping(source = "nombre" , target = "nombre")
    @Mapping(source = "precio" , target = "precio")
    @Mapping(source = "stock" , target = "stock")

    ProductoDTO domainToDto(Producto domain);


    @Mapping(source = "id" , target = "id")
    @Mapping(source = "nombre" , target = "nombre")
    @Mapping(source = "precio" , target = "precio")
    @Mapping(source = "stock" , target = "stock")
    ProductoCreateCommand toCommand(ProductoDTO productoDTO);

}
