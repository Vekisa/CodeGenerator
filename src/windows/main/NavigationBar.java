package windows.main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import controller.tree.TreeListener;
import model.Item;

public class NavigationBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2871017317886321257L;
	
	private JTree tree;
	private JScrollPane treeView;
	private DefaultTreeModel treeModel;
	
	public NavigationBar() {
		this.setLayout(new BorderLayout());
	}
	
	private DefaultMutableTreeNode createNodes() {
		
		if(MainWindow.getInstance().getModel().getProject() == null) {
			return null;
		}
			
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(MainWindow.getInstance().getModel().getProject());
	    
	    for(Item item : MainWindow.getInstance().getModel().getProject().getChildren()) {
	    	printNode(item,top);
	    }
	    
	    return top;
	}
	
	public void refresh() {
			treeModel = new DefaultTreeModel(createNodes());
			tree = new JTree(treeModel);
			tree.setToggleClickCount(0);
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
	
	public void insertInSelectedNode(Item item) {
		DefaultMutableTreeNode parent = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		if(parent == null){
			DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
			treeModel.insertNodeInto(new DefaultMutableTreeNode(item),root, root.getChildCount());
			tree.expandPath(new TreePath(root.getPath()));
		}else {
			treeModel.insertNodeInto(new DefaultMutableTreeNode(item),parent, parent.getChildCount());
			tree.expandPath(new TreePath(parent.getPath()));
		}
	}
	
	public void removeSelecetedNode() {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		treeModel.removeNodeFromParent(node);
	}

}
