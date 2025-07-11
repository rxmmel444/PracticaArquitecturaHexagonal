package mx.com.tiendaonline.producto.rest.controller;


import mx.com.tiendaonline.producto.command.ProductoCreateHandler;
import mx.com.tiendaonline.producto.command.ProductoDeleteHandler;
import mx.com.tiendaonline.producto.command.ProductoUpdateHandler;
import mx.com.tiendaonline.producto.model.dto.ProductoDTO;
import mx.com.tiendaonline.producto.model.dto.command.ProductoCreateCommand;
import mx.com.tiendaonline.producto.model.dto.command.ProductoUpdateCommand;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoCommandController {

    private final ProductoCreateHandler createHandler;
    private final ProductoDeleteHandler deleteHandler;
    private final ProductoUpdateHandler updateHandler;

    public ProductoCommandController( ProductoCreateHandler createHandler, ProductoDeleteHandler deleteHandler, ProductoUpdateHandler updateHandler) {
        this.createHandler = createHandler;
        this.deleteHandler = deleteHandler;
        this.updateHandler = updateHandler;

    }

    @PutMapping("{id}")
    public ProductoDTO update(@PathVariable ("id") Long id, @RequestBody ProductoUpdateCommand producto){
        return updateHandler.ejecutar(producto,id);
    }

    @PostMapping()
    public ProductoDTO crear(@RequestBody ProductoCreateCommand command){
        return createHandler.crear(command);
    }

    @DeleteMapping("/{id}")
    public void  delete(@PathVariable("id") Long id) {
        deleteHandler.ejecutar(id);

    }
}