package mx.com.tiendaonline.compraproducto.model.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
@NoArgsConstructor
@Getter

public class CompraProductos {
    private List<CompraProducto> productos;


    public CompraProductos(List<CompraProducto> productos) {
        this.productos = productos;
    }

    public List<CompraProducto> getProductos() {
        return productos;
    }

}
