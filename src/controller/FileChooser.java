package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;

import windows.Configuration;

public class FileChooser extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1551366729088430029L;
	
	public FileChooser() {
		super("Open", Configuration.folderIcon);
	    putValue(SHORT_DESCRIPTION, "Open project");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JFileChooser fc = new JFileChooser();
		//In response to a button click:
		fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fc.showOpenDialog((Component) arg0.getSource());
	}

}
