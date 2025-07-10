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

    public ClienteException(Throwable cause, String errorMessage) {
        super(cause);
        this.errorMessage = errorMessage;
    }

    public ClienteException(String message, Throwable cause, String errorMessage) {
        super(message, cause);
        this.errorMessage = errorMessage;
    }

    public ClienteException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public ClienteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorMessage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorMessage = errorMessage;
    }
}
