package controller.new_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.tree.DefaultMutableTreeNode;

import model.Item;
import windows.main.MainWindow;
import windows.message.MessageDialog;
import windows.new_package.NewPackageWindow;

public class NewPackage implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String name = NewPackageWindow.getInstance().getValue();
		System.out.println("OVO PREUZIMAM: " + name);
		DefaultMutableTreeNode selectedNode = MainWindow.getInstance().getNavigationBar().getSelectedNode();
		if(selectedNode != null) {
			Item selectedItem = (Item) selectedNode.getUserObject();
			model.Package newPackage = new model.Package(name);
			Item itemFromModel = MainWindow.getInstance().getModel().getItemWithId(selectedItem.getId());
			if(itemFromModel != null) {
				selectedItem.addChild(newPackage);
			}else
				MessageDialog.showMessage("Internal problem!");
		} else
			MessageDialog.showMessage("Item nije selektovan!");
		
		NewPackageWindow.getInstance().dispose();
	}

}
