package windows.new_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ow.NewMethodOW;


public class NewInterfaceWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8313874263835311328L;
	private static NewInterfaceWindow instance;
	private DefaultTableModel modelTable;
	private JTable table;
	
	@SuppressWarnings("deprecation")
	public static NewInterfaceWindow getInstance() {
		if(NewInterfaceWindow.instance == null) {
			NewInterfaceWindow.instance = new NewInterfaceWindow();
		}
		NewInterfaceWindow.instance.show();
		return NewInterfaceWindow.instance;
	}
	
	public NewInterfaceWindow() {
		Box box = Box.createVerticalBox();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(550, 350));
		this.pack();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setTitle("Interface");
		
		// name panel
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel classNameLabel = new JLabel("Name: ");
		JTextField interfaceName = new JTextField();
		Dimension fieldDimension = new Dimension(200, 25);
		interfaceName.setPreferredSize(fieldDimension);
		
		namePanel.add(classNameLabel);
		namePanel.add(interfaceName);
		
		// table methods
		JPanel methodPanel = new JPanel();
		methodPanel.setLayout(new BorderLayout());
		Object[] data = { "AcsModifier", "Type", "Name", "HiddenParameters", "Parameters"};
		modelTable = new DefaultTableModel(data, 10);
		table = new JTable(modelTable);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(false);
		
		methodPanel.add(scrollPane, BorderLayout.SOUTH);
		
		//method button panel
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton addNewMethod = new JButton(new NewMethodOW());
		JButton removeMethod = new JButton("Remove");
		JButton editMethod = new JButton("Edit");
		
		buttonPanel2.add(addNewMethod);
		buttonPanel2.add(removeMethod);
		buttonPanel2.add(editMethod);
		
		methodPanel.add(buttonPanel2, BorderLayout.NORTH);
		table.getColumnModel().getColumn(3).setMinWidth(0);
		table.getColumnModel().getColumn(3).setMaxWidth(0);
		table.getColumnModel().getColumn(3).setWidth(0);
		
		//main button panel
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(e ->{
			this.dispose();
		});
		JButton create = new JButton("Create");
		buttonsPanel.add(create);
		buttonsPanel.add(cancel);
		
		//adding panels to the box
		box.add(namePanel);
		box.add(methodPanel);
		box.add(buttonsPanel);

		this.add(box);
		this.setVisible(true);
		this.getRootPane().setDefaultButton(create);
		
		
		
	}

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public void setModelTable(DefaultTableModel modelTable) {
		this.modelTable = modelTable;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(DefaultTableModel modelTable) {
		modelTable.setRowCount(0);
	}
}







