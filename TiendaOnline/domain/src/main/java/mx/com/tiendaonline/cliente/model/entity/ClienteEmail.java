package mx.com.tiendaonline.cliente.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mx.com.tiendaonline.cliente.model.exception.ClienteException;

@Getter
@NoArgsConstructor
public class ClienteEmail
{
    private String email;

    public ClienteEmail(String emaill){

        if(emaill.isBlank() || emaill == null) {
            throw new ClienteException("EL email es obligatorio ");
        }
        this.email=emaill;
        }

}
