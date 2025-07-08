package mx.com.tiendaonline.cliente.rest.controller;


import mx.com.tiendaonline.cliente.command.ClienteCreateCommand;
import mx.com.tiendaonline.cliente.command.ClienteCreateHandler;
import mx.com.tiendaonline.cliente.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;

import mx.com.tiendaonline.cliente.adapter.kafka.KafkaProducerAdapter;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteCommandController {

    private final KafkaProducerAdapter producerAdapter;

    private final ClienteCreateHandler createHandler;
private final ClienteDtoMapper dtoMapper;
    public ClienteCommandController(KafkaProducerAdapter producerAdapter, ClienteCreateHandler createHandler, ClienteDtoMapper dtoMapper) {
        this.producerAdapter = producerAdapter;
        this.createHandler = createHandler;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> crear(@RequestBody ClienteDTO clienteDTO) {
        ClienteCreateCommand command = dtoMapper.toCommand(clienteDTO);
        Cliente clienteCreado = createHandler.crear(command); // ← Devuelve Cliente (entidad de dominio)
        ClienteDTO respuesta = dtoMapper.domainToDto(clienteCreado); // ← DTO limpio

        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);}
}