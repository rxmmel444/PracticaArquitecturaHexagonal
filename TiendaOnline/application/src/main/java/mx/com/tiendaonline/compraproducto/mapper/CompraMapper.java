package mx.com.tiendaonline.compraproducto.mapper;

import mx.com.tiendaonline.compraproducto.model.dto.CompraDTO;
import mx.com.tiendaonline.compraproducto.model.dto.CompraProductoDTO;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProducto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CompraMapper {

    public CompraDTO toDTO (Compra compra){
       return new CompraDTO(
               compra.getId().getId(),
               compra.getFechaCompra().getFechaCompra(),
               compra.getPrecioTotal().getPrecioTotal(),
               compraProductoDTOList(compra.getProductos().getProductos()),
               compra.getId().getId()
       );
    }

    public List<CompraProductoDTO> compraProductoDTOList (List<CompraProducto> domain){
        return domain.stream().map(
                dom -> new CompraProductoDTO(
                        dom.getProductoId().getId(),
                        dom.getNombre().getNombre(),
                        dom.getCantidad().getCantidad(),
                        dom.getPrecioUnitario().getPrecioUnitario())
        ).toList();
    }
}
