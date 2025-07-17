

package mx.com.tiendaonline.compraproducto.model.entity;

import lombok.*;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.model.entity.ClienteId;
import mx.com.tiendaonline.compraproducto.model.dto.CompraProductoDTO;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraCreateCommand;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraProductosCommand;


import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Compra {

    private CompraId id;
    private Cliente cliente;
    private CompraPrecioTotal precioTotal;
    private CompraFechaCompra fechaCompra;
    private CompraProductos productos;



    // Constructor VO completo
    public Compra(CompraId id, Cliente cliente, CompraPrecioTotal precioTotal,
                  CompraFechaCompra fechaCompra, List<CompraProducto> productos) {
        this.id = id;
        this.cliente = cliente;
        this.precioTotal = precioTotal;
        this.fechaCompra = fechaCompra;
        this.productos = new CompraProductos(productos);
    }




    public Compra(long l, List<CompraProductosCommand> productos) {
    }
}

