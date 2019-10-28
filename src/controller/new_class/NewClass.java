package controller.new_class;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Item;
import windows.main.MainWindow;
import windows.message.MessageDialog;
import windows.new_class.NewClassWindow;

public class NewClass extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3187339255186401422L;

	public NewClass() {
		super("Create Class" , null);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		model.Class newClass = new model.Class();
		newClass.setClassName(NewClassWindow.getInstance().getClassNameField().getText());
		newClass.setExtendsClasses(NewClassWindow.getInstance().getClassList());
		newClass.setImplementsInterfaces(NewClassWindow.getInstance().getInterfaceList());
		newClass.setAttributes(NewClassWindow.getInstance().getTableAttributes());
		newClass.setOperations(NewClassWindow.getInstance().getTableOperations());
		newClass.setDefaultConstructor(NewClassWindow.getInstance().getDefaultConstructor().isSelected());
		newClass.setSetters(NewClassWindow.getInstance().getSetters().isSelected());
		newClass.setGetters(NewClassWindow.getInstance().getGetters().isSelected());
		
		DefaultMutableTreeNode selectedNode = MainWindow.getInstance().getNavigationBar().getSelectedNode();
		if(selectedNode != null) {
			Item selectedItem = (Item) selectedNode.getUserObject();
			Item itemFromModel = MainWindow.getInstance().getModel().getItemWithId(selectedItem.getId());
			if(itemFromModel != null) {
				selectedItem.addChild(newClass);
			} else
				MessageDialog.showMessage("internal Problem!");
		} else {
			MainWindow.getInstance().getModel().getProject().addChild(newClass);
		}
		
		NewClassWindow.getInstance().dispose();
		
	}

}
