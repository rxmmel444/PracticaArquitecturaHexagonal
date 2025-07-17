package mx.com.tiendaonline.cliente.rest.advice;

import mx.com.tiendaonline.cliente.model.exception.ClienteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClienteControllerAdvice {
@ExceptionHandler(ClienteException.class)
    public ResponseEntity<String> handleValidation(ClienteException ex){
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
}

}
