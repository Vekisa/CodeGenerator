package controller.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Item;
import windows.main.MainWindow;

public class DeleteItem implements ActionListener {

	private Item item;
	
	public DeleteItem(Item item) {
		this.item = item;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainWindow.getInstance().getModel().removeItemWithId(item.getId());
	}

}
