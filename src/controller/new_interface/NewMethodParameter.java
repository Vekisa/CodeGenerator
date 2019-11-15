package controller.new_interface;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.new_interface.NewMethodParameterWindow;
import windows.new_interface.NewMethodWindow;

public class NewMethodParameter extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7382217043914831683L;
	
	public NewMethodParameter() {
		super("Add", null);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object[] data = {
				NewMethodParameterWindow.getInstance().getCombo().getSelectedItem().toString(),
				NewMethodParameterWindow.getInstance().getParameterName().getText(),
				NewMethodParameterWindow.getInstance().getIsStatic().isSelected(),
				NewMethodParameterWindow.getInstance().getIsConst().isSelected(),
				NewMethodParameterWindow.getInstance().getGetters().isSelected(),
				NewMethodParameterWindow.getInstance().getSetters().isSelected()
		};
		NewMethodWindow.getInstance().addingRowTable(data);
		NewMethodParameterWindow.getInstance().setParameterName("");
		NewMethodParameterWindow.getInstance().dispose();
	}

}
