

package mx.com.tiendaonline.compraproducto.commnad;


import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.compraproducto.mapper.CompraMapper;
import mx.com.tiendaonline.compraproducto.model.dto.CompraDTO;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraCreateCommand;
import mx.com.tiendaonline.compraproducto.service.CompraCreateService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompraCrateHandler {

    private final CompraCreateService createService;
    private final CompraMapper dtoMapper;

    public CompraDTO ejecutar(CompraCreateCommand command){
        var compra = createService.crearCompra(command);
        return dtoMapper.toDTO(compra);
    }
}


