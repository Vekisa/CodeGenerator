package controller.ow;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_enum.NewItemWindow;

public class NewItemOW extends AbstractAction {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 331111141893965718L;

	public NewItemOW() {
		super("Add", null);
		putValue(SHORT_DESCRIPTION, "Add item");	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		NewItemWindow.getInstance();
		
	}

	
	
}
