package mx.com.tiendaonline.compraproducto.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.tiendaonline.producto.adapter.entity.ProductoEntity;

@Entity
@Table(name = "compra_productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraProductoEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "compra_id")
private CompraEntity compra;


@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "producto_id")
private ProductoEntity producto;

private Integer cantidad;

private Double precioUnitario;
}
