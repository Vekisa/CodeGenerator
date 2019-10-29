package controller.ow;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_class.NewAttributeWindow;
import windows.new_class.NewClassWindow;

public class NewAttributeEditOW extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5705794964399526744L;
	
	public NewAttributeEditOW() {
		super("Edit", null);
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = NewClassWindow.getInstance().getTable().getSelectedRow();
		
		NewAttributeWindow.getInstance().setAcsModifier(NewClassWindow.getInstance().getTable().getValueAt(row, 
				NewClassWindow.getInstance().getTable().getColumn("AcsModifier").getModelIndex()).toString());
		NewAttributeWindow.getInstance().setStaticBox(NewClassWindow.getInstance().getTable().getValueAt(row, 
				NewClassWindow.getInstance().getTable().getColumn("Static").getModelIndex()).toString());
		NewAttributeWindow.getInstance().setCombo(NewClassWindow.getInstance().getTable().getValueAt(row, 
				NewClassWindow.getInstance().getTable().getColumn("Type").getModelIndex()).toString());
		NewAttributeWindow.getInstance().setAttributeName(NewClassWindow.getInstance().getTable().getValueAt(row, 
				NewClassWindow.getInstance().getTable().getColumn("Name").getModelIndex()).toString());
		NewAttributeWindow.getInstance().setConst(NewClassWindow.getInstance().getTable().getValueAt(row, 
				NewClassWindow.getInstance().getTable().getColumn("Const").getModelIndex()).toString());
		NewAttributeWindow.getInstance().setGetters(NewClassWindow.getInstance().getTable().getValueAt(row, 
				NewClassWindow.getInstance().getTable().getColumn("Getters").getModelIndex()).toString());
		NewAttributeWindow.getInstance().setSetters(NewClassWindow.getInstance().getTable().getValueAt(row, 
				NewClassWindow.getInstance().getTable().getColumn("Setters").getModelIndex()).toString());
		
		NewAttributeWindow.getInstance().getCreateButton().hide();
		NewAttributeWindow.getInstance().getSaveButton().show();
		NewAttributeWindow.getInstance();
	}

}
