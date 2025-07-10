package mx.com.tiendaonline.producto.query;

import lombok.RequiredArgsConstructor;

import mx.com.tiendaonline.producto.mapper.ProductoDtoMapper;
import mx.com.tiendaonline.producto.model.dto.ProductoDTO;
import mx.com.tiendaonline.producto.service.ProductoByIdService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductoByIdHandler {

    private final ProductoByIdService productoByIdService;
    private final ProductoDtoMapper dtoMapper;


    public ProductoDTO ejecutar(Long id){
        return dtoMapper.domainToDto(productoByIdService.ejecutar(id));
    }

}
