package controller.new_class;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_class.NewOperationWindow;
import windows.new_class.NewParameterWindow;

public class NewOperationParameter extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 784587598553633014L;

	public NewOperationParameter() {
		super("Add new Parameter", null);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object[] data = 
			{NewParameterWindow.getInstance().getCombo().getSelectedItem().toString()
			,NewParameterWindow.getInstance().getParameterName().getText()
			,NewParameterWindow.getInstance().getStaticBox().isSelected()
			,NewParameterWindow.getInstance().getVirtual().isSelected()
			,NewParameterWindow.getInstance().getGetters().isSelected()
			,NewParameterWindow.getInstance().getSetters().isSelected()};
		
		NewOperationWindow.getInstance().addingRowTable(data);
		NewParameterWindow.getInstance().setParameterName();
		NewParameterWindow.getInstance().dispose();
	}

}
