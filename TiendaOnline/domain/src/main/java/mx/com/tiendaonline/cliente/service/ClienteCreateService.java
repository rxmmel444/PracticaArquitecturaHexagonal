package mx.com.tiendaonline.cliente.service;
import com.sun.jdi.request.DuplicateRequestException;
import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.model.exception.ClienteException;
import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;
import mx.com.tiendaonline.cliente.port.event.ClienteEventCreate;
import mx.com.tiendaonline.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
public class ClienteCreateService {

    private final ClienteRepository crepository;
   private final ClienteEventCreate event;
    private final ClienteDAO dao;

    public Cliente crear(ClienteCreateCommand createCommand) {

        if(dao.existByEmail(createCommand.getEmail())){

            throw new ClienteException("el email ya eexite mi bro");
        }
        var cliente = new Cliente(
               createCommand.getId(),
               createCommand.getNombre(),
               createCommand.getApellido(),
               createCommand.getEmail(),
               createCommand.getTelefono(),
               createCommand.getDireccion()
       );
       event.clienteCreadoEvent(cliente);
       return crepository.create(cliente);
    }
}


