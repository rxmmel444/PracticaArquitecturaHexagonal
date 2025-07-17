package mx.com.tiendaonline.producto.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mx.com.tiendaonline.cliente.model.exception.ClienteException;


@NoArgsConstructor

public class ProductoNombre {
private String nombre;
    public ProductoNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new RuntimeException("El nombre del Producto es obligatorio");
        this.nombre =nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
