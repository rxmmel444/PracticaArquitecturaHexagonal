package mx.com.tiendaonline.producto.model.entity;

import lombok.*;
import mx.com.tiendaonline.cliente.model.entity.*;

import java.math.BigDecimal;


@NoArgsConstructor

@Setter
@Getter
public class Producto {
    private ProductoId id;
    private ProductoNombre nombre;
    private ProductoPrecio precio;
    private ProductoStock stock;


    public Producto(Long id, String nombre, BigDecimal precio, Integer stock) {
        this.id = new ProductoId(id);
        this.nombre = new ProductoNombre(nombre);
        this.precio = new ProductoPrecio(precio);
        this.stock = new ProductoStock(stock);

    }

    public Long getId() {
        return this.id.getId();
    }

    public Integer getStock() {
        return this.stock.getStock();
    }

    public BigDecimal getPrecio() {
        return this.precio.getPrecio();
    }

    public String getNombre() {
        return this.nombre.getNombre();
    }


}
