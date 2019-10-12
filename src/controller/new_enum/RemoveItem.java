package controller.new_enum;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import windows.message.MessageDialog;
import windows.new_enum.NewEnumWindow;

public class RemoveItem extends AbstractAction{
	
	public RemoveItem() {
		super("Remove", null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = NewEnumWindow.getInstance().getEnumList().getSelectedIndex();
		if(index != -1) {
			NewEnumWindow.getInstance().getModel().remove(index);
		} else {
			MessageDialog.showMessage("Not selected");
		}
	}
}
