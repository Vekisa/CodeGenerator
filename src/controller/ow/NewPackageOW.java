package controller.ow;

import java.awt.event.ActionEvent;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import windows.InternalConfiguration;
import windows.new_package.NewPackageWindow;

public class NewPackageOW extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7171665243932292433L;

	public NewPackageOW() {
		super("Package", InternalConfiguration.packageIcon);
	    putValue(SHORT_DESCRIPTION, "Create a project");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		NewPackageWindow.getInstance();
	}

}
