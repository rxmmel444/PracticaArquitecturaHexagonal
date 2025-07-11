

package mx.com.tiendaonline.compraproducto.model.entity;

import lombok.*;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.model.entity.ClienteId;
import mx.com.tiendaonline.compraproducto.model.dto.CompraProductoDTO;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Compra {

    private Long id;
    private Cliente cliente;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;
    private List<CompraProducto> productos;

    public Compra(Long id, BigDecimal precioTotal, LocalDateTime fechaCompra, Cliente cliente, List<CompraProducto> productos) {
        this.id = id;
        this.precioTotal = precioTotal;
        this.fechaCompra = fechaCompra;
        this.cliente = cliente;
        this.productos = productos;
    }

}
