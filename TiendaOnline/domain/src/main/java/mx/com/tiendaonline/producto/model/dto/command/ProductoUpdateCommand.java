package mx.com.tiendaonline.producto.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoUpdateCommand {
    private String nombre;
    private BigDecimal precio;
    private Integer stock;
}
