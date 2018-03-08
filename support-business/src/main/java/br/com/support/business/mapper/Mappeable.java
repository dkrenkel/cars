/**
 * 
 */
package br.com.support.business.mapper;

import br.com.support.business.dto.Transferable;
import br.com.support.model.BaseEntity;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public interface Mappeable<MODEL extends BaseEntity, DTO extends Transferable> {
	
	/**
	 * Converts a transferable object into an entity object
	 * @param dto
	 * @return The appropriate entity object
	 */
	MODEL map(DTO dto);
	
	/**
	 * Converts an entity object into a transferable object
	 * @param entity
	 * @return The appropriate transferable object
	 */
	DTO map(MODEL entity);

}
