package mx.com.tiendaonline.message.adapter.kafka.rest.controller;


import lombok.extern.slf4j.Slf4j;
import mx.com.tiendaonline.cliente.dto.ClienteDTO;
import mx.com.tiendaonline.message.adapter.kafka.repository.KafkaProducerAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Component
@RestController
@RequestMapping("/kafka")
public class MessageCommandController {

    private final KafkaProducerAdapter producerAdapter;


    public MessageCommandController(KafkaProducerAdapter producerAdapter) {
        this.producerAdapter = producerAdapter;
    }


}
