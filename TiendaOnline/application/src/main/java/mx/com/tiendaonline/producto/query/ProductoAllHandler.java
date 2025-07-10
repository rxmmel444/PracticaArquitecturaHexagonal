package mx.com.tiendaonline.producto.query;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;

import mx.com.tiendaonline.producto.mapper.ProductoDtoMapper;
import mx.com.tiendaonline.producto.model.dto.ProductoDTO;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.service.ProductoAllService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductoAllHandler {

    private final ProductoAllService allService;
    private final ProductoDtoMapper mapper;

    public List<ProductoDTO> ejecutar(){
        List<Producto> productos = allService.getProductos();
                return productos.stream()
                        .map(mapper::domainToDto)
                        .collect(Collectors.toList());
    }
}
