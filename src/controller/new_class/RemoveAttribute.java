package controller.new_class;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_class.NewClassWindow;

public class RemoveAttribute extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8545398703137160750L;

	public RemoveAttribute() {
		// TODO Auto-generated constructor stub
		super("Remove", null);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		NewClassWindow.getInstance().removeTableRow(NewClassWindow.getInstance().getTable(), NewClassWindow.getInstance().getModelTable());
		
	}

}
