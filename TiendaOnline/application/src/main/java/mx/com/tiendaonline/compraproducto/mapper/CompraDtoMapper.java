package mx.com.tiendaonline.compraproducto.mapper;
import mx.com.tiendaonline.compraproducto.model.dto.CompraDTO;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CompraDtoMapper {



    CompraDTO toDto (Compra compra);
    Compra toDomain(CompraDTO compraDTO);


    }


