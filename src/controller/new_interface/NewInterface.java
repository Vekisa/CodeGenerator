package controller.new_interface;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Item;
import windows.main.MainWindow;
import windows.message.MessageDialog;
import windows.new_interface.NewInterfaceWindow;

public class NewInterface extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1277723895950556281L;
	
	public NewInterface() {
		super("Create", null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.Interface newInterface = new model.Interface();
		newInterface.setName(NewInterfaceWindow.getInstance().getInterfaceName().getText());
		newInterface.setOperations(NewInterfaceWindow.getInstance().getTableOperations());
		
		DefaultMutableTreeNode selectedNode = MainWindow.getInstance().getNavigationBar().getSelectedNode();
		if(selectedNode != null) {
			Item selectedItem = (Item) selectedNode.getUserObject();
			Item itemFromModel = MainWindow.getInstance().getModel().getItemWithId(selectedItem.getId());
			if(itemFromModel != null) {
				selectedItem.addChild(newInterface);
			} else
				MessageDialog.showMessage("internal Problem!");
		} else {
			MainWindow.getInstance().getModel().getProject().addChild(newInterface);
		}
		
		NewInterfaceWindow.getInstance().dispose();
	}
}

