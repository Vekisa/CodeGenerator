package windows.new_class;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ow.NewParameterOW;

public class NewShowTableWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -644778826376002400L;
	private static NewShowTableWindow instance;
	private DefaultTableModel modelTable;
	private JTable table;
	Object[] data = {"Type", "Name", "Static", "Virtual", "Getters", "Setters"};
	
	public static NewShowTableWindow getInstance () {
	    if (NewShowTableWindow.instance == null) {
	    	NewShowTableWindow.instance = new NewShowTableWindow();
	    }
	    
	    return NewShowTableWindow.instance;
	}

	@SuppressWarnings("deprecation")
	public void showme() {
		NewShowTableWindow.instance.show();
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
		JButton addParameter = new JButton(new NewParameterOW());
		
		top.add(scrollPane);
		this.add(top, BorderLayout.NORTH);
		this.setVisible(true);

	}	
}



























