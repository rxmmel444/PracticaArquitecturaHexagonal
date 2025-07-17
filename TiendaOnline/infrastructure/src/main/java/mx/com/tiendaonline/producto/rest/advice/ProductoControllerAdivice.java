package mx.com.tiendaonline.producto.rest.advice;
import mx.com.tiendaonline.producto.model.exception.ProductoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductoControllerAdivice {

    @ExceptionHandler(ProductoException.class)
    public ResponseEntity<String> ProductoNoEncontrado(ProductoException pex){
        return new ResponseEntity<>(pex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
