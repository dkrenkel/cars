/**
 * 
 */
package br.com.support.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.support.business.facade.CarFacadeable;

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
