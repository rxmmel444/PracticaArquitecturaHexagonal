package mx.com.tiendaonline.cliente.port.event;

import mx.com.tiendaonline.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.tiendaonline.cliente.model.entity.Cliente;

public interface ClienteCorreoBienvenida {

void enviarCorrreoBienvenida(ClienteCreateCommand cliente);
}
