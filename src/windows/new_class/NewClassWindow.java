package windows.new_class;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
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
import javax.swing.table.DefaultTableModel;

import controller.NewAttributeOW;
import controller.NewClassExtendsOW;
import controller.NewOperationOW;

public class NewClassWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1978685336525540440L;
	private static NewClassWindow instance;
	private DefaultListModel<String> model;
	private DefaultTableModel modelTable;
	private JList<String> classList;
	private JTable table;
	private String[] columnNames = {"Name",
            "Type",
            "Static",
            "Virtual",
            "Getter",
            "Setter"};
	
	public String[] getColumnNames() {
		return columnNames;
	}

	@SuppressWarnings("deprecation")
	public static NewClassWindow getInstance () {
	    if (NewClassWindow.instance == null) {
	    	NewClassWindow.instance = new NewClassWindow();
	    }
	    NewClassWindow.instance.show();
	    return NewClassWindow.instance;
	}
	
	public NewClassWindow() {
		Box box = Box.createVerticalBox();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(770, 550));
		this.pack();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Class");
		
		//name panel
		JPanel namePane = new JPanel();
		namePane.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel classNameLabel = new JLabel("Name: ");
		JTextField classNameField = new JTextField();
		Dimension fieldDimension = new Dimension(200,25);
		classNameField.setPreferredSize(fieldDimension);
		
		String[] list = {"extends", "implement"};
		JComboBox<String> combo = new JComboBox<String>(list);
		
		model = new DefaultListModel<>();
		classList = new JList<String>(model);
		classList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		classList.setLayoutOrientation(JList.VERTICAL);
		classList.setVisibleRowCount(-1);
		
		JScrollPane listScroller = new JScrollPane(classList);
		listScroller.setPreferredSize(new Dimension(150, 80));
		
		JButton addNewClass = new JButton(new NewClassExtendsOW());
		
		namePane.add(classNameLabel);
		namePane.add(classNameField);
		namePane.add(combo);
		namePane.add(listScroller);
		namePane.add(addNewClass);
		
		//parameters panel
		JPanel parametersPanel = new JPanel();
		parametersPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		parametersPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JCheckBox defaultConstructor = new JCheckBox("Default Constructor");
		JCheckBox getters = new JCheckBox("Getters");
		JCheckBox setters = new JCheckBox("Setters");
		parametersPanel.add(defaultConstructor);
		parametersPanel.add(getters);
		parametersPanel.add(setters);
		
		//attributes panel
		JPanel attributesPanel = new JPanel();
		attributesPanel.setLayout(new BorderLayout());
		
		/*Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false), "A"},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true), "A"},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false), "A"},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true), "A"},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false), "A"}
			};*/
		
		Object[][] data = {{"","","","","",""}};
		
		table = new JTable(new DefaultTableModel(data, columnNames));
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(55,55,55));
		table.setFillsViewportHeight(false);
		attributesPanel.add(scrollPane, BorderLayout.SOUTH);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton addNewAttribute = new JButton(new NewAttributeOW());
		buttonPanel.add(addNewAttribute);
		attributesPanel.add(buttonPanel,BorderLayout.NORTH);
		
		//operations panel
		JPanel operationsPanel = new JPanel();
		operationsPanel.setLayout(new BorderLayout());
		String[] columnNames2 = {"Name",
		                "Type",
		                "Static",
		                "Virtual",
		                "Attributes"};
		/*Object[][] data2 = {
					    {"Kathy", "Smith",
					     "Snowboarding", new Integer(5), new Boolean(false)},
					    {"John", "Doe",
					     "Rowing", new Integer(3), new Boolean(true)},
					    {"Sue", "Black",
					     "Knitting", new Integer(2), new Boolean(false)},
					    {"Jane", "White",
					     "Speed reading", new Integer(20), new Boolean(true)},
					    {"Joe", "Brown",
					     "Pool", new Integer(10), new Boolean(false)}
		};*/
		Object[][] data2 = {{"","","","",""}};
				
		JTable table2 = new JTable(data2, columnNames2);
		table2.setPreferredScrollableViewportSize(table2.getPreferredSize());
		JScrollPane scrollPane2 = new JScrollPane(table2);
		table2.setFillsViewportHeight(false);
		operationsPanel.add(scrollPane2, BorderLayout.SOUTH);
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton addNewOperation = new JButton(new NewOperationOW());
		buttonPanel2.add(addNewOperation);
		operationsPanel.add(buttonPanel2,BorderLayout.NORTH);
		
		//buttons panel
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton cancel = new JButton("Cancel");
		JButton ok = new JButton("Ok");
		buttonsPanel.add(ok);
		buttonsPanel.add(cancel);
		
		box.add(namePane);
		box.add(parametersPanel);
		box.add(attributesPanel);
		box.add(operationsPanel);
		box.add(buttonsPanel);
		this.add(box);
		this.setVisible(true);
	}
	
	public void addItem(String s) {
		model.addElement(s);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	public void addingRowTable(Object[][] data) {
		this.modelTable = (DefaultTableModel) this.table.getModel();
		modelTable.addRow(data);
	}
}




















