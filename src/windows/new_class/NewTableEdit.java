package windows.new_class;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class NewTableEdit extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5321054551195241897L;

	public NewTableEdit() {
		super("Edit", null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] data = {NewShowTableWindow.getInstance().tableToArray()};
		NewClassWindow.getInstance().getModelTable2().setValueAt(data, NewClassWindow.getInstance().getRow(), NewClassWindow.getInstance().getCol());
		
	}

}
