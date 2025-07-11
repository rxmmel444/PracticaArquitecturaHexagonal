package mx.com.tiendaonline.compraproducto.adapter.jpa;

import mx.com.tiendaonline.compraproducto.adapter.entity.CompraEntity;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraJpaAdapterRespository extends JpaRepository<CompraEntity,Long> {
}
