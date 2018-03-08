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
		//TODO implement mapper
		return null;
	}
	
	@Override
	public ClientDTO map(Client entity) {
		//TODO implement mapper
		return null;
	}

}
