package model;

import java.util.ArrayList;

public class Interface extends Item implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7527555816402607666L;
	private String name;
	private ArrayList<Operation> operations;
	
	public Interface() {
		operations = new ArrayList<Operation>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Operation> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<Operation> operations) {
		this.operations = operations;
	}
}
