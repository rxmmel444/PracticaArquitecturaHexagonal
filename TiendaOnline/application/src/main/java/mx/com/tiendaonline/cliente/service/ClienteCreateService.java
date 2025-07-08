package mx.com.tiendaonline.cliente.service;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.command.ClienteCreateCommand;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.repository.ClienteRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteCreateService {

    private final ClienteRepository crepository;
    private final ClienteDtoMapper clienteDtoMapper;



    public Cliente crear(ClienteCreateCommand createCommand) {
       var cliente = new Cliente(
               createCommand.getId(),
               createCommand.getNombre(),
               createCommand.getApellido(),
               createCommand.getEmail(),
               createCommand.getTelefono(),
               createCommand.getDireccion()
       );
       return crepository.create(cliente);
    }
}


