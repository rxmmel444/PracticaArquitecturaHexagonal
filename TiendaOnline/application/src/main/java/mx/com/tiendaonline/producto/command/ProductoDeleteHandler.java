package mx.com.tiendaonline.producto.command;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.producto.service.ProductoDeleteService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductoDeleteHandler {
    private final ProductoDeleteService deleteService;
    public void ejecutar(Long id){
        deleteService.ejecutar(id);
    }
}
