package controller.new_interface;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_interface.NewInterfaceWindow;
import windows.new_interface.NewMethodWindow;

public class NewMethod extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3156078052611153828L;

	public NewMethod() {
		super("Create", null);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object[] data = {
				NewMethodWindow.getInstance().getAcsModifier().getSelectedItem().toString(),
				NewMethodWindow.getInstance().getIsStatic().isSelected(),
				NewMethodWindow.getInstance().getCombo().getSelectedItem().toString(),
				NewMethodWindow.getInstance().getMethodName().getText(),
				NewMethodWindow.getInstance().getVirtual().isSelected(),
				NewMethodWindow.getInstance().tableToArray(),
				NewMethodWindow.getInstance().tableToString()
		};
		NewInterfaceWindow.getInstance().addingRowTableOperations(data);
		NewMethodWindow.getInstance().setTableClear();
		NewMethodWindow.getInstance().dispose();
		NewInterfaceWindow.getInstance();
		
	}

}
