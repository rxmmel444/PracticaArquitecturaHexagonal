package mx.com.tiendaonline.cliente.model.entity;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class Cliente {
    private  ClienteId id;
    private ClienteNombre nombre;
    private ClienteApellido apellido;
    private ClienteEmail email;
    private ClienteTelefono telefono;
    private ClienteDireccion direccion;
 //   private ClienteCompra clienteCompra;

    public Cliente(Long id, String nombre, String apellido, String email, String telefono, String direccion) {
        this.id = new ClienteId(id);
        this.nombre = new ClienteNombre(nombre);
        this.apellido = new ClienteApellido(apellido);
        this.email = new ClienteEmail(email);
        this.telefono = new ClienteTelefono(telefono);
        this.direccion = new ClienteDireccion(direccion);
   //     this.clienteCompra = new ClienteCompra(productos);
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

    public Long getId() {
        return this.id.getId();
    }

    public String getNombre() {
        return this.nombre.getNombre();
    }

    public String getApellido() {
        return this.apellido.getApellido();
    }

    public String getEmail() {
        return this.email.getEmail();
    }

    public String getTelefono() {
        return this.telefono.getTelofono();
    }

    public String getDireccion() {
        return this.direccion.getDireccion();
    }
/*
    public List<ComprasProducto> getClienteCompra() {
        return this.clienteCompra.getProductos();
    }*/
}
