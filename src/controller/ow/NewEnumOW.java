package controller.ow;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import controller.tree.AddingChecker;
import windows.InternalConfiguration;
import windows.new_enum.NewEnumWindow;

public class NewEnumOW extends AbstractAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public NewEnumOW() {
		super("Enum", InternalConfiguration.enumIcon);
		putValue(SHORT_DESCRIPTION, "Create a new enum");	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(!AddingChecker.checkSelectedItem())
			return;
		NewEnumWindow.getInstance();
	}

}
