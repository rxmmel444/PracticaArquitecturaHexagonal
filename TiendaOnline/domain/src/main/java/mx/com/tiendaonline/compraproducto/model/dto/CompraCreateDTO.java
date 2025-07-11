package mx.com.tiendaonline.compraproducto.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraCreateCommand;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraProductoCommand;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CompraCreateDTO {
    private Long clienteId;
    private List<CompraProductoCommand> productos;
}
