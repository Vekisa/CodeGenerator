package controller.open;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import serialization.Serializer;
import windows.InternalConfiguration;
import windows.FileChooser;
import windows.main.MainWindow;

public class Open extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6750190410942331938L;

	public Open() {
		super("Open", InternalConfiguration.folderIcon);
	    putValue(SHORT_DESCRIPTION, "Open");
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String path = FileChooser.chooseFile();
		model.Project proj = Serializer.deserialize(path);
		if(proj == null)
			return;
		System.out.println(proj.getName() + " " +  proj.getChildren().size());
		MainWindow.getInstance().getModel().setProject(proj);
	}

}
