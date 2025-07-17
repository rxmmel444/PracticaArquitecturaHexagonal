package mx.com.tiendaonline.compraproducto.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraCreateCommand;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraProductosCommand;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProducto;
import mx.com.tiendaonline.compraproducto.port.repository.CompraRespository;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor

public class CompraCreateService {

    private final CompraRespository compraRespository;
    private final ValidarCompraService validarCompra;
    private final CompraProductoService compraProductoService;
    private final StockService stockService;

    @Transactional
    public Compra crearCompra(CompraCreateCommand command) {
      Cliente cliente = validarCompra.validarCliente(command.getClienteId());

      List<CompraProducto> detalleCompra= new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO; //declaramos variabale decimal

      for(CompraProductosCommand cpcommand : command.getProductos()){
      Producto producto = validarCompra.validarProductoStock(cpcommand.getProductoId(), cpcommand.getCantidad());

      stockService.descontarStock(producto.getId(), cpcommand.getCantidad());

      CompraProducto productoDetalle = compraProductoService.crearDetalleCompra(producto,cpcommand.getCantidad());
      detalleCompra.add(productoDetalle);
      total = total.add(producto.getPrecio().multiply(BigDecimal.valueOf(cpcommand.getCantidad())));

      }

      Compra compra = compraProductoService.crearCompra(cliente,detalleCompra,total);
      return compraRespository.create(compra);
    }
}


