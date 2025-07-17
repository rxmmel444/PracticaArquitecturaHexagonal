package mx.com.tiendaonline.cliente.model.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class ClienteException extends RuntimeException {

    public String errorMessage;


    public ClienteException(String errorMessage) {
        this.errorMessage = errorMessage;
    }


}
