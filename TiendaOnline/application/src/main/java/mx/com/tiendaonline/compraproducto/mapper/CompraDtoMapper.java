/*
package mx.com.tiendaonline.compraproducto.mapper;

import mx.com.tiendaonline.compraproducto.model.dto.CompraDTO;
import mx.com.tiendaonline.compraproducto.model.dto.CompraProductoDTO;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProducto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CompraDtoMapper {

        @Mapping(source = "cliente", target = "cliente")
        @Mapping(source = "productos", target = "productos")
        @Mapping(source = "precioTotal.valor", target = "precioTotal")
        @Mapping(source = "fechaCompra.valor", target = "fechaCompra")
        CompraDTO domainToDto(Compra compra);

        @Mapping(source = "producto.id", target = "productoId")
        @Mapping(source = "cantidad.valor", target = "cantidad")
        @Mapping(source = "precioUnitario.valor", target = "precioUnitario")
        CompraProductoDTO   toDto(CompraProducto compraProducto);
    }


 */