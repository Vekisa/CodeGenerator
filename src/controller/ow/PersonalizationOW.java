package controller.ow;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import windows.personalization.PersonalizationWindow;

public class PersonalizationOW extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6086750368498265145L;
	
	public PersonalizationOW() {
		super("Personalization", null);
		putValue(SHORT_DESCRIPTION, "Personalize application");	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PersonalizationWindow.getInstance();
	}

}
