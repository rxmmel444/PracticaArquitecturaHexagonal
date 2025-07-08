package mx.com.tiendaonline.producto.rest.controller;


import mx.com.tiendaonline.cliente.adapter.kafka.KafkaProducerAdapter;
import mx.com.tiendaonline.producto.command.ProductoCreateHandler;
import mx.com.tiendaonline.producto.mapper.ProductoDtoMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoCommandController {

    private final KafkaProducerAdapter producerAdapter;
    private final ProductoCreateHandler createHandler;
    private final ProductoDtoMapper dtoMapper;

    public ProductoCommandController(KafkaProducerAdapter producerAdapter, ProductoCreateHandler createHandler, ProductoDtoMapper dtoMapper) {
        this.producerAdapter = producerAdapter;
        this.createHandler = createHandler;
        this.dtoMapper = dtoMapper;
    }
}