package mx.com.tiendaonline.cliente.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mx.com.tiendaonline.cliente.model.exception.ClienteException;

@Getter

@NoArgsConstructor
public class ClienteNombre {
    private String nombre;

    public ClienteNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new ClienteException("EL NOMBRE ES OBLIGATORIO");
        this.nombre =nombre;
    }


}
