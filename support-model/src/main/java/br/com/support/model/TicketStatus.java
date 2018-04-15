package br.com.support.model;

public enum TicketStatus {
	OPEN("Open"),
	CLOSED("Closed");
	
	private String description;
	
	private TicketStatus(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
