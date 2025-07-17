package mx.com.tiendaonline.beanconfiguration;

import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;
import mx.com.tiendaonline.cliente.port.repository.ClienteRepository;
import mx.com.tiendaonline.compraproducto.mapper.CompraMapper;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProducto;
import mx.com.tiendaonline.compraproducto.port.dao.CompraDAO;
import mx.com.tiendaonline.compraproducto.port.repository.CompraRespository;
import mx.com.tiendaonline.compraproducto.query.CompraAllHandler;
import mx.com.tiendaonline.compraproducto.service.*;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;
import mx.com.tiendaonline.producto.port.repository.ProductoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompraBean {

@Bean
    public CompraAllService compraAllService(CompraDAO compraDAO){
    return new CompraAllService(compraDAO);
}

@Bean
    CompraCreateService createServiceCompra(CompraRespository respository, ClienteDAO dao, ProductoDAO productoDAO, StockService stockService, ValidarCompraService compraService, CompraProductoService compraProductoService){
    return new CompraCreateService(respository,compraService,compraProductoService,stockService);
}
@Bean
    StockService stockService(ProductoDAO productoDAO, ProductoRepository repository){
    return new StockService(productoDAO,repository);
}

@Bean
    ValidarCompraService validarCompraService(ClienteDAO clienteDAO, ProductoDAO productoDAO){
    return new ValidarCompraService(clienteDAO,productoDAO);
}

@Bean
    CompraProductoService compraProductoService (){
    return new CompraProductoService();
}
@Bean
    CompraMapper compraMapper(){
    return new CompraMapper();
}
}

