package controller.ow;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_class.NewOperationWindow;

public class NewOperationOW extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8964257861010556681L;
	
	public NewOperationOW() {
		super("Add operation", null);
	    putValue(SHORT_DESCRIPTION, "Add new operation");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		NewOperationWindow.getInstance().getCreateButton().show();
		NewOperationWindow.getInstance().getSaveButton().hide();
		NewOperationWindow.getInstance();
		NewOperationWindow.getInstance().setTable();
	}

}
