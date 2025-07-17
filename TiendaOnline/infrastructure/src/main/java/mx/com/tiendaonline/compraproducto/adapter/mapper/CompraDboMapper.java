
package mx.com.tiendaonline.compraproducto.adapter.mapper;

import mx.com.tiendaonline.cliente.adapter.entity.ClienteEntity;
import mx.com.tiendaonline.cliente.adapter.mapper.ClienteDboMapper;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.model.entity.ClienteEmail;
import mx.com.tiendaonline.compraproducto.adapter.entity.CompraEntity;
import mx.com.tiendaonline.compraproducto.adapter.entity.CompraProductoEntity;
import mx.com.tiendaonline.compraproducto.model.entity.*;
import mx.com.tiendaonline.producto.adapter.entity.ProductoEntity;
import mx.com.tiendaonline.producto.adapter.mapper.ProductoDboMapper;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.model.entity.ProductoId;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CompraDboMapper {

    private final ClienteDboMapper clienteDboMapper;
    private final ProductoDboMapper productoDboMapper;

    public CompraDboMapper(ClienteDboMapper clienteDboMapper, ProductoDboMapper productoDboMapper) {
        this.clienteDboMapper = clienteDboMapper;
        this.productoDboMapper = productoDboMapper;

    }


    public CompraEntity toDbo(Compra domain) {
        CompraEntity e = new CompraEntity();
        e.setId(domain.getId().getId());
        e.setPrecioTotal(domain.getPrecioTotal().getPrecioTotal());
        e.setFechaCompra(domain.getFechaCompra().getFechaCompra());
        e.setCliente(clienteDboMapper.toEntity(domain.getCliente()));
        var prod = domain.getProductos().getProductos().stream()
                .map(p -> {
                    var pe = new CompraProductoEntity();
                    pe.setProductoId(p.getProductoId().getId());
                    pe.setNombre(p.getNombre().getNombre());
                    pe.setCantidad(p.getCantidad().getCantidad());
                    pe.setPrecioUnitario(p.getPrecioUnitario().getPrecioUnitario());
                    pe.setCompra(e);
                    return pe;
                }).toList();
        e.setProductos(prod);
        return e;
    }

    public Compra toDomain(CompraEntity e) {
        Cliente cl = clienteDboMapper.toDomain(e.getCliente());
        List<CompraProducto> prod = e.getProductos().stream()
                .map(pe -> new CompraProducto(
                        new CProductoId(pe.getProductoId()),
                        new CProductoNombre(pe.getNombre()),
                        new CProductoCantidad(pe.getCantidad()),
                        new CProductoPrecio(pe.getPrecioUnitario())
                )).toList();

        return new Compra(
                        new CompraId(e.getId()),
                        cl,
                new CompraPrecioTotal(e.getPrecioTotal()),
                new CompraFechaCompra(e.getFechaCompra()),
                prod
                );
    }
}