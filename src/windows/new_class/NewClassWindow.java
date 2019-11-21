package windows.new_class;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import controller.new_class.NewClass;
import controller.new_class.NewOperationRemove;
import controller.new_class.RemoveAttribute;
import controller.new_class.RemoveClassExtends;
import controller.ow.NewAttributeEditOW;
import controller.ow.NewAttributeOW;
import controller.ow.NewClassExtendsOW;
import controller.ow.NewOperationEditOW;
import controller.ow.NewOperationOW;

public class NewClassWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1978685336525540440L;
	private static NewClassWindow instance;
	private DefaultListModel<String> modelExtends;
	private DefaultListModel<String> modelImplements;
	private DefaultTableModel modelTable;
	private DefaultTableModel modelTable2;
	private JList<String> classList;
	private JTable table;
	private JTable table2;
	private JTextField classNameField;
	private JCheckBox defaultConstructor;
	private String[] columnNames = { "Name", "Type", "Static", "Virtual", "Getter", "Setter" };
	private JComboBox<String> combo;
	private JComboBox<String> classAcsModifier;

	public String[] getColumnNames() {
		return columnNames;
	}

	@SuppressWarnings("deprecation")
	public static NewClassWindow getInstance() {
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
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setTitle("Class");

		// name panel
		JPanel namePane = new JPanel();
		namePane.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel classNameLabel = new JLabel("Name: ");
		classNameField = new JTextField();
		Dimension fieldDimension = new Dimension(200, 25);
		classNameField.setPreferredSize(fieldDimension);
		String[] list2 = {"public", "private", "protected"};
		classAcsModifier = new JComboBox<String>(list2);

		String[] list = { "extends", "implement" };
		combo = new JComboBox<String>(list);
		combo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (combo.getSelectedIndex() == 0)
					classList.setModel(modelExtends);
				else
					classList.setModel(modelImplements);
				;
			}
		});

		modelExtends = new DefaultListModel<>();
		modelImplements = new DefaultListModel<>();

		classList = new JList<String>(modelExtends);
		classList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		classList.setLayoutOrientation(JList.VERTICAL);
		classList.setVisibleRowCount(-1);

		JScrollPane listScroller = new JScrollPane(classList);
		listScroller.setPreferredSize(new Dimension(150, 80));

		JButton addNewClass = new JButton(new NewClassExtendsOW());
		JButton removeClass = new JButton(new RemoveClassExtends());
		
		namePane.add(classAcsModifier);
		namePane.add(classNameLabel);
		namePane.add(classNameField);
		namePane.add(combo);
		namePane.add(listScroller);
		namePane.add(addNewClass);
		namePane.add(removeClass);

		// parameters panel
		JPanel parametersPanel = new JPanel();
		parametersPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		parametersPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		defaultConstructor = new JCheckBox("Default Constructor");
		parametersPanel.add(defaultConstructor);

		// attributes panel
		JPanel attributesPanel = new JPanel();
		attributesPanel.setLayout(new BorderLayout());
		Object[] data = { "AcsModifier", "Static", "Type", "Name", "Const", "Getters", "Setters" };
		modelTable = new DefaultTableModel(data, 7);
		table = new JTable(modelTable);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(55, 55, 55));
		table.setFillsViewportHeight(false);
		attributesPanel.add(scrollPane, BorderLayout.SOUTH);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton addNewAttribute = new JButton(new NewAttributeOW());
		JButton removeAttribute = new JButton(new RemoveAttribute());
		JButton editAttribute = new JButton(new NewAttributeEditOW());
		
		buttonPanel.add(addNewAttribute);
		buttonPanel.add(removeAttribute);
		buttonPanel.add(editAttribute);
		attributesPanel.add(buttonPanel, BorderLayout.NORTH);

		// operations panel
		JPanel operationsPanel = new JPanel();
		operationsPanel.setLayout(new BorderLayout());
		Object[] data2 = { "AcsModifier", "Static", "Return Value", "Name", "Virtual", "HiddenParameters", "Parameters" };
		modelTable2 = new DefaultTableModel(data2, 7);
		table2 = new JTable(modelTable2);
		table2.setPreferredScrollableViewportSize(table2.getPreferredSize());
		JScrollPane scrollPane2 = new JScrollPane(table2);
		table2.setFillsViewportHeight(false);
		operationsPanel.add(scrollPane2, BorderLayout.SOUTH);
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton addNewOperation = new JButton(new NewOperationOW());
		JButton removeOperation = new JButton(new NewOperationRemove());
		JButton editOperation = new JButton(new NewOperationEditOW());
		buttonPanel2.add(addNewOperation);
		buttonPanel2.add(removeOperation);
		buttonPanel2.add(editOperation);
		operationsPanel.add(buttonPanel2, BorderLayout.NORTH);
		table2.getColumnModel().getColumn(5).setMinWidth(0);
		table2.getColumnModel().getColumn(5).setMaxWidth(0);
		table2.getColumnModel().getColumn(5).setWidth(0);

		// buttons panel
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(e ->{
			this.dispose();
		});
		JButton ok = new JButton(new NewClass());
		buttonsPanel.add(ok);
		buttonsPanel.add(cancel);

		box.add(namePane);
		box.add(parametersPanel);
		box.add(attributesPanel);
		box.add(operationsPanel);
		box.add(buttonsPanel);
		this.add(box);
		this.setVisible(true);
		this.getRootPane().setDefaultButton(ok);
	}

	public void addItem(String s) {
		if (combo.getSelectedIndex() == 0)
			modelExtends.addElement(s);
		else
			modelImplements.addElement(s);

		System.out.println("IMPL: " + modelImplements.getSize());
		System.out.println("EXT: " + modelExtends.getSize());
	}
	
	public JList<String> getClassListJList() {
		return classList;
	}
	
	public void setClassList(JList<String> classList) {
		this.classList = classList;
	}

	public DefaultListModel<String> getModelExtends() {
		return modelExtends;
	}

	public void setModelExtends(DefaultListModel<String> modelExtends) {
		this.modelExtends = modelExtends;
	}

	public DefaultListModel<String> getModelImplements() {
		return modelImplements;
	}

	public void setModelImplements(DefaultListModel<String> modelImplements) {
		this.modelImplements = modelImplements;
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public DefaultTableModel getModelTable2() {
		return modelTable2;
	}

	public JTable getTable2() {
		return table2;
	}

	public void setTable(DefaultTableModel modelTable) {
		modelTable.setRowCount(0);
	}

	public void addingRowTableAttributes(Object[] data) {
		modelTable.insertRow(0, data);
	}

	public void addingRowTableOperations(Object[] data) {
		modelTable2.insertRow(0, data);
	}

	public JTextField getClassNameField() {
		return classNameField;
	}

	public void setClassNameField(JTextField classNameField) {
		this.classNameField = classNameField;
	}

	public JCheckBox getDefaultConstructor() {
		return defaultConstructor;
	}

	public void setDefaultConstructor(JCheckBox defaultConstructor) {
		this.defaultConstructor = defaultConstructor;
	}

	public ArrayList<String> getClassList() {
		ArrayList<String> list = new ArrayList<String>(modelExtends.getSize());
		for (int i = 0; i < modelExtends.getSize(); i++) {
			list.add(modelExtends.getElementAt(i));
		}
		return list;
	}

	public ArrayList<String> getInterfaceList() {
		ArrayList<String> list = new ArrayList<String>(modelImplements.getSize());
		for (int i = 0; i < modelImplements.getSize(); i++) {
			list.add(modelImplements.getElementAt(i));
		}
		return list;
	}

	public ArrayList<model.Attribute> getTableAttributes() {
		ArrayList<model.Attribute> list = new ArrayList<model.Attribute>();
		model.Attribute atribut = null;
		System.out.println("radi ulaz u atribut");
		for (int i = 0; i < table.getModel().getRowCount(); i++) {
			atribut = new model.Attribute();
			System.out.println("radi i for");
			atribut.setAcsModifiers(modelTable.getValueAt(i, table.getColumn("AcsModifier").getModelIndex()).toString());
			atribut.setIsStatic(modelTable.getValueAt(i, table.getColumn("Static").getModelIndex()).toString());
			atribut.setType(modelTable.getValueAt(i, table.getColumn("Type").getModelIndex()).toString());
			atribut.setName(modelTable.getValueAt(i, table.getColumn("Name").getModelIndex()).toString());
			atribut.setConst(modelTable.getValueAt(i, table.getColumn("Const").getModelIndex()).toString());
			atribut.setGetter(modelTable.getValueAt(i, table.getColumn("Getters").getModelIndex()).toString());
			atribut.setSetter(modelTable.getValueAt(i, table.getColumn("Setters").getModelIndex()).toString());
			list.add((model.Attribute) atribut);
		}
		return list;
	}

	public ArrayList<model.Operation> getTableOperations() {
		ArrayList<model.Operation> list = new ArrayList<model.Operation>();
		model.Operation operation = null;
		for(int i = 0; i < modelTable2.getRowCount(); i++) {
			operation = new model.Operation();
			operation.setAcsModifier(modelTable2.getValueAt(i, table2.getColumn("AcsModifier").getModelIndex()).toString());
			operation.setStatic(modelTable2.getValueAt(i, table2.getColumn("Static").getModelIndex()).toString());
			operation.setReturnValue(modelTable2.getValueAt(i, table2.getColumn("Return Value").getModelIndex()).toString());
			operation.setName(modelTable2.getValueAt(i, table2.getColumn("Name").getModelIndex()).toString());
			operation.setVirtual(modelTable2.getValueAt(i, table2.getColumn("Virtual").getModelIndex()).toString());
			Object o = modelTable2.getValueAt(i, table2.getColumn("HiddenParameters").getModelIndex());
			@SuppressWarnings("unchecked")
			ArrayList<model.Attribute> att = (ArrayList<model.Attribute>)o;
			operation.setParameters(att);
			list.add((model.Operation) operation);
		}
		return list;
	}
	
	public void removeTableRow(JTable table, DefaultTableModel modelTable) {
		int[] rows = table.getSelectedRows();
		for(int row: rows) {
			modelTable.removeRow(table.convertRowIndexToModel(row));
		}
	}

	public JComboBox<String> getCombo() {
		return combo;
	}

	public void setCombo(JComboBox<String> combo) {
		this.combo = combo;
	}

}
