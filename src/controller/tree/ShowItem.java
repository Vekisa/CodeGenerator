package controller.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Item;
import parsers.MainParser;
import windows.main.MainWindow;

public class ShowItem implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Item item = (Item)MainWindow.getInstance().getNavigationBar().getSelectedNode().getUserObject();
		MainWindow.getInstance().getWorkspace().showItem(MainParser.parse(item));
	}

}
