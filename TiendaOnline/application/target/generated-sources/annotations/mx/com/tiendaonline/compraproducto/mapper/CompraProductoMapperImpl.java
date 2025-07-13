package mx.com.tiendaonline.compraproducto.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import mx.com.tiendaonline.compraproducto.model.dto.CompraProductoDTO;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProducto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-11T15:12:31-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class CompraProductoMapperImpl implements CompraProductoMapper {

    @Override
    public CompraProductoDTO toCompraDto(CompraProducto producto) {
        if ( producto == null ) {
            return null;
        }

        CompraProductoDTO compraProductoDTO = new CompraProductoDTO();

        compraProductoDTO.setProductoId( producto.getProductoId() );
        compraProductoDTO.setNombre( producto.getNombre() );
        compraProductoDTO.setCantidad( producto.getCantidad() );
        compraProductoDTO.setPrecioUnitario( producto.getPrecioUnitario() );

        return compraProductoDTO;
    }

    @Override
    public CompraProducto toDomain(CompraProductoDTO compraProductoDTO) {
        if ( compraProductoDTO == null ) {
            return null;
        }

        CompraProducto compraProducto = new CompraProducto();

        compraProducto.setProductoId( compraProductoDTO.getProductoId() );
        compraProducto.setNombre( compraProductoDTO.getNombre() );
        compraProducto.setPrecioUnitario( compraProductoDTO.getPrecioUnitario() );
        compraProducto.setCantidad( compraProductoDTO.getCantidad() );

        return compraProducto;
    }

    @Override
    public List<CompraProductoDTO> toDtoList(List<CompraProducto> productos) {
        if ( productos == null ) {
            return null;
        }

        List<CompraProductoDTO> list = new ArrayList<CompraProductoDTO>( productos.size() );
        for ( CompraProducto compraProducto : productos ) {
            list.add( toCompraDto( compraProducto ) );
        }

        return list;
    }

    @Override
    public List<CompraProducto> toDomainList(List<CompraProductoDTO> productos) {
        if ( productos == null ) {
            return null;
        }

        List<CompraProducto> list = new ArrayList<CompraProducto>( productos.size() );
        for ( CompraProductoDTO compraProductoDTO : productos ) {
            list.add( toDomain( compraProductoDTO ) );
        }

        return list;
    }
}
