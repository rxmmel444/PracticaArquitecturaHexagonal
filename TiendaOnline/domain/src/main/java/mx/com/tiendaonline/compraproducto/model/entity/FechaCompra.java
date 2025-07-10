package mx.com.tiendaonline.compraproducto.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class FechaCompra {
    private LocalDateTime fechaCompra;
}
