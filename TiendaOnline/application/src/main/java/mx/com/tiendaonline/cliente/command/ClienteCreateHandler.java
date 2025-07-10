package mx.com.tiendaonline.cliente.command;
import mx.com.tiendaonline.cliente.model.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.tiendaonline.cliente.service.ClienteCreateService;
import lombok.RequiredArgsConstructor;

import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
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
