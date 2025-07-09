package mx.com.tiendaonline.cliente.command;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.service.ClienteCreateService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteCreateHandler {
    private final ClienteCreateService clienteCreateService;
    private final ClienteDtoMapper dtoMapper;



    public ClienteDTO crear(ClienteCreateCommand command) {
        return dtoMapper
                .domainToDto(clienteCreateService.crear(command));

    }
}
