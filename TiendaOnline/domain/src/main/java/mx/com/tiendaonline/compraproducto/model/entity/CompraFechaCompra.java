package mx.com.tiendaonline.compraproducto.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@NoArgsConstructor
@Getter
public class CompraFechaCompra {
    private LocalDateTime fechaCompra;

    public CompraFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }
}
