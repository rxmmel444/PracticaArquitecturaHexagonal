package mx.com.tiendaonline.cliente.service;

import lombok.extern.slf4j.Slf4j;
import mx.com.tiendaonline.cliente.model.dto.command.ClienteCreateCommand;



public class ClienteCorreoBienvenida implements mx.com.tiendaonline.cliente.port.event.ClienteCorreoBienvenida {
    @Override
    public void enviarCorrreoBienvenida(ClienteCreateCommand cliente) {

        System.out.println("Correo enviado a " + cliente.getEmail());
        System.out.println("Bienvenido Estimado " + cliente.getNombre());
     //   log.info("correo de bienvenida enviado {} ", cliente.getEmail());
    }
}
