package windows.main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.tree.TreeListener;
import model.Item;

public class NavigationBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2871017317886321257L;
	
	private JTree tree;
	private JScrollPane treeView;
	
	public NavigationBar() {
		this.setLayout(new BorderLayout());
	}
	
	private DefaultMutableTreeNode createNodes() {
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(MainWindow.getInstance().getModel().getProject());
	    
	    for(Item item : MainWindow.getInstance().getModel().getProject().getChildren()) {
	    	printNode(item,top);
	    }
	    
	    return top;
	}
	
	public void refresh() {
		tree = new JTree(createNodes());
		tree.addMouseListener(new TreeListener());
		treeView = new JScrollPane(tree);
		tree.setCellRenderer(new NavigationRenderer());
		this.removeAll();
		this.add(treeView);
		this.revalidate();
		this.repaint();
	}
	
	private void printNode(Item item, DefaultMutableTreeNode parent) {
		DefaultMutableTreeNode newItem = new DefaultMutableTreeNode(item);
		if(!item.getChildren().isEmpty()) {
			for(Item itemPom : item.getChildren()) {
				printNode(itemPom,newItem);
			}
		}
		parent.add(newItem);
	}
	
	public DefaultMutableTreeNode getSelectedNode() {
		return (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
	}

}
