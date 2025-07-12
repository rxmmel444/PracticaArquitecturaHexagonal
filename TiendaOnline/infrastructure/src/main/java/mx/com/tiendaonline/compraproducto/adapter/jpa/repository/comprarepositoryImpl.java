package mx.com.tiendaonline.compraproducto.adapter.jpa.repository;

import mx.com.tiendaonline.compraproducto.adapter.jpa.CompraJpaAdapterRespository;
import mx.com.tiendaonline.compraproducto.adapter.mapper.CompraDboMapper;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import mx.com.tiendaonline.compraproducto.port.repository.CompraRespository;
import org.springframework.stereotype.Repository;

@Repository
public class comprarepositoryImpl implements CompraRespository {

    private final CompraJpaAdapterRespository respository;
    private final CompraDboMapper compraDboMapper;

    public comprarepositoryImpl(CompraJpaAdapterRespository respository, CompraDboMapper compraDboMapper) {
        this.respository = respository;
        this.compraDboMapper = compraDboMapper;
    }


    @Override
    public Compra create(Compra compra) {
        var compraEntity = compraDboMapper.toDbo(compra);
        var save = respository.save(compraEntity);
        return compraDboMapper.toDomain(save);
    }

    @Override
    public Compra update(Compra compra, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
