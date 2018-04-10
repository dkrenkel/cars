/**
 * 
 */
package br.com.support.business.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.support.business.dto.ClientDTO;
import br.com.support.business.error.EntityNotFoundException;
import br.com.support.business.error.ExistingEntityException;
import br.com.support.business.facade.ClientFacadeable;
import br.com.support.business.mapper.ClientMapper;
import br.com.support.core.repository.ClientRepository;
import br.com.support.model.Client;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
@Service
public class ClientFacade implements ClientFacadeable {

	@Resource
	private ClientRepository clientRepository;

	@Autowired
	private ClientMapper clientMapper;

	@Override
	public void saveClient(ClientDTO clientDTO) throws ExistingEntityException {
		//TODO check if the client already exists
		Client client = null;
		if (client != null) {
			throw new ExistingEntityException("Entity already exists");
		}
		this.clientRepository.save(this.clientMapper.map(clientDTO));
	}

	@Override
	public void updateClient(ClientDTO clientDTO) throws EntityNotFoundException {
		Client client = this.clientRepository.findOne(clientDTO.getId());
		if (client == null) {
			throw new EntityNotFoundException("Entity does not exist");
		}
		this.clientRepository.saveAndFlush(this.clientMapper.map(clientDTO));
		
	}
	
	@Override
	public List<ClientDTO> findAll(){
		List<ClientDTO> list = new ArrayList<ClientDTO>();
		for(Client c : this.clientRepository.findAll()) {
			list.add(clientMapper.map(c));
		}
		return list; 
	}
}
