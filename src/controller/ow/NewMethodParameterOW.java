package controller.ow;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_interface.NewMethodParameterWindow;

public class NewMethodParameterOW extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8798539960500136508L;
	
	public NewMethodParameterOW() {
		super("Add", null);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		NewMethodParameterWindow.getInstance();
		
	}

}
