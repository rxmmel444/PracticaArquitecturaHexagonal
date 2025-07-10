package mx.com.tiendaonline.producto.command;

import lombok.RequiredArgsConstructor;

import mx.com.tiendaonline.producto.mapper.ProductoDtoMapper;
import mx.com.tiendaonline.producto.model.dto.ProductoDTO;
import mx.com.tiendaonline.producto.model.dto.command.ProductoUpdateCommand;
import mx.com.tiendaonline.producto.service.ProductoUpdateService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
@RequiredArgsConstructor
public class ProductoUpdateHandler {

private final ProductoUpdateService updateService;
private final ProductoDtoMapper dtoMapper;

public ProductoDTO ejecutar(ProductoUpdateCommand command, Long id){
    return dtoMapper
            .domainToDto(updateService.ejecutar(id,command));
}
}
