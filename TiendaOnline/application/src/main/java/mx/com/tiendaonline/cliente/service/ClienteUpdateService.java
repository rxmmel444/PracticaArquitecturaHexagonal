package mx.com.tiendaonline.cliente.service;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.command.ClienteCreateCommand;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;
import mx.com.tiendaonline.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
public class ClienteUpdateService {



    private final ClienteDAO dao;
    private final ClienteRepository repository;

    public Cliente ejecutar(ClienteCreateCommand command , Long id){

        var cliente= dao.getById(id);
        var clienteUpdate = new Cliente(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getDireccion());


return repository.update(clienteUpdate);

    }
}
