package windows.new_class;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.new_class.NewOperation;
import controller.new_class.NewParameterRemove;
import controller.new_class.SaveEditedOperation;
import controller.ow.NewParameterOW;

public class NewOperationWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6886496950805053857L;
	private static NewOperationWindow instance;
	private JComboBox<String> acsModifier;
	private JTextField methodName;
	private JComboBox<String> combo;
	private JCheckBox staticBox;
	private JCheckBox virtual;
	private DefaultTableModel modelTable;
	private JButton createButton;
	private JButton saveButton;
	private JTable table;
	Object[] data = {"Type", "Name", "Static", "Const", "Getters", "Setters"};
	
	public static NewOperationWindow getInstance () {
	    if (NewOperationWindow.instance == null) {
	    	NewOperationWindow.instance = new NewOperationWindow();
	    }
	    NewOperationWindow.instance.show();
	    return NewOperationWindow.instance;
	}

	/*@SuppressWarnings("deprecation")
	public void showme() {
		NewOperationWindow.instance.show();
	}*/
	
	public NewOperationWindow() {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(1100, 200));
		this.pack();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Operation");
		this.setLayout(new BorderLayout());
		
		//detail of operations panel
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.LEFT));
		methodName = new JTextField();
		methodName.setToolTipText("Name of the method");
		Dimension fieldDimension = new Dimension(100,25);
		methodName.setPreferredSize(fieldDimension);
		String[] list = {"void", "int", "String", "boolean", "double", "char", "float", "Object"};
		String[] list2 = {"public", "private", "protected"};
		acsModifier = new JComboBox<String>(list2);
		combo = new JComboBox<String>(list);
		staticBox = new JCheckBox("Static");
		virtual = new JCheckBox("Virtual");
		
		//parameters table	
		modelTable = new DefaultTableModel(data, 4);
		table = new JTable(modelTable);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(55,55,55));
		table.setFillsViewportHeight(false);
		JButton addParameter = new JButton(new NewParameterOW());
		JButton removeParameter = new JButton(new NewParameterRemove());
		
		//create cancel panel
		JPanel ccBtnPanel = new JPanel();
		createButton = new JButton(new NewOperation());
		JButton cancelButton = new JButton("Cancel");
		saveButton = new JButton(new SaveEditedOperation());
		saveButton.hide();
		createButton.hide();
		ccBtnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ccBtnPanel.add(saveButton);
		ccBtnPanel.add(createButton);
		ccBtnPanel.add(cancelButton);
		
		top.add(acsModifier);
		top.add(staticBox);
		top.add(combo);
		top.add(methodName);
		top.add(virtual);
		top.add(scrollPane);
		top.add(addParameter);
		top.add(removeParameter);
		this.add(top, BorderLayout.NORTH);
		this.add(ccBtnPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}	
	public JButton getCreateButton() {
		return createButton;
	}

	public void setCreateButton(JButton createButton) {
		this.createButton = createButton;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}

	public void reset() {
		modelTable = new DefaultTableModel(data, 4);
		table = new JTable();
		table.setModel(modelTable);
	}
	
	public void setMethodName(String methodName) {
		this.methodName.setText(methodName);;
	}

	public void setCombo(String s) {
		combo.setSelectedItem(s);;
	}

	public void setStaticBox(String b) {
		this.staticBox.setSelected(Boolean.parseBoolean(b));
	}
	
	public void setStaticBox(Boolean b) {
		this.staticBox.setSelected(b);
	}

	public void setVirtual(String b) {
		this.virtual.setSelected(Boolean.parseBoolean(b));
	}
	
	public void setVirtual(Boolean b) {
		this.virtual.setSelected(b);
	}

	public void setModelTable(DefaultTableModel modelTable) {
		this.modelTable = modelTable;
	}

	public void setTable() {
		modelTable = (DefaultTableModel) table.getModel();
		modelTable.setRowCount(0);
	}

	public JTextField getMethodName() {
		return methodName;
	}

	public JComboBox<String> getCombo() {
		return combo;
	}

	public JCheckBox getStaticBox() {
		return staticBox;
	}

	public JCheckBox getVirtual() {
		return virtual;
	}

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public JTable getTable() {
		return table;
	}

	public String tableToString() {
		String s = "";
		for(int i = 0; i < table.getRowCount() ; i++) {
			if(i != 0) {
				s = s + ";" + " ";
			}
			for(int j = 0; j < 2; j++) {
				if(table.getModel().getValueAt(i, j) != null) {
					s += table.getModel().getValueAt(i, j);
					if( j == 0) {
						s += " ";
					}
				} else {
					i = table.getRowCount();
					break;
				}
			}
		}
		
		return s;
	}
	
	public ArrayList<model.Attribute> tableToArray() {
		model.Attribute parametar = null;
		ArrayList<model.Attribute> parameters = new ArrayList<model.Attribute>();
		for(int j = 0; j < table.getModel().getRowCount(); j++ ) {
			parametar = new model.Attribute();
			parametar.setType(table.getModel().getValueAt(j, table.getColumn("Type").getModelIndex()).toString());
			parametar.setName(table.getModel().getValueAt(j, table.getColumn("Name").getModelIndex()).toString());
			parametar.setIsStatic(table.getModel().getValueAt(j, table.getColumn("Static").getModelIndex()).toString());
			parametar.setConst(table.getModel().getValueAt(j, table.getColumn("Const").getModelIndex()).toString());
			parametar.setGetter(table.getModel().getValueAt(j, table.getColumn("Getters").getModelIndex()).toString());
			parametar.setSetter(table.getModel().getValueAt(j, table.getColumn("Setters").getModelIndex()).toString());
			parameters.add((model.Attribute) parametar);
		}
		
		return parameters;
	}
	
	public void addingRowTable(Object[] data) {
		this.modelTable = (DefaultTableModel) this.table.getModel();
		modelTable.insertRow(0, data);
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JComboBox<String> getAcsModifier() {
		return acsModifier;
	}

	public void setAcsModifier(String str) {
		acsModifier.setSelectedItem(str);
	}
	
	public void arrayToTable(int row) {
		Object data = (NewClassWindow.getInstance().getTable2().getValueAt(row, 5));
		@SuppressWarnings("unchecked")
		ArrayList<model.Attribute> attributes = (ArrayList<model.Attribute>) data;
		Object[] rowData = {};
		for(model.Attribute a : attributes ) {
			rowData = new Object[] {a.getType(), a.getName(), a.isStatic(), a.isConst(), a.isGetter(), a.isSetter()};
			modelTable.insertRow(0, rowData);
		}
		System.out.println(data);
	}

	public void setMethodName(JTextField methodName) {
		this.methodName = methodName;
	}

	public void setStaticBox(JCheckBox staticBox) {
		this.staticBox = staticBox;
	}

	public void setVirtual(JCheckBox virtual) {
		this.virtual = virtual;
	}
}
