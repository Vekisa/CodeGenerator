package model;

import java.util.ArrayList;

public class Enum extends Item {

	String enumName;
	ArrayList<String> items;
	
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
