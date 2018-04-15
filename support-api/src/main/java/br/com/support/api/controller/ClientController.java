/**
 * 
 */
package br.com.support.api.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.support.business.dto.ClientDTO;
import br.com.support.business.error.EntityNotFoundException;
import br.com.support.business.error.ExistingEntityException;
import br.com.support.business.facade.ClientFacadeable;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
@RestController
@RequestMapping("/clients")
public class ClientController {
	
	private static final Logger LOGGER = LogManager.getLogger(ClientController.class);

	@Autowired
	private ClientFacadeable clientFacade;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> createClient(@RequestBody final ClientDTO client) {
		LOGGER.info("M=createClient");
		ClientDTO savedClient = null;
		try {
			savedClient = this.clientFacade.save(client);
		} catch (ExistingEntityException e) {
			LOGGER.warn("M=createClient, client already exists");
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return new ResponseEntity<ClientDTO>(savedClient, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateClient(@PathVariable long id, @RequestBody final ClientDTO client){
		try {
			this.clientFacade.update(id, client);
		} catch (EntityNotFoundException e) {
			LOGGER.warn("M=updateClient, client does not exist");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return new ResponseEntity<ClientDTO>(client, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<ClientDTO>>(this.clientFacade.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable long id) {
		try {
			return new ResponseEntity<ClientDTO>(this.clientFacade.findOne(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
