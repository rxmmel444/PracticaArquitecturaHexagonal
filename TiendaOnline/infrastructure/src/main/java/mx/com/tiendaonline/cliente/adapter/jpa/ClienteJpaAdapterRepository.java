package mx.com.tiendaonline.cliente.adapter.jpa;


import mx.com.tiendaonline.cliente.adapter.entity.ClienteEntity;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClienteJpaAdapterRepository extends JpaRepository<ClienteEntity,Long> {
}
