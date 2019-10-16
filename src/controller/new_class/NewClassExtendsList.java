package controller.new_class;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_class.NewClassExtendsWindow;
import windows.new_class.NewClassWindow;

public class NewClassExtendsList extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3785528505923620665L;

	public NewClassExtendsList() {
		super("Add", null);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		NewClassWindow.getInstance().addItem(NewClassExtendsWindow.getInstance().getItem());
		NewClassExtendsWindow.getInstance().setItem("");
	}

}
