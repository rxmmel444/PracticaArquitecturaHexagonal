package mx.com.tiendaonline.compraproducto.model.dto.command;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompraCreateCommand {
    private Long clienteId;
    private List<CompraProductosCommand> productos;


}
