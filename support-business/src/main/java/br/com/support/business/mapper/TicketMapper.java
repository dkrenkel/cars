package br.com.support.business.mapper;

import br.com.support.business.dto.TicketDTO;
import br.com.support.model.Ticket;

public class TicketMapper implements Mappeable<Ticket, TicketDTO> {

	@Override
	public Ticket map(TicketDTO dto) {
		Ticket ticket = new Ticket();
		ticket.setId(dto.getId());
		ticket.setNumber(dto.getNumber());
		return ticket;
	}

	@Override
	public TicketDTO map(Ticket ticket) {
		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO.setId(ticket.getId());
		ticketDTO.setNumber(ticket.getNumber());
		return ticketDTO;
	}

}
