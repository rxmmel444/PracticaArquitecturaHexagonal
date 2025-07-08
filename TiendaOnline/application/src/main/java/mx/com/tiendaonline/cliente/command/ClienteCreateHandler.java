package mx.com.tiendaonline.cliente.command;

import lombok.Data;
import mx.com.tiendaonline.cliente.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.service.ClienteCreateService;
import org.springframework.stereotype.Component;

@Component
public class ClienteCreateHandler {
    private final ClienteCreateService clienteCreateService;

    public ClienteCreateHandler(ClienteCreateService clienteCreateService) {
        this.clienteCreateService = clienteCreateService;
    }

    public Cliente crear(ClienteCreateCommand command) {
        return clienteCreateService.crear(command);
    }
}
