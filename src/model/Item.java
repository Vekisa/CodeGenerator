package model;

import java.util.ArrayList;

import windows.main.MainWindow;

public class Item implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1171943828571653867L;
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
		MainWindow.getInstance().getNavigationBar().insertInSelectedNode(item);
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}

