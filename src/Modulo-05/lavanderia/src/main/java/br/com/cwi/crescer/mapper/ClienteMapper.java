package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.dto.ClienteDto;

public class ClienteMapper {
	
	public static Cliente getNewEntity(ClienteDto dto) {
        Cliente entity = new Cliente();
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setBairro(dto.getBairro());
        entity.setEndereco(dto.getEndereco());
        entity.setCep(dto.getCep());
        return entity;
    }

    public static ClienteDto toDTO(Cliente entity) {
        ClienteDto dto = new ClienteDto();
        dto.setId(entity.getIdCliente());
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        dto.setEmail(entity.getEmail());
        dto.setIdCidade(entity.getCidade().getIdCidade());
        dto.setBairro(entity.getBairro());
        dto.setCep(entity.getCep());
        dto.setEndereco(entity.getEndereco());
        return dto;
    }

    public static Cliente merge(ClienteDto dto, Cliente entity) {
    	entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setBairro(dto.getBairro());
        entity.setEndereco(dto.getEndereco());
        entity.setCep(dto.getCep());
        return entity;
    }

}
