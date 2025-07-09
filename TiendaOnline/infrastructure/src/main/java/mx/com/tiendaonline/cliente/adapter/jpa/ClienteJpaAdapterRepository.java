package mx.com.tiendaonline.cliente.adapter.jpa;
import mx.com.tiendaonline.cliente.adapter.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClienteJpaAdapterRepository extends JpaRepository<ClienteEntity,Long> {
}
