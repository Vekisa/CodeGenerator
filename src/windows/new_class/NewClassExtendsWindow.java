package windows.new_class;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.new_class.NewClassExtendsList;
import controller.new_enum.NewItem;

public class NewClassExtendsWindow extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5163431154647072329L;
	public static NewClassExtendsWindow instance;
	private JTextField item;
	
	
	public static NewClassExtendsWindow getInstance() {
		if(NewClassExtendsWindow.instance == null) {
			NewClassExtendsWindow.instance = new NewClassExtendsWindow();
		}
		NewClassExtendsWindow.instance.show();
		return NewClassExtendsWindow.instance;
	}
	
	public NewClassExtendsWindow() {
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
		JButton addInList = new JButton(new NewClassExtendsList());
		Dimension fieldDimension = new Dimension(200,25);
		item.setPreferredSize(fieldDimension);
		
		this.add(addlabel);
		this.add(item);
		this.add(addInList);
	}
	
	public String getItem() {
		return item.getText();
	}
	
	public void setItem(String item) {
		this.item.setText(item);
	}

}
