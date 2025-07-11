package mx.com.tiendaonline.cliente.adapter.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
import mx.com.tiendaonline.cliente.model.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducerAdapter {

    private final KafkaTemplate<String, ClienteDTO>kafkaTemplate;
    private final ClienteDtoMapper clienteDtoMapper;

    public void clienteCreado(Cliente cliente){
        ClienteDTO dto = clienteDtoMapper.domainToDto(cliente);
        kafkaTemplate.send("cliente_creado",dto.getEmail(),dto);
        log.info("cliente enviado a kafka",dto.getEmail());    }

}
