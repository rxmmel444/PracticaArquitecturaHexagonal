package mx.com.tiendaonline.cliente.rest.controller;

import mx.com.tiendaonline.cliente.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.query.ClienteAllHandler;
import mx.com.tiendaonline.cliente.query.ClienteByIdHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteQueryController {

    private final ClienteByIdHandler byId;
    private final ClienteAllHandler getAll;

    public ClienteQueryController(ClienteByIdHandler byId, ClienteAllHandler getAll) {
        this.byId = byId;
        this.getAll = getAll;
    }


    @GetMapping("/{id}")
    public ClienteDTO getById(@PathVariable("id") long id){
        return byId.ejecutar(id);
    }

    @GetMapping
    public List<ClienteDTO> getAll() {
        return getAll.ejecutar();
    }


}
