package mx.com.tiendaonline.cliente.adapter.kafka;

import mx.com.tiendaonline.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.tiendaonline.cliente.port.event.ClienteCorreoBienvenida;
import org.springframework.stereotype.Component;

@Component
public class ClienteCorreoBienvenidaImpl  implements ClienteCorreoBienvenida {
    @Override
    public void enviarCorrreoBienvenida(ClienteCreateCommand cliente) {
        System.out.println("Bienvenido estimado Cliente" +cliente.getNombre());
    }
}
