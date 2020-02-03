package controller.ow;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_interface.NewInterfaceWindow;
import windows.new_interface.NewMethodWindow;

public class NewInterfaceMethodEditOW extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5503758608781657813L;

	public NewInterfaceMethodEditOW() {
		super("Edit", null);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = NewInterfaceWindow.getInstance().getTable().getSelectedRow();
		
		NewMethodWindow.getInstance().setAcsModifier(NewInterfaceWindow.getInstance().getTable()
				.getValueAt(row, NewInterfaceWindow.getInstance().getTable().getColumn("AcsModifier").getModelIndex()).toString());
		NewMethodWindow.getInstance().setIsStatic(NewInterfaceWindow.getInstance().getTable()
				.getValueAt(row, NewInterfaceWindow.getInstance().getTable().getColumn("Static").getModelIndex()).toString());
		NewMethodWindow.getInstance().setCombo(NewInterfaceWindow.getInstance().getTable()
				.getValueAt(row, NewInterfaceWindow.getInstance().getTable().getColumn("Return Value").getModelIndex()).toString());
		NewMethodWindow.getInstance().setName(NewInterfaceWindow.getInstance().getTable()
				.getValueAt(row, NewInterfaceWindow.getInstance().getTable().getColumn("Name").getModelIndex()).toString());
		NewMethodWindow.getInstance().setVirtual(NewInterfaceWindow.getInstance().getTable()
				.getValueAt(row, NewInterfaceWindow.getInstance().getTable().getColumn("Virtual").getModelIndex()).toString());
		NewMethodWindow.getInstance().arrayToTable(row);
		NewMethodWindow.getInstance().getCreateBtn().hide();
		NewMethodWindow.getInstance().getSaveButton().show();
		NewMethodWindow.getInstance();
		
		
	}

}
