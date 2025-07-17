package mx.com.tiendaonline.cliente.adapter.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import mx.com.tiendaonline.cliente.adapter.mapper.ClienteDboMapper;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
import mx.com.tiendaonline.cliente.model.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.event.ClienteCorreoBienvenida;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumerAdapter {
private ClienteDtoMapper clienteDtoMapper;
private ClienteCorreoBienvenida bienvenida;


    @KafkaListener(topics = "cliente_creado",groupId = "my-consumer-group",
            containerFactory = "clienteKafkaListenerContainerFactory")
    public void ConsumeMessageClienteCreado (ClienteDTO dto) {
      try{
        ClienteCreateCommand cliente = clienteDtoMapper.toCommand(dto);


        bienvenida.enviarCorrreoBienvenida(cliente);
        log.info("cliente Consumido {}" , cliente );
    }catch (Exception e){
            log.error("error de serializacion");
      }
    }
}
