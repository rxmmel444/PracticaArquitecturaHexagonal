package mx.com.tiendaonline.cliente.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
public class Cliente {
    private  ClienteId id;
    private ClienteNombre nombre;
    private ClienteApellido apellido;
    private ClienteEmail email;
    private ClienteTelefono telefono;
    private ClienteDireccion direccion;


    public Cliente(Long id, String nombre, String apellido, String email, String telefono, String direccion,List<CompraProducto> compraProducto) {
        this.id = new ClienteId(id);
        this.nombre = new ClienteNombre(nombre);
        this.apellido = new ClienteApellido(apellido);
        this.email = new ClienteEmail(email);
        this.telefono = new ClienteTelefono(telefono);
        this.direccion = new ClienteDireccion(direccion);

    }

    public Cliente(Long id, String nombre, String apellido, String email, String telefono, String direccion) {
        this.id = new ClienteId(id);
        this.nombre = new ClienteNombre(nombre);
        this.apellido = new ClienteApellido(apellido);
        this.email = new ClienteEmail(email);
        this.telefono = new ClienteTelefono(telefono);
        this.direccion = new ClienteDireccion(direccion);
    }

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

