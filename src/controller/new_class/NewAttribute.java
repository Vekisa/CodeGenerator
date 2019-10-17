package controller.new_class;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.table.DefaultTableModel;

import windows.new_class.NewAttributeWindow;
import windows.new_class.NewClassWindow;

public class NewAttribute extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3542582480429375733L;

	public NewAttribute() {
		super("Create new attribute", null);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object[] data = 
			{NewAttributeWindow.getInstance().getAttributeName().getText()
			,NewAttributeWindow.getInstance().getCombo().getSelectedItem().toString()
			,NewAttributeWindow.getInstance().getStaticBox().isSelected()
			,NewAttributeWindow.getInstance().getVirtual().isSelected()
			,NewAttributeWindow.getInstance().getGetters().isSelected()
			,NewAttributeWindow.getInstance().getSetters().isSelected()};
		
		NewClassWindow.getInstance().addingRowTable(data);
	}
	
	
}
