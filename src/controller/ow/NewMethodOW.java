package controller.ow;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_interface.NewMethodWindow;

public class NewMethodOW extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -935242717569838943L;
	
	public NewMethodOW() {
		super("New Method", null);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		NewMethodWindow.getInstance();
		NewMethodWindow.getInstance().setTable();
	}

}
