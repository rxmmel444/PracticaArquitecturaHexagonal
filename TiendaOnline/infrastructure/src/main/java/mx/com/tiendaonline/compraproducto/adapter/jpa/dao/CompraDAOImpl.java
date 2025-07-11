package mx.com.tiendaonline.compraproducto.adapter.jpa.dao;
import mx.com.tiendaonline.compraproducto.adapter.jpa.CompraJpaAdapterRespository;
import mx.com.tiendaonline.compraproducto.adapter.mapper.CompraDboMapper;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import org.springframework.stereotype.Repository;
import mx.com.tiendaonline.compraproducto.port.dao.CompraDAO;

import java.util.List;
@Repository
public class CompraDAOImpl implements CompraDAO {

   private final CompraJpaAdapterRespository respository;
   private final CompraDboMapper compraDboMapper;

    public CompraDAOImpl(CompraJpaAdapterRespository respository, CompraDboMapper compraDboMapper) {
        this.respository = respository;
        this.compraDboMapper = compraDboMapper;
    }

    @Override
    public Compra getById(Long id) {
        return null;
    }

    @Override
    public List<Compra> getAll() {
        return List.of();
    }
}
