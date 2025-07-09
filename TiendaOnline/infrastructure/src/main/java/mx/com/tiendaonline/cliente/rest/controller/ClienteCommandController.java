package mx.com.tiendaonline.cliente.rest.controller;


import mx.com.tiendaonline.cliente.command.*;
import mx.com.tiendaonline.cliente.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;

import mx.com.tiendaonline.cliente.adapter.kafka.KafkaProducerAdapter;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.service.ClienteDeleteService;
import mx.com.tiendaonline.cliente.service.ClienteUpdateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteCommandController {

    private final KafkaProducerAdapter producerAdapter;
    private final ClienteCreateHandler createHandler;
private final ClienteDtoMapper dtoMapper;
private final ClienteUpdateHandler updateHandler;
private final ClienteDeleteHandler deleteHandler;

    public ClienteCommandController(KafkaProducerAdapter producerAdapter, ClienteCreateHandler createHandler, ClienteDtoMapper dtoMapper, ClienteUpdateHandler updateHandler, ClienteDeleteHandler deleteHandler) {
        this.producerAdapter = producerAdapter;
        this.createHandler = createHandler;
        this.dtoMapper = dtoMapper;
        this.updateHandler = updateHandler;
        this.deleteHandler = deleteHandler;
    }

/*
    @PostMapping
    public ResponseEntity<ClienteDTO> crear(@RequestBody ClienteDTO clienteDTO) {
        ClienteCreateCommand command = dtoMapper.toCommand(clienteDTO);
        Cliente clienteCreado = createHandler.crear(command);
        ClienteDTO respuesta = dtoMapper.domainToDto(clienteCreado);

        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }*/

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