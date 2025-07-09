package mx.com.tiendaonline.cliente.adapter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.tiendaonline.compraproducto.adapter.entity.CompraEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank(message = "el nombre es obligatorio")
    private String nombre;
    private String apellido;
    @Column(unique = true)
    @Email(message = "el formato es incorrecto")
    private String email;
    private String telefono;
    @Column(unique = true)
    private String direccion;

    @OneToMany(mappedBy = "cliente" ,cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CompraEntity> compras = new ArrayList<>();

    public ClienteEntity(Long id,String nombre, String apellido, String email, String telefono, String direccion) {
       this.id= id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }
}
