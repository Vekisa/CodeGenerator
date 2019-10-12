package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import windows.Configuration;
import windows.new_enum.NewEnumWindow;

public class NewEnumOW extends AbstractAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public NewEnumOW() {
		super("Enum", Configuration.enumIcon);
		putValue(SHORT_DESCRIPTION, "Create a new enum");	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		NewEnumWindow.getInstance();
	}

}
