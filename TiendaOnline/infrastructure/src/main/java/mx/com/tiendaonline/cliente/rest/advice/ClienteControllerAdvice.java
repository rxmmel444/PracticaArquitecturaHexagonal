package mx.com.tiendaonline.cliente.rest.advice;

import mx.com.tiendaonline.cliente.model.exception.ClienteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClienteControllerAdvice {
@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleValidation(IllegalArgumentException ex){
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
}

}
