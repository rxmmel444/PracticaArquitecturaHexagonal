package mx.com.tiendaonline.cliente.port.repository;


import mx.com.tiendaonline.cliente.model.entity.Cliente;

public interface ClienteRepository {

    Cliente create (Cliente cliente);
    Cliente update (Cliente cliente);
    void delete (Long id);
}
