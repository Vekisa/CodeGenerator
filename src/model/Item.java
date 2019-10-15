package model;

import java.util.ArrayList;

import windows.main.MainWindow;

public class Item {
	
	protected String name;
	protected ArrayList<Item> children;
	private int id;
	
	public Item() {
		children = new ArrayList<Item>();
		id = this.hashCode();
	}
	
	public ArrayList<Item> getChildren(){
		return children;
	}
	
	public void addChild(Item item) {
		children.add(item);
		MainWindow.getInstance().getNavigationBar().refresh();
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}

