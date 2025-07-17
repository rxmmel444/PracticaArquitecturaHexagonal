package mx.com.tiendaonline.compraproducto.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.tiendaonline.producto.adapter.entity.ProductoEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "compra_productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraProductoEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    private Long productoId;
private String nombre;
private Integer cantidad;
private BigDecimal precioUnitario;
@ManyToOne
@JoinColumn(name = "compra_id")
private CompraEntity compra;



}
