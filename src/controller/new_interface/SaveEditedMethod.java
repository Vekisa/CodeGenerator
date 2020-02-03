package controller.new_interface;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_interface.NewInterfaceWindow;
import windows.new_interface.NewMethodWindow;

public class SaveEditedMethod extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1294894621013035264L;

	public SaveEditedMethod(){
		super("Save", null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = NewInterfaceWindow.getInstance().getTable().getSelectedRow();
		
		NewInterfaceWindow.getInstance().getTable().setValueAt(NewMethodWindow.getInstance().getAcsModifier().getSelectedItem().toString(),
				row, NewInterfaceWindow.getInstance().getTable().getColumn("AcsModifier").getModelIndex());
		NewInterfaceWindow.getInstance().getTable().setValueAt(NewMethodWindow.getInstance().getIsStatic().isSelected(),
				row, NewInterfaceWindow.getInstance().getTable().getColumn("Static").getModelIndex());
		NewInterfaceWindow.getInstance().getTable().setValueAt(NewMethodWindow.getInstance().getCombo().getSelectedItem().toString(),
				row, NewInterfaceWindow.getInstance().getTable().getColumn("Return Value").getModelIndex());
		NewInterfaceWindow.getInstance().getTable().setValueAt(NewMethodWindow.getInstance().getMethodName().getText(),
				row, NewInterfaceWindow.getInstance().getTable().getColumn("Name").getModelIndex());
		NewInterfaceWindow.getInstance().getTable().setValueAt(NewMethodWindow.getInstance().getVirtual().isSelected(),
				row, NewInterfaceWindow.getInstance().getTable().getColumn("Virtual").getModelIndex());
		NewInterfaceWindow.getInstance().getTable().setValueAt(NewMethodWindow.getInstance().tableToArray(),
				row, NewInterfaceWindow.getInstance().getTable().getColumn("HiddenParameters").getModelIndex());
		NewInterfaceWindow.getInstance().getTable().setValueAt(NewMethodWindow.getInstance().tableToString(),
				row, NewInterfaceWindow.getInstance().getTable().getColumn("Parameters").getModelIndex());
		
		NewMethodWindow.getInstance().setTable();
		NewMethodWindow.getInstance().dispose();
	}

}
