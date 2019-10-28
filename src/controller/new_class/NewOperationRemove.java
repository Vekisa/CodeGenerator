package controller.new_class;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_class.NewClassWindow;

public class NewOperationRemove extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2965197383917531467L;

	public NewOperationRemove() {
		super("Remove", null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		NewClassWindow.getInstance().removeTableRow(NewClassWindow.getInstance().getTable2(), NewClassWindow.getInstance().getModelTable2());
		
	}

}
