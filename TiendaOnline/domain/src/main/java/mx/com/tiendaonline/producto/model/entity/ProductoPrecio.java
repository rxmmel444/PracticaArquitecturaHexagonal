package mx.com.tiendaonline.producto.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
public class ProductoPrecio {
    private BigDecimal precio;

    public ProductoPrecio(BigDecimal precio) {
        if (precio.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("EL NOMBRE ES OBLIGATORIO");

        }
        this.precio = precio;
    }
}