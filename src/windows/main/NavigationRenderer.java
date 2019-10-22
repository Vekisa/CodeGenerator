package windows.main;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import windows.InternalConfiguration;

public class NavigationRenderer extends DefaultTreeCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5209345535944629046L;
	private static final String SPAN_FORMAT = "<span style='color:%s;'>%s</span>";
	
	public NavigationRenderer() {
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
	          this.setIcon(InternalConfiguration.projectIcon);
	      } else if (userObject instanceof model.Package) {
	    	  model.Package packageNode = (model.Package) userObject;
	          String text = String.format(SPAN_FORMAT, "blue", packageNode.getName());
	          //text += " [" + String.format(SPAN_FORMAT, "orange", pp.getRole()) + "]";
	          this.setText("<html>" + text + "</html>");
	          this.setIcon(InternalConfiguration.packageIcon);
	      } else if(userObject instanceof model.Enum) {
	    	  model.Enum packageNode = (model.Enum) userObject;
	    	  String text = String.format(SPAN_FORMAT, "blue", packageNode.getEnumName());
	    	  this.setText("<html>" + text + "</html>");	
	    	  this.setIcon(InternalConfiguration.enumIcon);
	      } else if(userObject instanceof model.Class) {
	    	  model.Class packageNode = (model.Class) userObject;
	    	  String text = String.format(SPAN_FORMAT, "blue", packageNode.getClassName());
	    	  this.setText("<html>" + text + "</html>");
	    	  this.setIcon(InternalConfiguration.classIcon);
	      }
	      return this;
	}
}
