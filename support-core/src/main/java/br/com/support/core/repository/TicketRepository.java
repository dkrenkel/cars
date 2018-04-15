package br.com.support.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.support.model.Ticket;

/**
 * 
 * @author Luiz Vieira <jun.luiz@gmail.com>
 *
 */
public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
