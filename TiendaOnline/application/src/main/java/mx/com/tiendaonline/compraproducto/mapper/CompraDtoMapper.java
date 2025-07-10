
package mx.com.tiendaonline.compraproducto.mapper;

import mx.com.tiendaonline.compraproducto.model.dto.CompraDTO;
import mx.com.tiendaonline.compraproducto.model.dto.CompraProductoDTO;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProducto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")

public interface CompraDtoMapper {

    @Mapping(source = "id", target = "id")
        @Mapping(source = "cliente", target = "cliente")
        @Mapping(source = "productos", target = "productos")
        @Mapping(source = "fechaCompra", target = "fechaCompra")
        CompraDTO domainToDto(Compra compra);
        @Mapping(source = "producto", target = "producto")
        @Mapping(source = "cantidad", target = "cantidad")
        @Mapping(source = "precioUnitario", target = "precioUnitario")
        CompraProductoDTO   toDto(CompraProducto compraProducto);
    }


