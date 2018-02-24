/**
 * 
 */
package br.com.cars.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cars.business.dto.CarDTO;
import br.com.cars.business.error.EntityNotFoundException;
import br.com.cars.business.error.ExistingEntityException;
import br.com.cars.business.facade.CarFacadeable;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
@RestController
@RequestMapping("cars")
public class CarController {

	@Autowired
	private CarFacadeable userFacade;
}
