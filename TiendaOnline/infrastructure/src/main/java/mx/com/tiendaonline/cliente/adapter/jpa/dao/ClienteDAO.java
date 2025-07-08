package mx.com.tiendaonline.cliente.adapter.jpa.dao;

import mx.com.tiendaonline.cliente.adapter.jpa.ClienteJpaAdapterRepository;
import mx.com.tiendaonline.cliente.adapter.mapper.ClienteDboMapper;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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
        return adapterRepository.findAll()
                .stream()
                .map(clienteDboMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Cliente getById(Long id) {
        var optionalUser = adapterRepository.findById(id);
        return clienteDboMapper.toDomain(optionalUser.get());
    }
}
