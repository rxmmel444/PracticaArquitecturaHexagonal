package mx.com.tiendaonline.cliente.command;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.service.ClienteDeleteService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteDeleteHandler {
    private final ClienteDeleteService deleteService;


    public void ejecutar(Long id){
        deleteService.ejecutar(id);
    }
}
