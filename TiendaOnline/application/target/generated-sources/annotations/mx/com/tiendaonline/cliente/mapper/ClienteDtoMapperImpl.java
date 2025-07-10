package mx.com.tiendaonline.cliente.mapper;

import javax.annotation.processing.Generated;
import mx.com.tiendaonline.cliente.model.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-10T00:46:46-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class ClienteDtoMapperImpl implements ClienteDtoMapper {

    @Override
    public ClienteDTO domainToDto(Cliente domain) {
        if ( domain == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId( domain.getId() );
        clienteDTO.setNombre( domain.getNombre() );
        clienteDTO.setApellido( domain.getApellido() );
        clienteDTO.setEmail( domain.getEmail() );
        clienteDTO.setTelefono( domain.getTelefono() );
        clienteDTO.setDireccion( domain.getDireccion() );

        return clienteDTO;
    }

    @Override
    public ClienteCreateCommand toCommand(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        ClienteCreateCommand clienteCreateCommand = new ClienteCreateCommand();

        clienteCreateCommand.setId( clienteDTO.getId() );
        clienteCreateCommand.setNombre( clienteDTO.getNombre() );
        clienteCreateCommand.setApellido( clienteDTO.getApellido() );
        clienteCreateCommand.setEmail( clienteDTO.getEmail() );
        clienteCreateCommand.setTelefono( clienteDTO.getTelefono() );
        clienteCreateCommand.setDireccion( clienteDTO.getDireccion() );

        return clienteCreateCommand;
    }
}
