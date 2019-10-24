package controller.ow;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_class.NewAttributeWindow;

public class NewAttributeOW extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6865466255120140582L;
	
	public NewAttributeOW() {
		super("Add attribute", null);
	    putValue(SHORT_DESCRIPTION, "Add new attribute");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		NewAttributeWindow.getInstance();
	}

}
