/**
 * 
 */
package br.com.support.business.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

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

	private static final Logger LOGGER = LogManager.getLogger(ClientFacade.class);
	
	@Resource
	private ClientRepository clientRepository;

	@Autowired
	private ClientMapper clientMapper;

	@Override
	public ClientDTO saveClient(ClientDTO clientDTO) throws ExistingEntityException {
		LOGGER.info(String.format("m=saveClient, client name = %s", clientDTO.getName()));
		ExampleMatcher matcher = ExampleMatcher.matching()
												.withIgnoreCase()
												.withIgnoreNullValues()
												.withMatcher("name", match -> match.exact());
		
		Example<Client> example = Example.of(this.clientMapper.map(clientDTO), matcher);
		
		Client client = this.clientRepository.findOne(example);
		if (client != null) {
			LOGGER.warn(String.format("m=saveClient, client %s already exists", clientDTO.getName()));
			throw new ExistingEntityException("Entity already exists");
		}
		return this.clientMapper.map(this.clientRepository.save(this.clientMapper.map(clientDTO)));
	}

	@Override
	public void updateClient(ClientDTO clientDTO) throws EntityNotFoundException {
		LOGGER.info(String.format("m=updateClient, client name = %s", clientDTO.getName()));
		Client client = this.clientRepository.findOne(clientDTO.getId());
		if (client == null) {
			LOGGER.warn(String.format("m=saveClient, client %s does not exist", clientDTO.getName()));
			throw new EntityNotFoundException("Entity does not exist");
		}
		this.clientRepository.saveAndFlush(this.clientMapper.map(clientDTO));
		
	}
	
	@Override
	@Cacheable("clients")
	public List<ClientDTO> findAll(){
		LOGGER.info(String.format("m=findAll, clients"));
		List<ClientDTO> list = new ArrayList<ClientDTO>();
		for(Client c : this.clientRepository.findAll()) {
			list.add(clientMapper.map(c));
		}
		return list; 
	}
}
