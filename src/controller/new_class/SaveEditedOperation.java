package controller.new_class;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_class.NewClassWindow;
import windows.new_class.NewOperationWindow;

public class SaveEditedOperation extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4493538295062822253L;
	
	public SaveEditedOperation() {
		// TODO Auto-generated constructor stub
		super("Save", null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {		
		int selectedIndex = NewClassWindow.getInstance().getTable2().getSelectedRow();
		NewClassWindow.getInstance().getTable2().setValueAt(NewOperationWindow.getInstance().getAcsModifier().getSelectedItem().toString(), 
				selectedIndex, NewClassWindow.getInstance().getTable2().getColumn("AcsModifier").getModelIndex());
		NewClassWindow.getInstance().getTable2().setValueAt(NewOperationWindow.getInstance().getStaticBox().isSelected(), 
				selectedIndex, NewClassWindow.getInstance().getTable2().getColumn("Static").getModelIndex());
		NewClassWindow.getInstance().getTable2().setValueAt(NewOperationWindow.getInstance().getCombo().getSelectedItem().toString(), 
				selectedIndex, NewClassWindow.getInstance().getTable2().getColumn("Return Value").getModelIndex());
		NewClassWindow.getInstance().getTable2().setValueAt(NewOperationWindow.getInstance().getMethodName().getText(), 
				selectedIndex, NewClassWindow.getInstance().getTable2().getColumn("Name").getModelIndex());
		NewClassWindow.getInstance().getTable2().setValueAt(NewOperationWindow.getInstance().getVirtual().isSelected(), 
				selectedIndex, NewClassWindow.getInstance().getTable2().getColumn("Virtual").getModelIndex());
		NewClassWindow.getInstance().getTable2().setValueAt(NewOperationWindow.getInstance().tableToArray(), 
				selectedIndex, NewClassWindow.getInstance().getTable2().getColumn("HiddenParameters").getModelIndex());
		NewClassWindow.getInstance().getTable2().setValueAt(NewOperationWindow.getInstance().tableToString(), 
				selectedIndex, NewClassWindow.getInstance().getTable2().getColumn("Parameters").getModelIndex());
		NewOperationWindow.getInstance().setTable();
		
	}

}
