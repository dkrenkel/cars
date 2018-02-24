/**
 * 
 */
package br.com.cars.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cars.model.Car;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public interface CarRepository extends JpaRepository<Car, Long> {
	
}
