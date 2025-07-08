package mx.com.tiendaonline.producto.model.entity;

import lombok.NoArgsConstructor;
import mx.com.tiendaonline.cliente.model.entity.*;

import java.math.BigDecimal;

@NoArgsConstructor
public class Producto {
    private ProductoId id;
    private ProductoNombre nombre;
    private ProductoPrecio precio;
    private ProductoStock productoStock;

    public Producto(Long id, BigDecimal precio, String nombre, Integer productoStock) {
        this.id = new ProductoId(id);
        this.precio = new ProductoPrecio(precio);
        this.nombre = new ProductoNombre(nombre);
        this.productoStock = new ProductoStock(productoStock);

    }

/*
    public Cliente(Long id, String nombre, String apellido, String email, String telefono, String direccion) {
        this.id = new ClienteId(id);
        this.nombre = new ClienteNombre(nombre);
        this.apellido = new ClienteApellido(apellido);
        this.email = new ClienteEmail(email);
        this.telefono = new ClienteTelefono(telefono);
        this.direccion = new ClienteDireccion(direccion);
    }
*/
// para crear el usuario con USERCREATECOMMAND
/*
    public Cliente requestToCreate (ClienteCreateCommand createCommand) {
        this.nombre = new ClienteNombre(createCommand.getNombre());
        this.apellido = new ClienteApellido(createCommand.getApellido());
        this.email = new ClienteEmail(createCommand.getEmail());
        this.telefono = new ClienteTelefono(createCommand.getTelefono());
        this.direccion = new ClienteDireccion(createCommand.getDireccion());
        return this;
    }
*/

    public ProductoId getId() {
        return id;
    }

    public ProductoNombre getNombre() {
        return nombre;
    }

    public ProductoStock getProductoStock() {
        return productoStock;
    }

    public ProductoPrecio getPrecio() {
        return precio;
    }
/*
    public List<ComprasProducto> getClienteCompra() {
        return this.clienteCompra.getProductos();
    }*/
}
