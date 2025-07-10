package mx.com.tiendaonline.beanconfiguration;

import mx.com.tiendaonline.producto.port.dao.ProductoDAO;
import mx.com.tiendaonline.producto.port.repository.ProductoRepository;
import mx.com.tiendaonline.producto.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductoBean {
    @Bean
    public ProductoAllService allProductosService(ProductoDAO dao){
        return new ProductoAllService(dao);
    }
    @Bean
    public ProductoCreateService createService(ProductoDAO dao,ProductoRepository repository){
        return new ProductoCreateService(repository);
    }

    @Bean
    public ProductoByIdService productoByIdService(ProductoDAO dao){
        return new ProductoByIdService(dao);
    }

    @Bean
    public ProductoUpdateService updateProductoService(ProductoDAO dao, ProductoRepository productoRepository){
        return new ProductoUpdateService(dao,productoRepository);
    }

    @Bean
    public ProductoDeleteService deleteProductoService  (ProductoDAO dao, ProductoRepository productoRepository){
        return new ProductoDeleteService(productoRepository,dao);
    }
}
