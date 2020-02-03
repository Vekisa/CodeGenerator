package windows.new_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.new_class.RemoveAttribute;
import controller.new_interface.NewInterface;
import controller.new_interface.RemoveInterfaceMethod;
import controller.ow.NewAttributeEditOW;
import controller.ow.NewAttributeOW;
import controller.ow.NewInterfaceMethodEditOW;
import controller.ow.NewMethodOW;


public class NewInterfaceWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8313874263835311328L;
	private static NewInterfaceWindow instance;
	private DefaultTableModel modelTable;
	private DefaultTableModel modelTable2;
	private JTable table;
	private JTable table2;
	private JTextField interfaceName;
	
	public JTextField getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(JTextField interfaceName) {
		this.interfaceName = interfaceName;
	}

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
		this.setPreferredSize(new Dimension(750, 300));
		this.pack();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setTitle("Interface");
		
		// name panel
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel classNameLabel = new JLabel("Name: ");
		interfaceName = new JTextField();
		Dimension fieldDimension = new Dimension(200, 25);
		interfaceName.setPreferredSize(fieldDimension);
		
		namePanel.add(classNameLabel);
		namePanel.add(interfaceName);
		
		// table methods
		JPanel methodPanel = new JPanel();
		methodPanel.setLayout(new BorderLayout());
		Object[] data = { "AcsModifier", "Static", "Return Value", "Name", "Virtual", "HiddenParameters", "Parameters" };
		modelTable = new DefaultTableModel(data, 7);
		table = new JTable(modelTable);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(false);
		
		methodPanel.add(scrollPane, BorderLayout.SOUTH);
		
		//method button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton addNewMethod = new JButton(new NewMethodOW());
		JButton removeMethod = new JButton(new RemoveInterfaceMethod());
		JButton editMethod = new JButton(new NewInterfaceMethodEditOW());
		
		buttonPanel.add(addNewMethod);
		buttonPanel.add(removeMethod);
		buttonPanel.add(editMethod);
		
		methodPanel.add(buttonPanel, BorderLayout.NORTH);
		table.getColumnModel().getColumn(5).setMinWidth(0);
		table.getColumnModel().getColumn(5).setMaxWidth(0);
		table.getColumnModel().getColumn(5).setWidth(0);
		
		// table constants
		/*JPanel constPanel = new JPanel();
		constPanel.setLayout(new BorderLayout());
		Object[] data2 = { "AcsModifier", "Static", "Type", "Name", "Const", "Getters", "Setters" };
		modelTable2 = new DefaultTableModel(data2, 7);
		table2 = new JTable(modelTable2);
		table2.setPreferredScrollableViewportSize(table2.getPreferredSize());
		JScrollPane scrollPane2 = new JScrollPane(table2);
		scrollPane2.setBackground(new Color(55, 55, 55));
		table2.setFillsViewportHeight(false);
		constPanel.add(scrollPane2, BorderLayout.SOUTH);
		
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton addNewAttribute = new JButton("add");
		JButton removeAttribute = new JButton("remove");
		JButton editAttribute = new JButton("edit");
		
		buttonPanel2.add(addNewAttribute);
		buttonPanel2.add(removeAttribute);
		buttonPanel2.add(editAttribute);
		constPanel.add(buttonPanel2, BorderLayout.NORTH);
		*/
		
		
		//main button panel
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(e ->{
			this.dispose();
		});
		JButton create = new JButton(new NewInterface());
		buttonsPanel.add(create);
		buttonsPanel.add(cancel);
		
		//adding panels to the box
		box.add(namePanel);
		//box.add(constPanel);
		box.add(methodPanel);
		box.add(buttonsPanel);

		this.add(box);
		this.setVisible(true);
		this.getRootPane().setDefaultButton(create);
		
		
		
	}
	
	public ArrayList<model.Operation> getTableOperations() {
		ArrayList<model.Operation> list = new ArrayList<model.Operation>();
		model.Operation operation = null;
		for(int i = 0; i < modelTable.getRowCount(); i++) {
			operation = new model.Operation();
			operation.setAcsModifier(modelTable.getValueAt(i, table.getColumn("AcsModifier").getModelIndex()).toString());
			operation.setStatic(modelTable.getValueAt(i, table.getColumn("Static").getModelIndex()).toString());
			operation.setReturnValue(modelTable.getValueAt(i, table.getColumn("Return Value").getModelIndex()).toString());
			operation.setName(modelTable.getValueAt(i, table.getColumn("Name").getModelIndex()).toString());
			operation.setVirtual(modelTable.getValueAt(i, table.getColumn("Virtual").getModelIndex()).toString());
			Object o = modelTable.getValueAt(i, table.getColumn("HiddenParameters").getModelIndex());
			@SuppressWarnings("unchecked")
			ArrayList<model.Attribute> att = (ArrayList<model.Attribute>)o;
			operation.setParameters(att);
			list.add((model.Operation) operation);
		}
		return list;
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
	
	public void addingRowTableOperations(Object[] data) {
		modelTable.insertRow(0, data);
	}

	public DefaultTableModel getModelTable2() {
		return modelTable2;
	}
	
	public void removeTableRow(JTable table) {
		DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
		int[] rows = table.getSelectedRows();
		for(int row: rows) {
			modelTable.removeRow(table.convertRowIndexToModel(row));
		}
	}
	
}







