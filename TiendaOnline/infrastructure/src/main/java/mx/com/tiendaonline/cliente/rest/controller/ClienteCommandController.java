package mx.com.tiendaonline.cliente.rest.controller;


import mx.com.tiendaonline.cliente.adapter.kafka.ClienteEventeCreateImpl;
import mx.com.tiendaonline.cliente.command.*;

import mx.com.tiendaonline.cliente.model.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.tiendaonline.cliente.model.dto.command.ClienteUpdateCommand;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteCommandController {

    private final ClienteEventeCreateImpl producerAdapter;
    private final ClienteCreateHandler createHandler;
private final ClienteUpdateHandler updateHandler;
private final ClienteDeleteHandler deleteHandler;

    public ClienteCommandController(ClienteEventeCreateImpl producerAdapter, ClienteCreateHandler createHandler, ClienteUpdateHandler updateHandler, ClienteDeleteHandler deleteHandler) {
        this.producerAdapter = producerAdapter;
        this.createHandler = createHandler;
        this.updateHandler = updateHandler;
        this.deleteHandler = deleteHandler;
    }
    @PostMapping
    public ClienteDTO crear(@RequestBody ClienteCreateCommand command) {

            return createHandler.crear(command);
    }

    @PutMapping("/{id}")
    public ClienteDTO clientedUpdate(@RequestBody ClienteUpdateCommand cliente,
                                     @PathVariable ("id") Long id){
        return updateHandler.ejecutar(cliente, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable ("id")Long id){

        deleteHandler.ejecutar(id);
    }
}
