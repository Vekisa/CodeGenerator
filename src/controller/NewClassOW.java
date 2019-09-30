package controller;

import java.awt.event.ActionEvent;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import windows.new_class.NewClassWindow;

public class NewClassOW extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2000358251564509946L;

	public NewClassOW() {
		Path currentRelativePath = Paths.get("");
		ImageIcon packageIcon = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "/resources/package.png");
	    putValue(SMALL_ICON, packageIcon);
	    putValue(SHORT_DESCRIPTION, "Create a new class");
	    //putValue(MNEMONIC_KEY, mnemonic);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		NewClassWindow.getInstance();
	}
}
