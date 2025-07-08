package mx.com.tiendaonline.message.adapter.kafka.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.tiendaonline.cliente.dto.ClienteDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducerAdapter {

    private final KafkaTemplate<String,ClienteDTO>kafkaTemplate;

    public void clienteCreado(ClienteDTO clienteDTO){
        kafkaTemplate.send("cliente_creado",clienteDTO.getEmail() ,clienteDTO);
    }

}
