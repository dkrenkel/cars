/**
 * 
 */
package br.com.cars.business.mapper;

import org.springframework.stereotype.Component;

import br.com.cars.business.dto.CarDTO;
import br.com.cars.model.Car;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
@Component
public class CarMapper implements Mappeable<Car, CarDTO> {

	@Override
	public Car map(CarDTO dto) {
		//TODO implement mapper
		return null;
	}
	
	@Override
	public CarDTO map(Car entity) {
		//TODO implement mapper
		return null;
	}

}
