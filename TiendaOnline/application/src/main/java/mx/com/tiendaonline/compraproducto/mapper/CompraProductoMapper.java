package mx.com.tiendaonline.compraproducto.mapper;

import mx.com.tiendaonline.compraproducto.model.dto.CompraProductoDTO;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProducto;
import mx.com.tiendaonline.producto.model.dto.ProductoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CompraProductoMapper {

    CompraProductoDTO toCompraDto(CompraProducto producto);
    CompraProducto toDomain(CompraProductoDTO compraProductoDTO);

    List<CompraProductoDTO> toDtoList(List<CompraProducto>productos);
    List<CompraProducto>toDomainList(List<CompraProductoDTO> productos);

}
