package mx.com.tiendaonline.cliente.adapter.kafka;

import lombok.extern.slf4j.Slf4j;
import mx.com.tiendaonline.cliente.dto.ClienteDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumerAdapter {

    @KafkaListener(topics = "cliente_creado",groupId = "my-consumer-group")
    public void ConsumeMessage (ClienteDTO clienteDTO)
    {
        System.out.println("Enviado a correo a" + clienteDTO.getEmail());
        System.out.println("Bienvenido a la tienda online,gracias por tu registro");
        log.info("cliente Consumido" + clienteDTO );
    }
}
