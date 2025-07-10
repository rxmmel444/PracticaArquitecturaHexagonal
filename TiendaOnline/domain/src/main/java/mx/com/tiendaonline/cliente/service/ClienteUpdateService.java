package mx.com.tiendaonline.cliente.service;


import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.model.dto.command.ClienteUpdateCommand;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;
import mx.com.tiendaonline.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor

public class ClienteUpdateService {

    private final ClienteDAO dao;
    private final ClienteRepository repository;

    public Cliente ejecutar(ClienteUpdateCommand command , Long id){

        var clienteActual= dao.getById(id);
        var clienteUpdate = new Cliente(
                clienteActual.getId(),
                command.getNombre(),
                command.getApellido(),
                command.getEmail(),
                command.getTelefono(),
                command.getDireccion());


return repository.update(id,clienteUpdate);

    }
}
