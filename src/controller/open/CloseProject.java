package controller.open;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.main.MainWindow;

public class CloseProject extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3563590360318922247L;

	public CloseProject() {
		// TODO Auto-generated constructor stub
		super("Close Project",null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainWindow.getInstance().getModel().setProject(null);
	}

}
