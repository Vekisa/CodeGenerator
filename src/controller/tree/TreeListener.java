package controller.tree;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import model.Item;

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
        JPopupMenu popup = new JPopupMenu();
        JMenuItem remove = new JMenuItem("Remove");
        remove.addActionListener(new DeleteItem(item));
        popup.add(new JMenuItem("Save"));
        popup.add(new JMenuItem("Edit"));
        popup.add(remove);
        popup.show(tree, x, y);
    }
    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger()) myPopupEvent(e);
    }
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) myPopupEvent(e);
    }
}
