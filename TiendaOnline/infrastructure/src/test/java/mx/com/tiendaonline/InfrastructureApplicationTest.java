package mx.com.tiendaonline;


import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.model.entity.ClienteId;
import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;
import mx.com.tiendaonline.compraproducto.port.repository.CompraRespository;
import mx.com.tiendaonline.compraproducto.service.CompraCreateService;
import mx.com.tiendaonline.compraproducto.service.StockService;
import mx.com.tiendaonline.producto.model.entity.Producto;
import mx.com.tiendaonline.producto.model.entity.ProductoId;
import mx.com.tiendaonline.producto.port.dao.ProductoDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class InfrastructureApplicationTest {


}
