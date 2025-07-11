

package mx.com.tiendaonline.compraproducto.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.model.entity.ClienteId;
import mx.com.tiendaonline.compraproducto.model.dto.CompraProductoDTO;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Compra {

    private Long id;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;
    private Long clienteId;
    private List<CompraProducto> productos;

}
