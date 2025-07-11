package mx.com.tiendaonline.producto.adapter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.tiendaonline.compraproducto.adapter.entity.CompraEntity;
import mx.com.tiendaonline.compraproducto.adapter.entity.CompraProductoEntity;
import mx.com.tiendaonline.producto.model.entity.Producto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
@NoArgsConstructor
@Data
public class ProductoEntity extends Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private BigDecimal precio;
    private Integer stock;


    public ProductoEntity(Long id, String nombre, BigDecimal precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }



}
