package mx.com.tiendaonline.compraproducto.model.dto;
import lombok.*;
import mx.com.tiendaonline.compraproducto.model.entity.CompraFechaCompra;
import mx.com.tiendaonline.compraproducto.model.entity.CompraId;
import mx.com.tiendaonline.compraproducto.model.entity.CompraPrecioTotal;
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
    private List<CompraProductoDTO> productos;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;

    public CompraDTO(Long id, LocalDateTime fechaCompra, BigDecimal precioTotal, List<CompraProductoDTO> productos, Long clienteId) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.precioTotal = precioTotal;
        this.productos = productos;
        this.clienteId = clienteId;
    }


}