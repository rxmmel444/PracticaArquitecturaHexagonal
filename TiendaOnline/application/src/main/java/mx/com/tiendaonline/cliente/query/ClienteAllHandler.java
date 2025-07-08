package mx.com.tiendaonline.cliente.query;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.service.ClienteCreateService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteAllHandler {

private ClienteAllHandler allHandler;
private final ClienteDtoMapper dtoMapper;
public List<ClienteDTO> ejecutar(){
    return allHandler.ejecutar();
}
    }
