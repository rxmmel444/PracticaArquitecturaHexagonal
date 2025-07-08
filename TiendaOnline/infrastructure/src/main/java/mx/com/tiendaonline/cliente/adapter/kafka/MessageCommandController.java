package mx.com.tiendaonline.cliente.adapter.kafka;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Component
@RestController
@RequestMapping("/kafka")
public class MessageCommandController {

    private final ClienteEventeCreateImpl producerAdapter;


    public MessageCommandController(ClienteEventeCreateImpl producerAdapter) {
        this.producerAdapter = producerAdapter;
    }
}
