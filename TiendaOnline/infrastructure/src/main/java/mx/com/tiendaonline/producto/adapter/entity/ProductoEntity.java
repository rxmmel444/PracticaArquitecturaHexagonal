package mx.com.tiendaonline.producto.adapter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank(message = "el nombre es obligatorio")
    private String nombre;
    private BigDecimal precio;
    @Email(message = "el formato es incorrecto")
    private Integer stock;

/*
    @OneToMany(mappedBy = "cliente" ,cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CompraEntity> compras = new ArrayList<>();
*/

}
