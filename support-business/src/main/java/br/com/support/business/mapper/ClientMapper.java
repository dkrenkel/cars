/**
 * 
 */
package br.com.support.business.mapper;

import org.springframework.stereotype.Component;

import br.com.support.business.dto.ClientDTO;
import br.com.support.model.Client;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
@Component
public class ClientMapper implements Mappeable<Client, ClientDTO> {

	@Override
	public Client map(ClientDTO dto) {
		Client entity = new Client();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}
	
	@Override
	public ClientDTO map(Client entity) {
		ClientDTO dto = new ClientDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}

}
