package controller.new_interface;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_interface.NewMethodWindow;

public class RemoveParameter extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3235638355933139547L;

	public RemoveParameter() {
		super("Remove", null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		NewMethodWindow.getInstance().removeTableRow(NewMethodWindow.getInstance().getTable());
		
	}

}
