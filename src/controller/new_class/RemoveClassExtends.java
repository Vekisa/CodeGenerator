package controller.new_class;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JList;

import windows.new_class.NewClassWindow;

public class RemoveClassExtends extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2897755266479051293L;
	
	public RemoveClassExtends() {
		super("Remove", null);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int selectedIndex = NewClassWindow.getInstance().getClassListJList().getSelectedIndex();
		if (NewClassWindow.getInstance().getCombo().getSelectedIndex() == 0)
			NewClassWindow.getInstance().getModelExtends().remove(selectedIndex);
		else
			NewClassWindow.getInstance().getModelImplements().remove(selectedIndex);
		
	}

}
