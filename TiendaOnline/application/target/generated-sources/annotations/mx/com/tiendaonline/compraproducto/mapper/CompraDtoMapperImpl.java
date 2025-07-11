package mx.com.tiendaonline.compraproducto.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import mx.com.tiendaonline.compraproducto.model.dto.CompraDTO;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProducto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-10T23:55:36-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class CompraDtoMapperImpl implements CompraDtoMapper {

    @Override
    public CompraDTO toDto(Compra compra) {
        if ( compra == null ) {
            return null;
        }

        CompraDTO compraDTO = new CompraDTO();

        compraDTO.setClienteId( compra.getClienteId() );
        List<CompraProducto> list = compra.getProductos();
        if ( list != null ) {
            compraDTO.setProductos( new ArrayList<CompraProducto>( list ) );
        }
        compraDTO.setPrecioTotal( compra.getPrecioTotal() );
        compraDTO.setFechaCompra( compra.getFechaCompra() );
        compraDTO.setId( compra.getId() );

        return compraDTO;
    }

    @Override
    public Compra toDomain(CompraDTO compraDTO) {
        if ( compraDTO == null ) {
            return null;
        }

        Compra compra = new Compra();

        compra.setId( compraDTO.getId() );
        compra.setPrecioTotal( compraDTO.getPrecioTotal() );
        compra.setFechaCompra( compraDTO.getFechaCompra() );
        compra.setClienteId( compraDTO.getClienteId() );
        List<CompraProducto> list = compraDTO.getProductos();
        if ( list != null ) {
            compra.setProductos( new ArrayList<CompraProducto>( list ) );
        }

        return compra;
    }
}
