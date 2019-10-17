package windows;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;

import controller.tree.DeleteItem;
import model.Item;

public class TreeDropDownMenu extends JPopupMenu {

	public TreeDropDownMenu(Item item, JTree tree, int x, int y) {
		JMenuItem remove = new JMenuItem("Remove");
        remove.addActionListener(new DeleteItem(item));
        this.add(new JMenuItem("Save"));
        this.add(new JMenuItem("Edit"));
        this.add(remove);
        this.show(tree, x, y);
	}
}
