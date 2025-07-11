package mx.com.tiendaonline.compraproducto.adapter.jpa.dao;

import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CompraDAO implements mx.com.tiendaonline.compraproducto.port.dao.CompraDAO {
    @Override
    public Compra getById(Long id) {
        return null;
    }

    @Override
    public List<Compra> getAll() {
        return List.of();
    }
}
