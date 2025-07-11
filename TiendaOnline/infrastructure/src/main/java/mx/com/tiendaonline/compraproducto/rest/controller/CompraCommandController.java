package mx.com.tiendaonline.compraproducto.rest.controller;

import mx.com.tiendaonline.compraproducto.commnad.CompraCrateHandler;
import mx.com.tiendaonline.compraproducto.model.dto.CompraDTO;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraCreateCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class CompraCommandController {
    private final CompraCrateHandler compraCrateHandler;

    public CompraCommandController(CompraCrateHandler compraCrateHandler) {
        this.compraCrateHandler = compraCrateHandler;
    }

    @PostMapping()
    public CompraDTO create(@RequestBody CompraCreateCommand command){
        return compraCrateHandler.ejecutar(command);
    }
}
