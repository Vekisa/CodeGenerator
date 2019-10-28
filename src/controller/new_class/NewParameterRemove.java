package controller.new_class;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_class.NewClassWindow;
import windows.new_class.NewOperationWindow;

public class NewParameterRemove extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 112846387544122610L;
	public NewParameterRemove() {
		super("Remove", null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		NewClassWindow.getInstance().removeTableRow(NewOperationWindow.getInstance().getTable(), NewOperationWindow.getInstance().getModelTable());
		
	}

}
