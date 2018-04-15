package br.com.support.business.dto;

/**
 * 
 * @author Luiz Vieira <jun.luiz@gmail.com>
 *
 */
public class TicketDTO implements Transferable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
