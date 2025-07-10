package mx.com.tiendaonline;

import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.model.entity.ClienteEmail;
import mx.com.tiendaonline.cliente.model.exception.ClienteException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class DomainApplicationTest {


@Test
void pruebaNombeClienteNull(){
    assertThrows(ClienteException.class, ()->
            new Cliente(1L,null,"valdivieszo","rommel98@gmail.com","5510595546","viento"));
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

}
