package windows.new_class;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.NewParameterOW;
import controller.new_class.NewAttribute;

public class NewOperationWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6886496950805053857L;
	private static NewOperationWindow instance;
	private JTextField methodnName;
	private JTextField parameterName;
	private JComboBox<String> combo;
	private JComboBox<String> comboParameters;
	private JCheckBox staticBox;
	private JCheckBox virtual;
	private DefaultTableModel modelTable;
	private JTable table;
	
	@SuppressWarnings("deprecation")
	public static NewOperationWindow getInstance () {
	    if (NewOperationWindow.instance == null) {
	    	NewOperationWindow.instance = new NewOperationWindow();
	    }
	    NewOperationWindow.instance.show();
	    return NewOperationWindow.instance;
	}

	public NewOperationWindow() {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(700, 200));
		this.pack();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Operation");
		this.setLayout(new BorderLayout());
		
		//detail of operations panel
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.LEFT));
		methodnName = new JTextField();
		methodnName.setToolTipText("Name of the method");
		Dimension fieldDimension = new Dimension(100,25);
		methodnName.setPreferredSize(fieldDimension);
		String[] list = {"void", "int", "String", "boolean", "double", "char", "float", "Object"};
		combo = new JComboBox<String>(list);
		staticBox = new JCheckBox("Static");
		virtual = new JCheckBox("Virtual");
		
		//parameters table
		Object[] data = {"Type", "Name"};
		modelTable = new DefaultTableModel(data, 1);
		table = new JTable(modelTable);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(55,55,55));
		table.setFillsViewportHeight(false);
		JButton addParameter = new JButton(new NewParameterOW());
		
		//create cancel panel
		JPanel ccBtnPanel = new JPanel();
		JButton createButton = new JButton("add new operation");
		JButton cancelButton = new JButton("Cancel");
		ccBtnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ccBtnPanel.add(createButton);
		ccBtnPanel.add(cancelButton);
		
		top.add(methodnName);
		top.add(combo);
		top.add(staticBox);
		top.add(virtual);
		top.add(scrollPane);
		top.add(addParameter);
		this.setVisible(true);	
		this.add(top, BorderLayout.NORTH);
		this.add(ccBtnPanel, BorderLayout.SOUTH);
	}
}
