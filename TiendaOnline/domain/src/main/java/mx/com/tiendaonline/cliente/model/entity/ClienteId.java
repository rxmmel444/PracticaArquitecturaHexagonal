package mx.com.tiendaonline.cliente.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

@NoArgsConstructor

public class ClienteId {

     Long clienteId;

    public ClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
