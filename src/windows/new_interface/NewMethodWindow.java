package windows.new_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.new_class.NewParameterRemove;
import controller.new_interface.NewMethod;
import controller.new_interface.RemoveParameter;
import controller.new_interface.SaveEditedMethod;
import controller.ow.NewMethodParameterOW;
import controller.ow.NewParameterOW;
import windows.new_class.NewClassWindow;

public class NewMethodWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7389292506004714169L;
	private static NewMethodWindow instance;
	private JTextField methodName;
	private JComboBox<String> AcsModifier;
	private JComboBox<String> combo;
	private DefaultTableModel modelTable;
	private JTable table;
	private JCheckBox isStatic;
	private JCheckBox virtual;
	private JButton saveButton;
	private JButton createBtn;
	Object[] data = {"Type", "Name", "Static", "Const", "Getters", "Setters"};
	
	@SuppressWarnings("deprecation")
	public static NewMethodWindow getInstance() {
		if(NewMethodWindow.instance == null) {
			NewMethodWindow.instance = new NewMethodWindow();
		}
		NewMethodWindow.instance.show();
		return NewMethodWindow.instance;
	}
	
	@SuppressWarnings("deprecation")
	public NewMethodWindow() {
		Box box = Box.createVerticalBox();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(1050, 350));
		this.pack();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setTitle("Method");
		
		//Acsmodifier, type and name panel
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.LEFT));
		methodName = new JTextField();
		Dimension fieldDimension = new Dimension(100,25);
		methodName.setPreferredSize(fieldDimension);
		methodName.setToolTipText("Name of the method");
		String[] list = {"public", "private", "protected"};
		AcsModifier = new JComboBox<String>(list);
		isStatic = new JCheckBox("Static");
		virtual = new JCheckBox("Virtual");
		String[] list2 = {"void", "int", "String", "boolean", "double", "char", "float", "Object"};
		combo = new JComboBox<String>(list2);
		

		//parameters table	
		modelTable = new DefaultTableModel(data, 4);
		table = new JTable(modelTable);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(55,55,55));
		table.setFillsViewportHeight(false);
		JButton addParameter = new JButton(new NewMethodParameterOW());
		JButton removeParameter = new JButton(new RemoveParameter());
		
		//cancel create button panel
		JPanel bot = new JPanel();
		createBtn = new JButton(new NewMethod());
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(e ->{
			this.dispose();
		});
		saveButton = new JButton(new SaveEditedMethod());
		saveButton.hide();
		createBtn.hide();
		bot.add(saveButton);
		bot.add(createBtn);
		bot.add(cancelBtn);
		
		// adding to box
		top.add(AcsModifier);
		top.add(isStatic);
		top.add(combo);
		top.add(methodName);
		top.add(virtual);
		top.add(scrollPane);
		top.add(addParameter);
		top.add(removeParameter);
		this.add(top, BorderLayout.NORTH);
		this.add(bot, BorderLayout.SOUTH);
		this.setVisible(true);
		
		
		
		
		
		
	}
	public void setTable(JTable table) {
		this.table = table;
	}

	public void addingRowTable(Object[] data) {
		modelTable.insertRow(0, data);
	}

	public JTextField getMethodName() {
		return methodName;
	}

	public void setMethodName(JTextField methodName) {
		this.methodName = methodName;
	}

	public JComboBox<String> getAcsModifier() {
		return AcsModifier;
	}

	public void setAcsModifier(String str) {
		AcsModifier.setSelectedItem(str);;
	}

	public JComboBox<String> getCombo() {
		return combo;
	}

	public void setCombo(String b) {
		this.combo.setSelectedItem(b);
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

	public void setTable() {
		modelTable.setRowCount(0);
	}
	
	public String tableToString(){
		String s = "";
		for(int i = 0; i < table.getRowCount() ; i++) {
			if(i != 0) {
				s = s + ";" + " ";
			}
			for(int j = 0; j < 2; j++) {
				if(modelTable.getValueAt(i, j) != null) {
					s += modelTable.getValueAt(i, j);
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
	
	public ArrayList<model.Attribute> tableToArray(){
		model.Attribute parametar = null;
		ArrayList<model.Attribute> parameters = new ArrayList<model.Attribute>();
		for(int j = 0; j < modelTable.getRowCount(); j++) {
			parametar = new model.Attribute();
			parametar.setType(modelTable.getValueAt(j, table.getColumn("Type").getModelIndex()).toString());
			parametar.setName(modelTable.getValueAt(j, table.getColumn("Name").getModelIndex()).toString());
			parametar.setIsStatic(modelTable.getValueAt(j, table.getColumn("Static").getModelIndex()).toString());
			parametar.setConst(modelTable.getValueAt(j, table.getColumn("Const").getModelIndex()).toString());
			parametar.setGetter(modelTable.getValueAt(j, table.getColumn("Getters").getModelIndex()).toString());
			parametar.setSetter(modelTable.getValueAt(j, table.getColumn("Setters").getModelIndex()).toString());
			parameters.add((model.Attribute) parametar);
		}
		
		return parameters;
	}
	
	public void setTableClear() {
		modelTable.setRowCount(0);
	}

	public JCheckBox getIsStatic() {
		return isStatic;
	}

	public void setIsStatic(String b) {
		this.isStatic.setSelected(Boolean.parseBoolean(b));
	}

	public JCheckBox getVirtual() {
		return virtual;
	}

	public void setVirtual(String b) {
		this.virtual.setSelected(Boolean.parseBoolean(b));
	}
	
	public void removeTableRow(JTable table) {
		DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
		int[] rows = table.getSelectedRows();
		for(int row: rows) {
			modelTable.removeRow(table.convertRowIndexToModel(row));
		}
	}
	
	public void arrayToTable(int row) {
		Object data = (NewInterfaceWindow.getInstance().getTable().getValueAt(row, 5));
		@SuppressWarnings("unchecked")
		ArrayList<model.Attribute> attributes = (ArrayList<model.Attribute>) data;
		Object[] rowData = {};
		for(model.Attribute a : attributes ) {
			rowData = new Object[] {a.getType(), a.getName(), a.isStatic(), a.isConst(), a.isGetter(), a.isSetter()};
			modelTable.insertRow(0, rowData);
		}
		System.out.println(data);
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}

	public JButton getCreateBtn() {
		return createBtn;
	}

	public void setCreateBtn(JButton createBtn) {
		this.createBtn = createBtn;
	}
}
