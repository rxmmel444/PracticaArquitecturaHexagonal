package mx.com.tiendaonline.beanconfiguration;

import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;
import mx.com.tiendaonline.compraproducto.port.dao.CompraDAO;
import mx.com.tiendaonline.compraproducto.port.repository.CompraRespository;
import mx.com.tiendaonline.compraproducto.query.CompraAllHandler;
import mx.com.tiendaonline.compraproducto.service.CompraAllService;
import mx.com.tiendaonline.compraproducto.service.CompraCreateService;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompraBean {

@Bean
    public CompraAllService compraAllService(CompraDAO compraDAO){
    return new CompraAllService(compraDAO);
}

@Bean
    CompraCreateService createServiceCompra(CompraRespository respository, ClienteDAO dao, ProductoDAO productoDAO){
    return new CompraCreateService(dao,productoDAO,respository);
}

}

