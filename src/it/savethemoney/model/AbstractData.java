package it.savethemoney.model;

public abstract class AbstractData {
	
	private String name;
	
	public AbstractData(String nameData) {
		this.name = nameData;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void modifyData(String newName) {
		this.name = newName;
	}
}
