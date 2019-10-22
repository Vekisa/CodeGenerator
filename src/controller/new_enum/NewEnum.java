package controller.new_enum;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Item;
import windows.InternalConfiguration;
import windows.main.MainWindow;
import windows.message.MessageDialog;
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
		//System.out.println("OVO PREUZIMAM u enumu: " + newEnum); cisto mali test u consoli
		
		DefaultMutableTreeNode selectedNode = MainWindow.getInstance().getNavigationBar().getSelectedNode();
		if(selectedNode != null) {
			Item selectedItem = (Item) selectedNode.getUserObject();
			Item itemFromModel = MainWindow.getInstance().getModel().getItemWithId(selectedItem.getId());
			if(itemFromModel != null) {
				selectedItem.addChild(newEnum);
			}else
				MessageDialog.showMessage("Internal problem!");
		} else
			MessageDialog.showMessage("Item nije selektovan!");
		
		NewEnumWindow.getInstance().dispose();
	}
	
}
