/**
 * 
 */
package br.com.cars.business.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cars.business.dto.CarDTO;
import br.com.cars.business.error.EntityNotFoundException;
import br.com.cars.business.error.ExistingEntityException;
import br.com.cars.business.facade.CarFacadeable;
import br.com.cars.business.mapper.CarMapper;
import br.com.cars.core.repository.CarRepository;
import br.com.cars.model.Car;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
@Service
public class CarFacade implements CarFacadeable {

	@Resource
	private CarRepository userRepository;

	@Autowired
	private CarMapper carMapper;

	@Override
	public void saveCar(CarDTO carrDTO) throws ExistingEntityException {
		//TODO check if the car already exists
		Car car = null;
		if (car != null) {
			throw new ExistingEntityException("Entity already exists");
		}
		this.userRepository.save(this.carMapper.map(carrDTO));
	}
	
	@Override
	@Transactional
	public void saveCars(List<CarDTO> usersDTO) throws ExistingEntityException {
		//TODO implement
	}

	@Override
	public void updateCar(CarDTO userDTO) throws EntityNotFoundException {
		//TODO implement
	}

}
