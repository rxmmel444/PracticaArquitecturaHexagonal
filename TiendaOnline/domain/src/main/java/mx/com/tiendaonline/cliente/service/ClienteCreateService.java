package mx.com.tiendaonline.cliente.service;
import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.event.ClienteEventCreate;
import mx.com.tiendaonline.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
public class ClienteCreateService {

    private final ClienteRepository crepository;
   // private final ClienteDtoMapper clienteDtoMapper;
    private final ClienteEventCreate event;


    public Cliente crear(ClienteCreateCommand createCommand) {
       var cliente = new Cliente(
               createCommand.getId(),
               createCommand.getNombre(),
               createCommand.getApellido(),
               createCommand.getEmail(),
               createCommand.getTelefono(),
               createCommand.getDireccion()
       );
      // event.clienteCreadoEvent(cliente);
       return crepository.create(cliente);
    }
}


