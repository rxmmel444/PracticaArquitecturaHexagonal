package mx.com.tiendaonline.cliente.service;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;

import java.util.List;


@RequiredArgsConstructor
public class ClienteAllService {
    private final ClienteDAO clienteDAO;
    public List<Cliente> ejecutar(){
      return clienteDAO.getAllClientes();
    }
}
