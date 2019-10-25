package controller.ow;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_class.NewParameterWindow;

public class NewParameterOW extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8370999044162972976L;
	
	public NewParameterOW() {
		super("Add Parameter", null);
	    putValue(SHORT_DESCRIPTION, "Add new parameter");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		NewParameterWindow.getInstance();
		
	}
	
}
