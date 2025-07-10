package mx.com.tiendaonline.beanconfiguration;

import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;
import mx.com.tiendaonline.cliente.port.event.ClienteEventCreate;
import mx.com.tiendaonline.cliente.port.repository.ClienteRepository;
import mx.com.tiendaonline.cliente.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBean {

    @Bean
    public ClienteAllService allService (ClienteDAO clienteDAO){
        return new ClienteAllService(clienteDAO);
    }
    @Bean
    public ClienteCreateService clienteCreateService(ClienteRepository repository, ClienteEventCreate eventCreate) {
        return new ClienteCreateService(repository, eventCreate);
    }
    @Bean
    public ClienteDeleteService deleteService(ClienteDAO clienteDAO, ClienteRepository clienteRepository){
        return new ClienteDeleteService( clienteDAO,
                clienteRepository);

    }
    @Bean
    public ClienteByIdService clienteByIdService(ClienteDAO clienteDAO) {
        return new ClienteByIdService(clienteDAO);
    }

    @Bean
    public ClienteUpdateService clienteUpdateService(ClienteDAO clienteDAO, ClienteRepository repository){
        return new ClienteUpdateService(clienteDAO, repository);
    }
}
