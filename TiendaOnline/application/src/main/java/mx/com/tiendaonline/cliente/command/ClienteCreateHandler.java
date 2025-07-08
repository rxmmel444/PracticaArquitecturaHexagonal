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
    private final ClienteDtoMapper dtoMapper;

    public ClienteCreateHandler(ClienteCreateService clienteCreateService, ClienteDtoMapper dtoMapper) {
        this.clienteCreateService = clienteCreateService;
        this.dtoMapper = dtoMapper;
    }


    public ClienteDTO crear (ClienteDTO clienteDTO){
        ClienteCreateCommand command = dtoMapper.toCommand(clienteDTO);
        Cliente domainCreated = clienteCreateService.crear(command);
       return dtoMapper.domainToDto(domainCreated);
    }
}
