package mx.com.tiendaonline.cliente.adapter.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import mx.com.tiendaonline.cliente.model.dto.ClienteDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component

public class KafkaConsumerAdapter {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @KafkaListener(topics = "cliente_creado",groupId = "my-consumer-group")
    public void ConsumeMessage (String message) {
      try{
        ClienteDTO cliente = objectMapper.readValue(message, ClienteDTO.class);
        System.out.println("Enviado a correo a" + cliente.getEmail());
        System.out.println("Bienvenido a la tienda online,gracias por tu registro "+ cliente.getNombre());
        log.info("cliente Consumido" + cliente );
    }catch (Exception e){
      System.err.println("error de serializcion");
      e.printStackTrace();
      }
    }
}
