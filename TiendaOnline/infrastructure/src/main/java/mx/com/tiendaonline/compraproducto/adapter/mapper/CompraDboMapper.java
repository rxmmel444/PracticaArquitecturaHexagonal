
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
      entity.setPrecioTotal(domain.getPrecioTotal());
      entity.setCliente(clienteDboMapper.toEntity(domain.getCliente()));
      entity.setProductos(productoEntities);

      //asignamos compra a cada producto
      productoEntities.forEach(productos -> productos.setCompra(entity));
        return entity;


    }



    public Compra toDomain(CompraEntity entity) {
        if (entity == null) {
            throw  new IllegalStateException("Por el momento la compra sin cliente asignado ");
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
                clienteDboMapper.toDomain(entity.getCliente()),
                productos
        );
    }
}