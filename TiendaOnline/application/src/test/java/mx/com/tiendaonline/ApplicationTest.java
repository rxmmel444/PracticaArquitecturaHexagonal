package mx.com.tiendaonline;

import mx.com.tiendaonline.cliente.command.ClienteCreateHandler;
import mx.com.tiendaonline.cliente.mapper.ClienteDtoMapper;
import mx.com.tiendaonline.cliente.model.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.service.ClienteCreateService;
import mx.com.tiendaonline.compraproducto.commnad.CompraCrateHandler;
import mx.com.tiendaonline.compraproducto.mapper.CompraMapper;
import mx.com.tiendaonline.compraproducto.model.dto.CompraDTO;
import mx.com.tiendaonline.compraproducto.model.dto.CompraProductoDTO;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraCreateCommand;
import mx.com.tiendaonline.compraproducto.model.dto.command.CompraProductosCommand;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProducto;
import mx.com.tiendaonline.compraproducto.model.entity.CompraProductos;
import mx.com.tiendaonline.compraproducto.service.CompraCreateService;
import mx.com.tiendaonline.producto.command.ProductoCreateHandler;
import mx.com.tiendaonline.producto.mapper.ProductoDtoMapper;
import mx.com.tiendaonline.producto.model.dto.ProductoDTO;
import mx.com.tiendaonline.producto.model.dto.command.ProductoCreateCommand;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.service.ProductoCreateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ApplicationTest {
@Mock
private CompraCreateService compraService;
@Mock
private ClienteCreateService service;
@Mock
private ProductoCreateService productoService;
@Mock
private ProductoDtoMapper productoMapper;
@Mock
private ClienteDtoMapper mapper;
@Mock
private CompraMapper compraMapper;

    @InjectMocks
    private CompraCrateHandler compraHandler;
    @InjectMocks
    private ClienteCreateHandler handler;
     @InjectMocks
     private ProductoCreateHandler productoHandler;

    @Test
    void crearCliente(){
        ClienteCreateCommand command = new ClienteCreateCommand(1L,"rommel","valdiviezo","rommel821@gmail.com","5520595546","avenida cipres");
        Cliente cliente = new Cliente(1L,"rommel","valdiviezo","rommel821@gmail.com","5520595546","avenida cipres");
        ClienteDTO dto = new ClienteDTO(1L,"rommel","valdiviezo","rommel821@gmail.com","5520595546","avenida cipres");

        when(service.crear(command)).thenReturn(cliente);
        when(mapper.domainToDto(cliente)).thenReturn(dto);

       for(int i = 0; i < 5; i++){
            handler.crear(command);
        }
        verify(service,times(5)).crear(command);
        verify(mapper, times(5)).domainToDto(cliente);
    }
@Test
    void crearProducto(){
        ProductoCreateCommand command = new ProductoCreateCommand(1L,"xbox",BigDecimal.valueOf(200000.00),3);
        Producto domain = new Producto(1L,"ps5",BigDecimal.valueOf(200000.00),5);
        ProductoDTO dto = new ProductoDTO(1L,"xbox", BigDecimal.valueOf(200000.00),3);

        when(productoService.crear(command)).thenReturn(domain);
        when(productoMapper.domainToDto(domain)).thenReturn(dto);

        ProductoDTO resultado = productoHandler.crear(command);
        assertEquals(dto,resultado);
        verify(productoService,times(1)).crear(command);
        verify(productoMapper,times(1)).domainToDto(domain);
    }


    @Test
    void crearCompra(){

        List<CompraProductosCommand> productos = List.of(
                new CompraProductosCommand(1L,2),
                new CompraProductosCommand(1L,2)
        );


        CompraCreateCommand command = new CompraCreateCommand(1L,productos);
        Compra compra = new Compra(1L,productos);


        when(compraService.crearCompra(command)).thenReturn(compra);

        CompraDTO resultado = compraHandler.ejecutar(command);
        verify(compraService,times(1)).crearCompra(command);
        verify(compraMapper,times(1)).toDTO(compra);

    }
}
