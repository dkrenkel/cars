/**
 * 
 */
package br.com.support.business.facade.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import br.com.support.business.dto.ClientDTO;
import br.com.support.business.facade.ClientFacadeable;
import br.com.support.business.mapper.ClientMapper;
import br.com.support.core.repository.ClientRepository;
import br.com.support.model.Client;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
@Service
public class ClientFacade extends CrudFacade<ClientDTO, 
											Client, 
											ClientRepository, 
											ClientMapper>
											implements ClientFacadeable {
	
}
