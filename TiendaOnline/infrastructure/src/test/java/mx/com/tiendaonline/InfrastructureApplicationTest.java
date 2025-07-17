package mx.com.tiendaonline;
import mx.com.tiendaonline.cliente.adapter.jpa.dao.ClienteDAOImpl;
import mx.com.tiendaonline.cliente.adapter.jpa.repository.ClienteRespositoryImpl;
import mx.com.tiendaonline.cliente.command.ClienteCreateHandler;
import mx.com.tiendaonline.cliente.command.ClienteDeleteHandler;
import mx.com.tiendaonline.cliente.command.ClienteUpdateHandler;
import mx.com.tiendaonline.cliente.model.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.rest.controller.ClienteCommandController;
import mx.com.tiendaonline.producto.command.ProductoCreateHandler;
import mx.com.tiendaonline.producto.command.ProductoDeleteHandler;
import mx.com.tiendaonline.producto.command.ProductoUpdateHandler;
import mx.com.tiendaonline.producto.model.dto.ProductoDTO;
import mx.com.tiendaonline.producto.model.dto.command.ProductoCreateCommand;
import mx.com.tiendaonline.producto.rest.controller.ProductoCommandController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class InfrastructureApplicationTest {

    @Mock
    private ClienteDAOImpl clienteDAO;
    @Mock
    private ClienteRespositoryImpl clienteRespository;
    @Mock
    private ClienteCreateHandler clienteHandler;
    private ClienteUpdateHandler updateHandler;
    private ClienteDeleteHandler deleteHandler;
    @Mock
    private ProductoCreateHandler productoCreateHandler;
    private ProductoUpdateHandler productoUpdateHandler;
    private ProductoDeleteHandler productoDeleteHandler;
    @InjectMocks
    private ClienteCommandController controller;
    @InjectMocks
    private ProductoCommandController productoController;

    @Test
    void crearClienteDTO(){
    ClienteCreateCommand command = new ClienteCreateCommand();
    ClienteDTO dto = new ClienteDTO();

    when(clienteHandler.crear(command)).thenReturn(dto);

    ClienteDTO resultado = controller.crear(command);
    Assertions.assertEquals(dto, resultado);
    verify(clienteHandler).crear(command);
}

    @Test
    void eliminarCliente (){

    Long id = 1L;
    Cliente cliente = new Cliente(id,"Rommel","Valdiviezo","rommelkf@gmail.com","551029384","calle mara");

    when(clienteDAO.getById(id)).thenReturn(cliente);
    doNothing().when(clienteRespository).delete(id);

    Cliente clienteEncontrado = clienteDAO.getById(id);
    clienteRespository.delete(clienteEncontrado.getId());

    verify(clienteDAO).getById(id);
    verify(clienteRespository).delete(id);
        }
    @Test
    void crearProductoDTO(){
        ProductoCreateCommand command = new ProductoCreateCommand();
        ProductoDTO dto = new ProductoDTO();

        when(productoCreateHandler.crear(command)).thenReturn(dto);
        ProductoDTO  resultado = productoController.crear(command);
        Assertions.assertEquals(dto,resultado);
        verify(productoCreateHandler).crear(command);

     }

}
