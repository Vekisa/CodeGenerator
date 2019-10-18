package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import windows.Configuration;
import windows.new_class.NewClassWindow;

public class NewClassOW extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2000358251564509946L;

	public NewClassOW() {
		super("Class", Configuration.classIcon);
	    putValue(SHORT_DESCRIPTION, "Create a new class");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		NewClassWindow.getInstance().setTable(NewClassWindow.getInstance().getModelTable(), NewClassWindow.getInstance().getTable() );
		NewClassWindow.getInstance().setTable(NewClassWindow.getInstance().getModelTable2(), NewClassWindow.getInstance().getTable2() );
		NewClassWindow.getInstance();
	}
}
