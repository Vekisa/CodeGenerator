package windows.new_enum;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.new_enum.NewItem;

public class NewItemWindow extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4957700235718808638L;
	public static NewItemWindow instance;
	private JTextField item;
	
	@SuppressWarnings("deprecation")
	public static NewItemWindow getInstance() {
		if(NewItemWindow.instance == null) {
			NewItemWindow.instance = new NewItemWindow();
		}
		NewItemWindow.instance.show();		
		return NewItemWindow.instance;
	}
	public NewItemWindow (){
		Box box = Box.createVerticalBox();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(250, 200));
		this.pack();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Enum");
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//textfield
		JLabel addlabel = new JLabel("New Item:");
		item = new JTextField();
		JButton addInList = new JButton(new NewItem());
		Dimension fieldDimension = new Dimension(200,25);
		item.setPreferredSize(fieldDimension);
		
		this.add(addlabel);
		this.add(item);
		this.add(addInList);
		this.getRootPane().setDefaultButton(addInList);
		
		
	}
	public String getItem() {
		return item.getText();
	}
	public void setItem(String item) {
		this.item.setText(item);
	}
}

