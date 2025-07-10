package mx.com.tiendaonline.producto.command;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.model.entity.Cliente;

import mx.com.tiendaonline.producto.mapper.ProductoDtoMapper;

import mx.com.tiendaonline.producto.model.dto.ProductoDTO;
import mx.com.tiendaonline.producto.model.dto.command.ProductoCreateCommand;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.service.ProductoCreateService;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ProductoCreateHandler {
    private final ProductoCreateService productoCreateService;
    private final ProductoDtoMapper dtoMapper;



    public ProductoDTO crear (ProductoCreateCommand command){
       return dtoMapper
               .domainToDto(productoCreateService.crear(command));
    }
}
