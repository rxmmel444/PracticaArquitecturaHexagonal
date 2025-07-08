package mx.com.tiendaonline.cliente.query;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
import mx.com.tiendaonline.cliente.service.ClienteByIdService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteByIdHandler {

    private final ClienteByIdService byIdService;
    private final ClienteDtoMapper mapper;

    public ClienteDTO ejecutar(Long id){
        return mapper.domainToDto(byIdService.ejecutar(id));
    }
}
