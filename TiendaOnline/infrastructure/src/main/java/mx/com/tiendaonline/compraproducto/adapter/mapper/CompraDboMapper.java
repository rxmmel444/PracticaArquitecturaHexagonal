
package mx.com.tiendaonline.compraproducto.adapter.mapper;

import mx.com.tiendaonline.cliente.adapter.mapper.ClienteDboMapper;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.compraproducto.adapter.entity.CompraEntity;
import mx.com.tiendaonline.compraproducto.adapter.entity.CompraProductoEntity;
import mx.com.tiendaonline.compraproducto.model.entity.*;
import mx.com.tiendaonline.producto.adapter.entity.ProductoEntity;
import mx.com.tiendaonline.producto.adapter.mapper.ProductoDboMapper;
import mx.com.tiendaonline.producto.model.entity.Producto;
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
    private final ClienteDtoMapper mapper;

    public CompraDboMapper(ClienteDboMapper clienteDboMapper, ProductoDboMapper productoDboMapper, ClienteDtoMapper mapper) {
        this.clienteDboMapper = clienteDboMapper;
        this.productoDboMapper = productoDboMapper;
        this.mapper = mapper;
    }


    public CompraEntity toDbo(Compra domain){
        if(domain==null){

            return null;
        }

        List<CompraProductoEntity> productoEntities = domain.getProductos().stream()
                .map(producto ->
                        new CompraProductoEntity(
                                null,
                                producto.getNombre(),
                                producto.getProductoId(),
                                producto.getCantidad(),
                                producto.getPrecioUnitario(),
                                null
                        )).collect(Collectors.toList());
        CompraEntity entity = new CompraEntity();
        entity.setId(domain.getId());
        entity.setCliente(entity.getCliente());
        entity.setPrecioTotal(domain.getPrecioTotal());
        entity.setFechaCompra(domain.getFechaCompra());
        entity.setProductos(productoEntities);
        return entity;
    }
    public Compra toDomain(CompraEntity entity) {
        if (entity == null) {
            return null;
        }

        List<CompraProducto> productos = entity.getProductos().stream()
                .map(productoEntity -> new CompraProducto(

                        productoEntity.getProductoId(),
                        productoEntity.getNombre(),
                        productoEntity.getPrecioUnitario(),
                        productoEntity.getCantidad()
                )).collect(Collectors.toList());

        return new Compra(
                entity.getId(),
                entity.getPrecioTotal(),
                entity.getFechaCompra(),
                entity.getCliente().getId(),
                productos
        );
    }
}


/*    public CompraEntity toEntity(Compra domain) {
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

            List<Producto> productos = entity.getProductos().stream().map(dboMapper::toEntityWithId)
                    .collect(Collectors.toList());
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
        }*/