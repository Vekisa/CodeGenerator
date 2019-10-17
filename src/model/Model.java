package model;

import windows.main.MainWindow;

public class Model {
	
	Project project;
	
	public Model () {
		
	}
	
	public void setProject(Project project) {
		this.project = project;
		MainWindow.getInstance().getNavigationBar().refresh();
	}
	
	public Project getProject() {
		return project;
	}
	
	public Item getItemWithId(int id) {
		return getItemWithIdRecursive(project, id);
	}
	
	public void removeItemWithId(int id) {
		removeItem(project, id);
		MainWindow.getInstance().getNavigationBar().removeSelecetedNode();
	}
	
	private void removeItem(Item item, int id) {
		Item forDelete = null;
		if(item.getId() == id)
			project = null;
		for(Item itemPom : item.getChildren()) {
			if(itemPom.getId() == id)
				forDelete = itemPom;
			else
				removeItem(itemPom,id);
		}
		if(forDelete !=null)
			item.getChildren().remove(forDelete);
	}
	
	private Item getItemWithIdRecursive(Item item, int id) {
		if(item.getId() == id)
			return item;
		for(Item itemPom : item.getChildren())
			return getItemWithIdRecursive(itemPom,id);
		return null;
	}
}
