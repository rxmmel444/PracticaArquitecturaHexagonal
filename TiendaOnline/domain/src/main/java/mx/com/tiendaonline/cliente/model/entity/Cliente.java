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
        return id.clienteId;
    }

    public String getNombre() {
        return nombre.getNombre();
    }

    public String getApellido() {
        return apellido.getApellido();
    }

    public String getEmail() {
        return email.getEmail();
    }

    public String getTelefono() {
        return telefono.getTelofono();
    }

    public String getDireccion() {
        return direccion.getDireccion();
    }


}

