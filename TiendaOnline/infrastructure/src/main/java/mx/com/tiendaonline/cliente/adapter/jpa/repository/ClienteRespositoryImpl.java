package mx.com.tiendaonline.cliente.adapter.jpa.repository;

import mx.com.tiendaonline.cliente.adapter.entity.ClienteEntity;
import mx.com.tiendaonline.cliente.adapter.jpa.ClienteJpaAdapterRepository;
import mx.com.tiendaonline.cliente.adapter.mapper.ClienteDboMapper;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.repository.ClienteRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRespositoryImpl implements ClienteRepository {
   private final ClienteJpaAdapterRepository adapterRepository;
   private final ClienteDboMapper clienteDboMapper;

    public ClienteRespositoryImpl(ClienteJpaAdapterRepository adapterRepository, ClienteDboMapper clienteDboMapper) {
        this.adapterRepository = adapterRepository;
        this.clienteDboMapper = clienteDboMapper;
    }

    @Override
    public Cliente create(Cliente cliente) {
        ClienteEntity entity = clienteDboMapper.toEntity(cliente);
        ClienteEntity save = adapterRepository.save(entity);
        return clienteDboMapper.toDomain(save);
    }

    @Override
    public Cliente update(Cliente cliente) {
        ClienteEntity entity = clienteDboMapper.toEntityWithId(cliente);
        ClienteEntity updated = adapterRepository.save(entity);
        return clienteDboMapper.toDomain(updated);
    }


    @Override
    public void delete(Long id) {

        adapterRepository.deleteById(id);
    }
}
