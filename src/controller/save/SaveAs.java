package controller.save;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import serialization.Serializer;
import windows.Configuration;
import windows.FileChooser;
import windows.main.MainWindow;

public class SaveAs extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438430419111178822L;
	
	public SaveAs() {
		super("Save As", Configuration.saveIcon);
	    putValue(SHORT_DESCRIPTION, "Save as");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String path = FileChooser.saveFile();
		Serializer.serialize(MainWindow.getInstance().getModel().getProject(), path);
	}

}
