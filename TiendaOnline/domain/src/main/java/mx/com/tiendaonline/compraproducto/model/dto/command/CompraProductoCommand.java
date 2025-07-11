package mx.com.tiendaonline.compraproducto.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public class CompraProductoCommand {

    private Long id;
    private Long clienteId;
    private List<CompraCreateCommand> productos;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;
}
