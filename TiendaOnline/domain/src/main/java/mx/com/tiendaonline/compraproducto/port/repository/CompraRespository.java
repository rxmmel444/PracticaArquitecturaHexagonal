package mx.com.tiendaonline.compraproducto.port.repository;

import mx.com.tiendaonline.compraproducto.model.entity.Compra;

public interface CompraRespository {

    Compra  create (Compra compra);
    Compra update(Compra compra,Long id);
    void delete(Long id);
}
