package mx.com.tiendaonline.cliente.adapter.jpa.dao;

import mx.com.tiendaonline.cliente.adapter.jpa.ClienteJpaAdapterRepository;
import mx.com.tiendaonline.cliente.adapter.mapper.ClienteDboMapper;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteDAO  implements mx.com.tiendaonline.cliente.port.dao.ClienteDAO {

   private final ClienteJpaAdapterRepository adapterRepository;
   private final ClienteDboMapper clienteDboMapper;

    public ClienteDAO(ClienteJpaAdapterRepository adapterRepository, ClienteDboMapper clienteDboMapper) {
        this.adapterRepository = adapterRepository;
        this.clienteDboMapper = clienteDboMapper;
    }


    @Override
    public List<Cliente> getAllClientes() {
        return List.of();
    }

    @Override
    public Cliente getById(Long id) {
        return null;
    }
}
