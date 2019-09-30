package controller.new_project;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Project;
import windows.main.MainWindow;
import windows.new_project.NewProjectWindow;

public class NewProject extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1898614045953815823L;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String name = NewProjectWindow.getInstance().getValue();
		Project newProject = new Project(name);
		MainWindow.getInstance().getModel().setProject(newProject);
		NewProjectWindow.getInstance().dispose();
	}


}
