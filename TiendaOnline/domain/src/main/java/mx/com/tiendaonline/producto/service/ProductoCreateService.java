package mx.com.tiendaonline.producto.service;
import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.producto.model.dto.command.ProductoCreateCommand;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.repository.ProductoRepository;


@RequiredArgsConstructor
public class ProductoCreateService {

    private final ProductoRepository crepository;



    public Producto crear(ProductoCreateCommand createCommand) {
       var producto = new Producto(
               createCommand.getId(),
               createCommand.getNombre(),
               createCommand.getPrecio(),
               createCommand.getStock()

              );
       return crepository.create(producto);
    }
}


