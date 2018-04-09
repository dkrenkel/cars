/**
 * 
 */
package br.com.support.business.facade;

import java.util.List;

import br.com.support.business.dto.ClientDTO;
import br.com.support.business.error.EntityNotFoundException;
import br.com.support.business.error.ExistingEntityException;

/**
 * Business Interface responsible for defining an abstract contract for business
 * operations
 * 
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public interface ClientFacadeable {

	/**
	 * Saves a new client into the databse
	 * 
	 * @param client
	 *            The client to be created
	 * @throws ExistingEntityException
	 *             When the given client already exsists
	 */
	public void saveClient(ClientDTO clientDTO) throws ExistingEntityException;

	/**
	 * Updates an existing client
	 * 
	 * @param client
	 *            The client to be updated
	 * @throws EntityNotFoundException
	 *             When the given client can't be found
	 */
	public void updateClient(ClientDTO clientDTO) throws EntityNotFoundException;

}
