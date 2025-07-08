package mx.com.tiendaonline.cliente.adapter.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.tiendaonline.cliente.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.event.ClienteEventCreate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ClienteEventeCreateImpl  implements ClienteEventCreate {

   private final KafkaTemplate<String,ClienteDTO> kafkaTemplate;
   private final ClienteDtoMapper clienteDtoMapper;
    @Override
    public void clienteCreadoEvent(Cliente cliente) {
       ClienteDTO dto = clienteDtoMapper.domainToDto(cliente);
        kafkaTemplate.send("cliente_creado",dto.getEmail(), dto);
        log.info("Cliente creado y avisado mediante KAFKA",dto.getEmail());

    }
}
