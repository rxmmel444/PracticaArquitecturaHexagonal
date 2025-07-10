package mx.com.tiendaonline.compraproducto.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraCreateCommand {
    private Long clienteId;
    private List<CompraProductoCommand> producto;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class CompraProductoCommand {
        private Long productoId;
        private Integer cantidad;
    }
}
