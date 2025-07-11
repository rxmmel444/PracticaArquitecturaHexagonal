package mx.com.tiendaonline.compraproducto.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.tiendaonline.cliente.adapter.entity.ClienteEntity;
import mx.com.tiendaonline.cliente.model.dto.ClienteDTO;
import mx.com.tiendaonline.producto.adapter.entity.ProductoEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "compras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;


    @OneToMany(mappedBy = "compra" ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompraProductoEntity> productos;

}
