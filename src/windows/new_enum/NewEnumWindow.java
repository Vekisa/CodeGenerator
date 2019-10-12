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
		this.setPreferredSize(new Dimension(770, 500));
		this.pack();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Enum");
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//name panel
		JLabel name = new JLabel("Name : ");
		JTextField nameTF = new JTextField();
		Dimension fieldDimension = new Dimension(200,25);
		nameTF.setPreferredSize(fieldDimension);
		//JList<String> enumList = new JList<String>();
		Object[] obj = {"a", "b", "c","d","e","f"};
		JList<Object> enumList = new JList<Object>(obj);
		enumList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		enumList.setLayoutOrientation(JList.VERTICAL);
		enumList.setVisibleRowCount(-1);
		
		JScrollPane listScroller = new JScrollPane(enumList);
		listScroller.setPreferredSize(new Dimension(150, 80));
		
		JButton addBtnEnum = new JButton("Add");
		JButton removeBtnEnum = new JButton("Remove");
		
		
		this.add(name);
		this.add(nameTF);
		this.add(listScroller);
		this.setVisible(true);
			
				
	}
	
	
	
	
	
	
	
	
	
}
