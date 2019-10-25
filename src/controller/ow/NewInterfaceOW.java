package controller.ow;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.InternalConfiguration;

public class NewInterfaceOW extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5255571097195266806L;
	
	public NewInterfaceOW() {
		super("Interface", InternalConfiguration.interfaceIcon);
		putValue(SHORT_DESCRIPTION, "Add new Interface");	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
