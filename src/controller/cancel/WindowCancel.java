package controller.cancel;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import windows.new_class.NewClassWindow;

public class WindowCancel extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8134432140088527419L;
	
	public WindowCancel() {
		// TODO Auto-generated constructor stub
		super("Cancel", null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.exit(0);
		NewClassWindow.getInstance().dispatchEvent(new WindowEvent(NewClassWindow.getInstance(), WindowEvent.WINDOW_CLOSING));
		
	}

}
