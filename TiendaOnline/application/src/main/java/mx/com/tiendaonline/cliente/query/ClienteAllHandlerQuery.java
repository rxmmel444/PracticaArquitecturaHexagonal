package mx.com.tiendaonline.cliente.query;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.service.ClienteAllService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteAllHandlerQuery {
    private final ClienteAllService allService;
    private final ClienteDtoMapper dtoMapper;

    public List<ClienteDTO> ejecutar() {
       List<Cliente> clientes = allService.ejecutar();
        return clientes
                .stream()
                .map(dtoMapper::domainToDto)
                .collect(Collectors.toList());


    }
}

