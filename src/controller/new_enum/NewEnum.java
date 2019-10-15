package controller.new_enum;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.Configuration;
import windows.new_enum.NewEnumWindow;

public class NewEnum extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7386134017047387000L;

	public NewEnum() {
		super("Create", null);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		model.Enum newEnum = new model.Enum();
		newEnum.setEnumName(NewEnumWindow.getInstance().getNameTF().getText());
		for(int i = 0; i < NewEnumWindow.getInstance().getModel().getSize(); i++) {
			newEnum.getItems().add(NewEnumWindow.getInstance().getModel().get(i));
		}
	}
	
}
