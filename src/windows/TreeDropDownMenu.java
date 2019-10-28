 package windows;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;

import controller.tree.DeleteItem;
import controller.tree.ShowItem;
import model.Item;

public class TreeDropDownMenu extends JPopupMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4263473830095787137L;

	public TreeDropDownMenu(Item item, JTree tree, int x, int y) {
		JMenuItem remove = new JMenuItem("Remove");
        remove.addActionListener(new DeleteItem(item));
        JMenuItem show = new JMenuItem("Show");
        show.addActionListener(new ShowItem());
        this.add(show);
        this.add(new JMenuItem("Save"));
        this.add(new JMenuItem("Edit"));
        this.add(remove);
        this.show(tree, x, y);
	}
}
