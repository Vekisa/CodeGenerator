package windows.new_class;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NewShowTableWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -644778826376002400L;
	private static NewShowTableWindow instance;
	private DefaultTableModel modelTable;
	private JTable table;
	Object[] data = {"Type", "Name", "Static", "Const", "Getters", "Setters"};
	
	@SuppressWarnings("deprecation")
	public static NewShowTableWindow getInstance () {
	    if (NewShowTableWindow.instance == null) {
	    	NewShowTableWindow.instance = new NewShowTableWindow();
	    }
	    NewShowTableWindow.instance.show();
	    return NewShowTableWindow.instance;
	}
	
	public NewShowTableWindow() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(900, 200));
		this.pack();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Operation");
		this.setLayout(new BorderLayout());
		
		//detail of operations panel
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//parameters table	
		modelTable = new DefaultTableModel(data, 4);
		table = new JTable(modelTable);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(55,55,55));
		table.setFillsViewportHeight(false);
		JButton edit = new JButton(new NewTableEdit());
		
		
		top.add(scrollPane);
		top.add(edit);
		this.add(top, BorderLayout.NORTH);
		this.setVisible(true);
		arrayToTable();
	}
	
	public void arrayToTable() {
		Object data = (NewClassWindow.getInstance().getTable2().getValueAt(NewClassWindow.getInstance().getRow(), 5));
		@SuppressWarnings("unchecked")
		ArrayList<model.Attribute> attributes = (ArrayList<model.Attribute>) data;
		Object[] row = {};
		for(model.Attribute a : attributes ) {
			row = new Object[] {a.getType(), a.getName(), a.isStatic(), a.isConst(), a.isGetter(), a.isSetter()};
			modelTable.insertRow(0, row);
		}
		System.out.println(data);
	}
	public ArrayList<model.Attribute> tableToArray() {
		model.Attribute parametar = null;
		ArrayList<model.Attribute> parameters = new ArrayList<model.Attribute>();
		for(int j = 0; j < modelTable.getRowCount(); j++ ) {
			if(modelTable.getValueAt(j, 0) == null)
				continue;
			parametar = new model.Attribute();
			System.out.println(modelTable.getValueAt(j, table.getColumn("Type").getModelIndex()).toString());
			System.out.println(j);
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

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public void setModelTable(DefaultTableModel modelTable) {
		this.modelTable = modelTable;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}



























