package mx.com.tiendaonline.compraproducto.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProducto;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraDTO {

    private Long id;
    private Long clienteId;
    private List<CompraProducto> productos;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;
}