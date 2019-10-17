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

        JPopupMenu popup = new JPopupMenu();
        popup.add(new JMenuItem("PUSI KURAC DEJO"));
        //popup.add(new JMenuItem("Remove"));
        popup.show(tree, x, y);
    }
    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger()) myPopupEvent(e);
    }
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) myPopupEvent(e);
    }
}
