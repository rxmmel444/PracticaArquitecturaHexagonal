package mx.com.tiendaonline.cliente.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class ClienteId {

     private Long id;

    public ClienteId(Long id) {
        this.id = id;
    }
    public  Long getClienteId(){
        return id;
    }
}
