package controller.new_enum;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.Configuration;
import windows.new_enum.NewEnumWindow;
import windows.new_enum.NewItemWindow;

public class NewItem extends AbstractAction {

	public NewItem() {
		super("Add", null);	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		NewEnumWindow.getInstance().addItem(NewItemWindow.getInstance().getItem());	
		NewItemWindow.getInstance().setItem("");
	}

	
	
}
