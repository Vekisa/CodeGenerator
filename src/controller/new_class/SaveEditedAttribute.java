package controller.new_class;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_class.NewAttributeWindow;
import windows.new_class.NewClassWindow;

public class SaveEditedAttribute extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3667130693752095777L;
	
	public SaveEditedAttribute() {
		super("Save", null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int selectedIndex = NewClassWindow.getInstance().getTable().getSelectedRow();
		NewClassWindow.getInstance().getTable().setValueAt(NewAttributeWindow.getInstance().getAcsModifier().getSelectedItem().toString(),
				selectedIndex, NewClassWindow.getInstance().getTable().getColumn("AcsModifier").getModelIndex());
		NewClassWindow.getInstance().getTable().setValueAt(NewAttributeWindow.getInstance().getStaticBox().isSelected(), 
				selectedIndex, NewClassWindow.getInstance().getTable().getColumn("Static").getModelIndex());
		NewClassWindow.getInstance().getTable().setValueAt(NewAttributeWindow.getInstance().getCombo().getSelectedItem(), 
				selectedIndex, NewClassWindow.getInstance().getTable().getColumn("Type").getModelIndex());
		NewClassWindow.getInstance().getTable().setValueAt(NewAttributeWindow.getInstance().getAttributeName().getText(), 
				selectedIndex, NewClassWindow.getInstance().getTable().getColumn("Name").getModelIndex());
		NewClassWindow.getInstance().getTable().setValueAt(NewAttributeWindow.getInstance().getConst().isSelected(), 
				selectedIndex, NewClassWindow.getInstance().getTable().getColumn("Const").getModelIndex());
		NewClassWindow.getInstance().getTable().setValueAt(NewAttributeWindow.getInstance().getGetters().isSelected(), 
				selectedIndex, NewClassWindow.getInstance().getTable().getColumn("Getters").getModelIndex());
		NewClassWindow.getInstance().getTable().setValueAt(NewAttributeWindow.getInstance().getSetters().isSelected(), 
				selectedIndex, NewClassWindow.getInstance().getTable().getColumn("Setters").getModelIndex());
		
	}

}
