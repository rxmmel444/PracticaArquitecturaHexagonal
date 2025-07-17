package mx.com.tiendaonline.compraproducto.rest.advice;

import mx.com.tiendaonline.compraproducto.model.exception.CompraException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CompraControllerAdvice {


    @ExceptionHandler(CompraException.class)
    public ResponseEntity<String> handleValidation(CompraException cex){
        return new ResponseEntity<>(cex.getErrorMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> errorServicio(Exception ex) {
        String mensajeError = "⚠️ Error interno del servidor\n" +
                "🧩 Tipo de excepción: " + ex.getClass().getSimpleName() + "\n" +
                "📄 Mensaje: " + ex.getMessage() + "\n" +
                "💡 Recomendación: Revisa los logs del backend para más detalles.";

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(mensajeError);
    }
}
