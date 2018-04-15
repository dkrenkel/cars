package br.com.support.business.facade.impl;

import br.com.support.business.dto.TicketDTO;
import br.com.support.business.mapper.TicketMapper;
import br.com.support.core.repository.TicketRepository;
import br.com.support.model.Ticket;

public class TicketFacade extends CrudFacade<TicketDTO, 
												Ticket,
												TicketRepository,
												TicketMapper>{

}
