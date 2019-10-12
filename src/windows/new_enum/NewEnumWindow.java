package windows.new_enum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;

import controller.NewAttributeOW;
import controller.NewOperationOW;


public class NewEnumWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static NewEnumWindow instance;
	
	@SuppressWarnings("deprecation")
	public static NewEnumWindow getInstance() {
		if(NewEnumWindow.instance == null) {
			NewEnumWindow.instance = new NewEnumWindow();
		}
		NewEnumWindow.instance.show();		
		return NewEnumWindow.instance;
	}
	
	
	public NewEnumWindow() {
		Box box = Box.createVerticalBox();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(770, 550));
		this.pack();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Enum");
		
		//name panel
		this.setVisible(true);
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
