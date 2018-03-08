/**
 * 
 */
package br.com.support.business.facade;

import java.util.List;

import br.com.support.business.dto.CarDTO;
import br.com.support.business.error.EntityNotFoundException;
import br.com.support.business.error.ExistingEntityException;

/**
 * Business Interface responsible for defining an abstract contract for business
 * operations
 * 
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public interface CarFacadeable {

	/**
	 * Saves a new car into the databse
	 * 
	 * @param carDTO
	 *            The car to be created
	 * @throws ExistingEntityException
	 *             When the given car already exsists
	 */
	public void saveCar(CarDTO car) throws ExistingEntityException;

	/**
	 * Saves a list of cars into the databse
	 * 
	 * @param cars
	 *            The list of cars to be created
	 * @throws ExistingEntityException
	 *             When any of the given cars already exsists
	 */
	public void saveCars(List<CarDTO> cars) throws ExistingEntityException;

	/**
	 * Updates an existing car
	 * 
	 * @param car
	 *            The car to be updated
	 * @throws EntityNotFoundException
	 *             When the given car can't be found
	 */
	public void updateCar(CarDTO car) throws EntityNotFoundException;

}
