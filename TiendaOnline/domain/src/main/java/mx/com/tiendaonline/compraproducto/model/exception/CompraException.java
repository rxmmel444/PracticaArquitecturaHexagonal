package mx.com.tiendaonline.compraproducto.model.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CompraException extends RuntimeException {

    public String errorMessage;
    public CompraException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
