package controller;

import java.awt.event.ActionEvent;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import windows.new_project.NewProjectWindow;

public class NewProjectOW extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7394704850829558623L;

	public NewProjectOW() {
		Path currentRelativePath = Paths.get("");
		ImageIcon packageIcon = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "/resources/package.png");
	    putValue(SMALL_ICON, packageIcon);
	    putValue(SHORT_DESCRIPTION, "Create a new project");
	    //putValue(MNEMONIC_KEY, mnemonic);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		NewProjectWindow.getInstance();
	}

}
