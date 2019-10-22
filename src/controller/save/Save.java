package controller.save;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import serialization.Serializer;
import windows.Configuration;
import windows.FileChooser;
import windows.main.MainWindow;
import windows.message.MessageDialog;

public class Save extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8648240095381746125L;
	
	public Save() {
		super("Save", Configuration.saveIcon);
	    putValue(SHORT_DESCRIPTION, "Save");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(MainWindow.getInstance().getModel().getProject() != null && 
				MainWindow.getInstance().getModel().getProject().getPath() != null) {
			Serializer.serialize(MainWindow.getInstance().getModel().getProject(),
					MainWindow.getInstance().getModel().getProject().getPath());
		}else if(MainWindow.getInstance().getModel().getProject() != null && 
				MainWindow.getInstance().getModel().getProject().getPath() == null) {
			String path = FileChooser.saveFile();
			Serializer.serialize(MainWindow.getInstance().getModel().getProject(), path);
			MainWindow.getInstance().getModel().getProject().setPath(path);
		}else {
			MessageDialog.showMessage("Empty wokrspace!");
		}
	}

}
