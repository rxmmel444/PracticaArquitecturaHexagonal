package mx.com.tiendaonline.producto.rest.controller;

import mx.com.tiendaonline.cliente.model.dto.ClienteDTO;
import mx.com.tiendaonline.producto.model.dto.ProductoDTO;
import mx.com.tiendaonline.producto.query.ProductoAllHandler;
import mx.com.tiendaonline.producto.query.ProductoByIdHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoQueryController {

    private final ProductoByIdHandler byIdHandler;
    private final ProductoAllHandler allHandler;

    public ProductoQueryController(ProductoByIdHandler byIdHandler, ProductoAllHandler allHandler) {
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }
    @GetMapping("/{id}")
    public ProductoDTO getById(@PathVariable("id") long id){
        return byIdHandler.ejecutar(id);
    }
    @GetMapping
    public List<ProductoDTO> getAll(){
        return allHandler.ejecutar();
    }


}
