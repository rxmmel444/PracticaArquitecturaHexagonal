package mx.com.tiendaonline.compraproducto.port.dao;

import lombok.AllArgsConstructor;
import mx.com.tiendaonline.compraproducto.model.entity.Compra;

import java.util.List;


public interface CompraDAO {
    Compra getById(Long id);
    List<Compra> getAll();
}
