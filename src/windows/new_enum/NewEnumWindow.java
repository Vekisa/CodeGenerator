package windows.new_enum;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import controller.new_enum.NewEnum;
import controller.new_enum.RemoveItem;
import controller.ow.NewItemOW;

public class NewEnumWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static NewEnumWindow instance;
	private DefaultListModel<String> model;
	private JList<String> enumList;
	private JTextField nameTF;

	@SuppressWarnings("deprecation")
	public static NewEnumWindow getInstance() {
		if(NewEnumWindow.instance == null) {
			NewEnumWindow.instance = new NewEnumWindow();
		}
		NewEnumWindow.instance.show();		
		return NewEnumWindow.instance;
	}
	

	public NewEnumWindow() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(770, 500));
		this.pack();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Enum");
		this.setLayout(new BorderLayout());
		
		//name panel
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel name = new JLabel("Name : ");
		nameTF = new JTextField();
		Dimension fieldDimension = new Dimension(200,25);
		nameTF.setPreferredSize(fieldDimension);
		
		model = new DefaultListModel<>();
		enumList = new JList<String>(model);
		enumList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		enumList.setLayoutOrientation(JList.VERTICAL);
		enumList.setVisibleRowCount(-1);
		
		JScrollPane listScroller = new JScrollPane(enumList);
		listScroller.setPreferredSize(new Dimension(150, 80));
		
		//name button panel
		JPanel buttonPanel = new JPanel();
		JButton addBtnEnum = new JButton(new NewItemOW());
		JButton removeBtnEnum = new JButton(new RemoveItem());
		
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(removeBtnEnum, BorderLayout.SOUTH);
		buttonPanel.add(addBtnEnum, BorderLayout.NORTH);
		
		//create_cancel panel
		JPanel ccBtnPanel = new JPanel();
		JButton createButton = new JButton(new NewEnum());
		JButton cancelButton = new JButton("Cancel");
		ccBtnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ccBtnPanel.add(createButton);
		ccBtnPanel.add(cancelButton);
		
		top.add(name);
		top.add(nameTF);
		top.add(listScroller);
		top.setVisible(true);
		top.add(buttonPanel);
		this.add(top, BorderLayout.NORTH);
		this.add(ccBtnPanel, BorderLayout.SOUTH);
				
	}
	
	public void addItem(String s) {
		model.addElement(s);
	}
	
	public JList<String> getEnumList() {
		return enumList;
	}


	public void setEnumList(JList<String> enumList) {
		this.enumList = enumList;
	}


	public DefaultListModel<String> getModel() {
		return model;
	}


	public JTextField getNameTF() {
		return nameTF;
	}
	
	
	
	
	
	
	
}
