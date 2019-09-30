package windows.main;

import java.awt.Component;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class NavigationRenderer extends DefaultTreeCellRenderer {

	private static final String SPAN_FORMAT = "<span style='color:%s;'>%s</span>";
	private ImageIcon packageIcon;
	
	public NavigationRenderer() {
		Path currentRelativePath = Paths.get("");
		packageIcon = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "/resources/package.png");
	}
	
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
	                                                boolean leaf, int row, boolean hasFocus) {
	      super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
	      
	      DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
	      Object userObject = node.getUserObject();
	      
	      if (userObject instanceof model.Project) {
	          model.Project project = (model.Project) userObject;
	          String text = String.format(SPAN_FORMAT, "blue", project.getName());
	          //text += " [" + String.format(SPAN_FORMAT, "orange", pp.getRole()) + "]";
	          this.setText("<html>" + text + "</html>");
	          //this.setIcon(employeeIcon);
	      } else if (userObject instanceof model.Package) {
	    	  model.Package packageNode = (model.Package) userObject;
	          String text = String.format(SPAN_FORMAT, "blue", packageNode.getName());
	          //text += " [" + String.format(SPAN_FORMAT, "orange", pp.getRole()) + "]";
	          this.setText("<html>" + text + "</html>");
	          this.setIcon(packageIcon);
	      } else {
	          String text = String.format(SPAN_FORMAT, "red", userObject);
	          this.setText("<html>" + text + "</html>");
	      }
	      
	      return this;
	}
}
