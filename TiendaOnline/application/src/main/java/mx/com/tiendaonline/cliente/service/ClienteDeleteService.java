package mx.com.tiendaonline.cliente.service;

import lombok.RequiredArgsConstructor;
import mx.com.tiendaonline.cliente.port.dao.ClienteDAO;
import mx.com.tiendaonline.cliente.port.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteDeleteService {

    private final ClienteDAO dao;
    private final ClienteRepository repository;

    public void ejecutar(Long id){
        var cliente = dao.getById(id);
        repository.delete(cliente.getId());
    }
}
