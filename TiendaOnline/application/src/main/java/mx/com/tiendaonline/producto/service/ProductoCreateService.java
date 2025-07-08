package mx.com.tiendaonline.producto.service;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.repository.ClienteRepository;
import mx.com.tiendaonline.producto.command.ProductoCreateCommand;
import mx.com.tiendaonline.producto.mapper.ProductoDtoMapper;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.repository.ProductoRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductoCreateService {

    private final ProductoRepository crepository;
    private final ProductoDtoMapper clienteDtoMapper;



    public Producto crear(ProductoCreateCommand createCommand) {
       var producto = new Producto(
               createCommand.getId(),
               createCommand.getPrecio(),
               createCommand.getNombre(),
               createCommand.getStock()

              );
       return crepository.create(producto);
    }
}


