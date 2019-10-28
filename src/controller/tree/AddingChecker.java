package controller.tree;

import model.Item;
import windows.main.MainWindow;
import windows.message.MessageDialog;

public class AddingChecker {

	public static boolean checkSelectedItem() {
		if(!checkProjectExists())
			return false;
		if(MainWindow.getInstance().getNavigationBar().getSelectedNode() == null)
			return true;
		Item item = (Item)MainWindow.getInstance().getNavigationBar().getSelectedNode().getUserObject();
		if(item instanceof model.Class || item instanceof model.Enum || item instanceof model.Interface) {
			MessageDialog.showMessage("Can not add anything on this item!");
			return false;
		}
		
		return true;
			
	}
	
	public static boolean checkProjectExists() {
		if(MainWindow.getInstance().getModel().getProject() != null)
			return true;
		
		MessageDialog.showMessage("Project does not exists!");
		return false;
	}
}
