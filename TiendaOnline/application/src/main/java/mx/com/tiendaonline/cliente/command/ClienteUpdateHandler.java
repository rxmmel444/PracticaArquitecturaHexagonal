package mx.com.tiendaonline.cliente.command;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
import mx.com.tiendaonline.cliente.service.ClienteUpdateService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteUpdateHandler {
private final ClienteUpdateService updateService;
private final ClienteDtoMapper mapper;

public ClienteDTO ejecutar(ClienteCreateCommand edit,Long id){
    return  mapper
            .domainToDto(updateService.ejecutar(edit,id));
}

}
