package mx.com.tiendaonline;

import mx.com.tiendaonline.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.model.entity.ClienteEmail;
import mx.com.tiendaonline.cliente.model.exception.ClienteException;
import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;
import mx.com.tiendaonline.cliente.port.event.ClienteEventCreate;
import mx.com.tiendaonline.cliente.port.repository.ClienteRepository;
import mx.com.tiendaonline.cliente.service.ClienteCreateService;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class DomainApplicationTest {

    @InjectMocks
    private CompraCreateService compraCreateService;
    @Mock
    private ClienteDAO clienteDAO;

    private ClienteRepository clienteRepository;
    @Mock
    private ClienteEventCreate clienteEventCreate;
    @InjectMocks
    private ClienteCreateService clienteCreateService;

    @Test
    void crearCliente() {
        ClienteCreateCommand cliente = new ClienteCreateCommand(null, "Rommel", "Valdiviezo", "rommelkd34@gmail.com", "5590390098", "milan");
        Cliente clienteCreado = new Cliente(1L, "Rommel", "Valdiviezo", "rommelkd34@gmail.com", "5590390098", "milan");

        when(clienteDAO.existByEmail(anyString())).thenReturn(false);
        when(clienteRepository.create(any(Cliente.class))).thenReturn(clienteCreado);


        Cliente resultado = clienteCreateService.crear(cliente);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Rommel", resultado.getNombre());
        assertEquals("Valdiviezo", resultado.getApellido());
        assertEquals("rommelkd34@gmail.com", resultado.getEmail());
        assertEquals("5590390098", resultado.getTelefono());
        assertEquals("milan", resultado.getDireccion());

        verify(clienteEventCreate).clienteCreadoEvent(any(Cliente.class));
    }

    @Test
    void crearClienteCorrectamente() {

        Cliente cliente = new Cliente(1L, "Rommel", "valdiviezo", "rommelkd@gmail.com", "5510595546", "viento");
        assertEquals("Rommel", cliente.getNombre());
        assertEquals("valdiviezo", cliente.getApellido());

    }

    @Test
    void pruebaNombeClienteNull() {
        assertThrows(ClienteException.class, () ->
                new Cliente(1L, null, "valdiviezo", "rommel98@gmail.com", "5510595546", "viento"));
    }


    @Test
    void crearEmailValido() {
        ClienteEmail email = new ClienteEmail("rommel@example.com");
        assertEquals("rommel@example.com", email.getEmail());
    }

    @Test
    void exceptionEmailNull() {
        assertThrows(ClienteException.class, () ->
                new ClienteEmail(null));
    }

    @Test
    void exceptionEmailIsBlank() {
        assertThrows(ClienteException.class, () -> new ClienteEmail(""));
    }
}

