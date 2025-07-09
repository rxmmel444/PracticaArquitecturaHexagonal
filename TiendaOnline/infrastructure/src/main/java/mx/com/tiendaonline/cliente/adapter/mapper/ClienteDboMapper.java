package mx.com.tiendaonline.cliente.adapter.mapper;

import mx.com.tiendaonline.cliente.adapter.entity.ClienteEntity;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteDboMapper {

    public ClienteEntity toEntity(Cliente domain){
        if(domain == null) {
            return null;
        }
        return new ClienteEntity(
                domain.getId(),
                domain.getNombre(),
                domain.getApellido(),
                domain.getEmail(),
                domain.getTelefono(),
                domain.getDireccion()
        );
    }

    public Cliente toDomain(ClienteEntity entity) {
        if (entity == null)
            return null;

        return new Cliente(
                entity.getId(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getEmail(),
                entity.getTelefono(),
                entity.getDireccion()
        );
    }
    public ClienteEntity toEntityWithId(Cliente domain) {
        if (domain == null)
            return null;

        ClienteEntity entity = toEntity(domain);
        entity.setId(domain.getId());
        return entity;
    }
}