
package mx.com.tiendaonline.compraproducto.adapter.mapper;

import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.compraproducto.adapter.entity.CompraEntity;
import mx.com.tiendaonline.compraproducto.adapter.entity.CompraProductoEntity;
import mx.com.tiendaonline.compraproducto.model.entity.*;
import mx.com.tiendaonline.producto.adapter.mapper.ProductoDboMapper;
import mx.com.tiendaonline.producto.model.entity.Producto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CompraDboMapper {

    private ClienteDtoMapper mapper;
    private ProductoDboMapper dboMapper;
    public CompraEntity toEntity(Compra domain) {
        if (domain == null) {
            return null;
        }
        CompraEntity compraEntity = new CompraEntity();
        compraEntity.setCliente(domain.getCliente().getId(id));
        compraEntity.setPrecioTotal(domain.getPrecioTotal().getPrecioTotal());
        compraEntity.setFechaCompra(domain.getFechaCompra().getFechaCompra());

        List<CompraProductoEntity> detalles = domain.getProductos().stream()
                .map(productos ->{
                    CompraProductoEntity entity = new CompraProductoEntity();
                    entity.setId(productos.getProducto().getId());
                    entity.setCantidad(productos.getCantidad().getCantidad());
                    entity.setPrecioUnitario(productos.getPrecioUnitario().getPrecioUnitario());
                    entity.setCompra(compraEntity);
                    return entity;
                }).toList();
        compraEntity.setProductos(detalles);
        return compraEntity;
    }

    // De entidad a dominio (para usar en lógica)
    public Compra toDomain(CompraEntity entity){
            if (entity == null) {
                return null;
            }

            List<Producto> productos = entity.getProductos().stream().map()
            Compra compras = new Compra();
        compras.setId(new CompraId(entity.getId()));
        compras.setCliente(ClienteDtoMapper.toDomain(entity.getCliente())); // si tienes un mapper para Cliente

        compras.setPrecioTotal(new PrecioTotal(entity.getPrecioTotal()));
        compras.setFechaCompra(new FechaCompra(entity.getFechaCompra()));

            List<CompraProducto> detalles = entity.getProductos().stream()
                    .map(producto->{
                        CompraProducto compraP = new CompraProducto();
                        compraP.setProducto(producto.getProducto());
                        compraP.setCantidad(producto.getCantidad());
                        compraP.setPrecioUnitario(producto.getPrecioUnitario());
                        return compraP;
                    }).toList();
        }
}
