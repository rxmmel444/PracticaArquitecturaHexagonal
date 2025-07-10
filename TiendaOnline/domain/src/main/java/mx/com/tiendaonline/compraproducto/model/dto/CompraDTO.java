package mx.com.tiendaonline.compraproducto.model.dto;

import mx.com.tiendaonline.producto.model.dto.ProductoDTO;

import java.time.LocalDateTime;
import java.util.List;

public class CompraDTO {
    private Long id;
    private Long clienteId;
    private List<ProductoDTO> productos;
    private Double precioTotal;
    private LocalDateTime fechaCompra;
}
