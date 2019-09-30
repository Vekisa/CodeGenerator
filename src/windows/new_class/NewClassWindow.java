package windows.new_class;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class NewClassWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1978685336525540440L;
	private static NewClassWindow instance;
	
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
		this.setLocation(dim.width/2- this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Class");
		
		//name panel
		JPanel namePane = new JPanel();
		namePane.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel classNameLabel = new JLabel("Name: ");
		JTextField classNameField = new JTextField();
		Dimension fieldDimension = new Dimension(200,25);
		classNameField.setPreferredSize(fieldDimension);
		
		String[] list = {"extends", "implement"};
		JComboBox combo = new JComboBox(list);
		
		JRadioButton fromProjectClass = new JRadioButton("From project",true);
		JRadioButton newClass = new JRadioButton("New");
		ButtonGroup group = new ButtonGroup();
		group.add(fromProjectClass);
		group.add(newClass);
		
		String[] pomList = {"","A","B","C"};
		JComboBox comboFromProject = new JComboBox(pomList);
		
		JTextField newClassField = new JTextField();
		newClassField.setPreferredSize(fieldDimension);
		
		namePane.add(classNameLabel);
		namePane.add(classNameField);
		namePane.add(combo);
		namePane.add(fromProjectClass);
		namePane.add(comboFromProject);
		namePane.add(newClass);
		namePane.add(newClassField);
		
		//attributes panel
		JPanel attributesPanel = new JPanel();
		attributesPanel.setLayout(new BorderLayout());
		String[] columnNames = {"Name",
                "Type",
                "Sport",
                "# of Years",
                "Vegetarian"};
		Object[][] data = {
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
			};
		
		JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(55,55,55));
		table.setFillsViewportHeight(false);
		attributesPanel.add(scrollPane, BorderLayout.SOUTH);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton addNewAttribute = new JButton("Add attribute");
		buttonPanel.add(addNewAttribute);
		attributesPanel.add(buttonPanel,BorderLayout.NORTH);
		
		//operations panel
		JPanel operationsPanel = new JPanel();
		operationsPanel.setLayout(new BorderLayout());
		String[] columnNames2 = {"Name",
		                "Type",
		                "Sport",
		                "# of Years",
		                "Vegetarian"};
		Object[][] data2 = {
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
					};
				
		JTable operationsTable = new JTable(data2, columnNames2);
		operationsTable.setPreferredScrollableViewportSize(operationsTable.getPreferredSize());
		operationsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		operationsTable.setFillsViewportHeight(false);
		operationsPanel.add(operationsTable, BorderLayout.SOUTH);
		JPanel buttonPanel2 = new JPanel();
		operationsPanel.setBackground(new Color(55,55,55));
		operationsPanel.setPreferredSize(new Dimension(dim.width, 150));
		buttonPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton addNewOperation = new JButton("Add operation");
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
		box.add(attributesPanel);
		box.add(operationsPanel);
		box.add(buttonsPanel);
		this.add(box);
		this.setVisible(true);
	}
}

class ItemChangeListener implements ItemListener{
    @Override
    public void itemStateChanged(ItemEvent event) {
          Object item = event.getItem();
          // do something with object
    }       
}
