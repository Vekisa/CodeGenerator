package controller.new_class;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_class.NewClassWindow;
import windows.new_class.NewOperationWindow;

public class NewOperation extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -578139144303920617L;

	public NewOperation() {
		super("Add Operation", null);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object[] data = 
			{NewOperationWindow.getInstance().getAcsModifier().getSelectedItem().toString()
			,NewOperationWindow.getInstance().getStaticBox().isSelected()
			,NewOperationWindow.getInstance().getCombo().getSelectedItem().toString()
			,NewOperationWindow.getInstance().getMethodName().getText()
			,NewOperationWindow.getInstance().getVirtual().isSelected()
			,NewOperationWindow.getInstance().tableToArray()
			,NewOperationWindow.getInstance().tableToString()};
		
		NewClassWindow.getInstance().addingRowTableOperations(data);
		NewOperationWindow.getInstance().getMethodName().setText("");
		NewOperationWindow.getInstance().setStaticBox(false);
		NewOperationWindow.getInstance().setVirtual(false);
		NewOperationWindow.getInstance().setTable();
		NewOperationWindow.getInstance().dispose();
	}

}
