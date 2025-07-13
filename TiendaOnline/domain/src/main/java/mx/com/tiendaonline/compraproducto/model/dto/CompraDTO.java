package mx.com.tiendaonline.compraproducto.model.dto;
import lombok.*;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProducto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompraDTO {

    private Long id;
    private Long clienteId;
    private List<CompraProducto> productos;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;
}