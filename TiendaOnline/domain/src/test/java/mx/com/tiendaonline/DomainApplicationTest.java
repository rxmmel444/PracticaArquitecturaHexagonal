package mx.com.tiendaonline;

import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.model.entity.ClienteEmail;
import mx.com.tiendaonline.cliente.model.exception.ClienteException;
import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;
import mx.com.tiendaonline.compraproducto.port.repository.CompraRespository;
import mx.com.tiendaonline.compraproducto.service.CompraCreateService;
import mx.com.tiendaonline.compraproducto.service.StockService;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;


public class DomainApplicationTest {

    @InjectMocks
    private CompraCreateService compraCreateService;
    @Mock
    private ClienteDAO clienteDAO;
    @Mock
    private ProductoDAO productoDAO;
    @Mock
    private CompraRespository compraRespository;

    @Mock
    private StockService stockService;

@Test
void pruebaNombeClienteNull(){
    assertThrows(ClienteException.class, ()->
            new Cliente(1L,null,"valdiviezo","rommel98@gmail.com","5510595546","viento"));
}

@Test
    void crearClienteCorrectamente(){

    Cliente cliente = new Cliente(1L,"Rommel","valdiviezo","rommelkd@gmail.com","5510595546","viento");
    assertEquals("Rommel",cliente.getNombre());
    assertEquals("valdiviezo",cliente.getApellido());

}
@Test
    void crearEmailValido(){
    ClienteEmail email = new ClienteEmail("rommel@example.com");
    assertEquals("rommel@example.com", email.getEmail());
}
@Test
    void exceptionEmailNull(){
    assertThrows(ClienteException.class,()->
            new ClienteEmail(null));
}
    @Test
    void exceptionEmailIsBlank() {
        assertThrows(ClienteException.class, () -> new ClienteEmail(""));
    }


    @Test
    void crearCompraCorrectamente(){


        Long id = 1L;
        String nombre ="Laptop";
        BigDecimal precio = new BigDecimal("20000");
        Integer stock = 10;

        Producto producto =  new Producto(id,nombre,precio,stock);

        assertNotNull(producto.getId());
        assertEquals(id,
                producto.getId());
        assertEquals(nombre,producto.getNombre());
        assertEquals(precio,producto.getPrecio());
        assertEquals(stock,producto.getStock());
    }
}
