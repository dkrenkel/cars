/**
 * 
 */
package br.com.support.api.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.support.business.dto.ClientDTO;
import br.com.support.business.error.ExistingEntityException;
import br.com.support.business.facade.ClientFacadeable;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
@RestController
@RequestMapping("clients")
public class ClientController {
	
	private static final Logger LOGGER = LogManager.getLogger(ClientController.class);

	@Autowired
	private ClientFacadeable clientFacade;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> createClient(@RequestBody final ClientDTO client) {
		LOGGER.info("M=createClient");
		try {
			this.clientFacade.saveClient(client);
		} catch (ExistingEntityException e) {
			LOGGER.warn("M=createClient, client already exists");
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return new ResponseEntity<ClientDTO>(client, HttpStatus.CREATED);
	}
}
