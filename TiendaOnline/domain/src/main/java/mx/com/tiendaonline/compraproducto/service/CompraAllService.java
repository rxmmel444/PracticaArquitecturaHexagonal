package mx.com.tiendaonline.compraproducto.service;

import mx.com.tiendaonline.compraproducto.model.entity.Compra;
import mx.com.tiendaonline.compraproducto.port.dao.CompraDAO;

import java.util.List;

public class CompraAllService {

    private final CompraDAO compraDAO;

    public CompraAllService(CompraDAO compraDAO) {
        this.compraDAO = compraDAO;
    }


    public List<Compra> ejecutar() {
        return compraDAO.getAll();
    }

}
