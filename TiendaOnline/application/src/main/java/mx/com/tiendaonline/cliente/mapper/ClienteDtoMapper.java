package mx.com.tiendaonline.cliente.mapper;

import mx.com.tiendaonline.cliente.command.ClienteCreateCommand;
import mx.com.tiendaonline.cliente.dto.ClienteDTO;
import mx.com.tiendaonline.cliente.model.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ClienteDtoMapper {


    @Mapping(source = "id" , target = "id")
    @Mapping(source = "nombre" , target = "nombre")
    @Mapping(source = "apellido" , target = "apellido")
    @Mapping(source = "email" , target = "email")
    @Mapping(source = "telefono" , target = "telefono")
    @Mapping(source = "direccion" , target = "direccion")
    ClienteDTO domainToDto(Cliente domain);


    @Mapping(source = "id" , target = "id")
    @Mapping(source = "nombre" , target = "nombre")
    @Mapping(source = "apellido" , target = "apellido")
    @Mapping(source = "email" , target = "email")
    @Mapping(source = "telefono" , target = "telefono")
    @Mapping(source = "direccion" , target = "direccion")
    ClienteCreateCommand toCommand(ClienteDTO clienteDTO);

}
