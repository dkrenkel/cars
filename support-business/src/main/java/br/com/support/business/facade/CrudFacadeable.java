package br.com.support.business.facade;

import java.util.List;

import br.com.support.business.dto.Transferable;
import br.com.support.business.error.EntityNotFoundException;
import br.com.support.business.error.ExistingEntityException;

/**
 * 
 * @author Luiz Vieira <jun.luiz@gmail.com>
 *
 */
public interface CrudFacadeable<DTO extends Transferable> {

	public DTO save(DTO dto) throws ExistingEntityException;
	
	public Transferable update(long id, DTO dto) throws EntityNotFoundException;
	
	public void delete(long id) throws EntityNotFoundException;
	
	public DTO findOne(long id) throws EntityNotFoundException;
	
	public List<DTO> findAll();
}
