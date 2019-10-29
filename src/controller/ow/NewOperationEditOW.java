package controller.ow;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_class.NewClassWindow;
import windows.new_class.NewOperationWindow;

public class NewOperationEditOW extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2169785554031530852L;
	
	public NewOperationEditOW() {
		super("Edit", null);
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int row = NewClassWindow.getInstance().getTable2().getSelectedRow();
		
		NewOperationWindow.getInstance().setAcsModifier(NewClassWindow.getInstance().getTable2()
				.getValueAt(row, NewClassWindow.getInstance().getTable2().getColumn("AcsModifier").getModelIndex()).toString());
		NewOperationWindow.getInstance().setStaticBox(NewClassWindow.getInstance().getTable2()
				.getValueAt(row, NewClassWindow.getInstance().getTable2().getColumn("Static").getModelIndex()).toString());
		NewOperationWindow.getInstance().setCombo(NewClassWindow.getInstance().getTable2()
				.getValueAt(row, NewClassWindow.getInstance().getTable2().getColumn("Return Value").getModelIndex()).toString());
		NewOperationWindow.getInstance().setMethodName(NewClassWindow.getInstance().getTable2()
				.getValueAt(row, NewClassWindow.getInstance().getTable2().getColumn("Name").getModelIndex()).toString());
		NewOperationWindow.getInstance().setVirtual(NewClassWindow.getInstance().getTable2()
				.getValueAt(row, NewClassWindow.getInstance().getTable2().getColumn("Virtual").getModelIndex()).toString());
		NewOperationWindow.getInstance().arrayToTable(row);
		NewOperationWindow.getInstance().getCreateButton().hide();
		NewOperationWindow.getInstance().getSaveButton().show();
		NewOperationWindow.getInstance();
		
	}
	
}
