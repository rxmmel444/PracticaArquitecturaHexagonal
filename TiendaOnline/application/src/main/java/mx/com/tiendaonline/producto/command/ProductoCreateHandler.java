package mx.com.tiendaonline.producto.command;

import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.producto.dto.ProductoDTO;
import mx.com.tiendaonline.producto.mapper.ProductoDtoMapper;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.service.ProductoCreateService;
import org.springframework.stereotype.Component;


@Component
public class ProductoCreateHandler {
    private final ProductoCreateService productoCreateService;
    private final ProductoDtoMapper dtoMapper;

    public ProductoCreateHandler(ProductoCreateService productoCreateService, ProductoDtoMapper dtoMapper) {
        this.productoCreateService = productoCreateService;
        this.dtoMapper = dtoMapper;
    }


    public ProductoDTO crear (ProductoDTO productoDTO){
        ProductoCreateCommand command = dtoMapper.toCommand(productoDTO);
        Producto domainCreated = productoCreateService.crear(command);
       return dtoMapper.domainToDto(domainCreated);
    }
}
