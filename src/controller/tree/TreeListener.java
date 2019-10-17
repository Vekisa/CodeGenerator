package controller.tree;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import model.Item;
import windows.TreeDropDownMenu;

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
        TreeDropDownMenu dropdown = new TreeDropDownMenu(item, tree, x, y);
        
    }
    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger()) myPopupEvent(e);
    }
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) myPopupEvent(e);
    }
}
