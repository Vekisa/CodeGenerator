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
	
	private Item getItemWithIdRecursive(Item item, int id) {
		if(item.getId() == id)
			return item;
		for(Item itemPom : item.getChildren())
			return getItemWithIdRecursive(itemPom,id);
		return null;
	}
}
