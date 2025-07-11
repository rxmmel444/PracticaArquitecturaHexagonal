
package mx.com.tiendaonline.compraproducto.mapper;

import mx.com.tiendaonline.compraproducto.model.dto.CompraDTO;
import mx.com.tiendaonline.compraproducto.model.dto.CompraProductoDTO;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraCreateCommand;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraProductoCommand;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProducto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")

public interface CompraDtoMapper {



    CompraDTO toDto (Compra compra);
    Compra toDomain(CompraDTO compraDTO);


    }


