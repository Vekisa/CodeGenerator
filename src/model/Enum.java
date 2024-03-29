package model;

import java.util.ArrayList;

public class Enum extends Item implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3424945810697166137L;
	private String enumName;
	private ArrayList<String> items;
	
	public Enum() {
		super();
		items = new ArrayList<String>();
	}

	public String getEnumName() {
		return enumName;
	}

	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}

	public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		this.items = items;
	}
}
