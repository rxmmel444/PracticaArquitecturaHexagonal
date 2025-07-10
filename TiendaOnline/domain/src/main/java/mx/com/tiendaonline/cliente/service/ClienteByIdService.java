package mx.com.tiendaonline.cliente.service;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;

@RequiredArgsConstructor

public class ClienteByIdService {

    private final ClienteDAO dao;
    public Cliente ejecutar(Long id){
        return dao.getById(id);
    }
}
