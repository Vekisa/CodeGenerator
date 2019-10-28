package controller.tree;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import model.Item;
import parsers.MainParser;
import windows.TreeDropDownMenu;
import windows.main.MainWindow;

public class TreeListener extends MouseAdapter {

	private void myPopupEvent(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        JTree tree = (JTree)e.getSource();
        TreePath path = tree.getPathForLocation(x, y);
        if (path == null)
            return; 

        tree.setSelectionPath(path);

        DefaultMutableTreeNode node = (DefaultMutableTreeNode)path.getLastPathComponent();
        Item item = (Item)node.getUserObject();
        @SuppressWarnings("unused")
		TreeDropDownMenu dropdown = new TreeDropDownMenu(item, tree, x, y);
        
    }
	public void mouseClicked(MouseEvent e){
        if(e.getClickCount()==2){
        	if(MainWindow.getInstance().getNavigationBar().getSelectedNode() == null)
        		return;
        	Item item = (Item)MainWindow.getInstance().getNavigationBar().getSelectedNode().getUserObject();
    		MainWindow.getInstance().getWorkspace().showItem(MainParser.parse(item));
        }
    }
    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger()) myPopupEvent(e);
    }
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) myPopupEvent(e);
    }
}
