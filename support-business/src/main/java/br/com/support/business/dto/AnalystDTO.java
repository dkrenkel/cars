package br.com.support.business.dto;


/**
 * @author Luiz Vieira <jun.luiz@gmail.com>
 *
 */
public class AnalystDTO implements Transferable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
