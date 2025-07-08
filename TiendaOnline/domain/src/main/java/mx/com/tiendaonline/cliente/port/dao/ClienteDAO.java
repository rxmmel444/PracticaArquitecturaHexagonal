package mx.com.tiendaonline.cliente.port.dao;

import mx.com.tiendaonline.cliente.model.entity.Cliente;

import java.util.List;

public interface ClienteDAO {

    List<Cliente> getAllClientes();

    Cliente getById (Long id);
}
