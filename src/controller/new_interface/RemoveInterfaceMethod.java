package controller.new_interface;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_interface.NewInterfaceWindow;

public class RemoveInterfaceMethod extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7747224588314241013L;
	
	public RemoveInterfaceMethod() {
		super("Remove", null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		NewInterfaceWindow.getInstance().removeTableRow(NewInterfaceWindow.getInstance().getTable());
	}

}
