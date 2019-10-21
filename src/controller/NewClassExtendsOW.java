package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_class.NewClassExtendsWindow;

public class NewClassExtendsOW extends AbstractAction {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5566454213420357923L;
	
	public NewClassExtendsOW() {
		super("Add", null);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		NewClassExtendsWindow.getInstance();
	}

}
