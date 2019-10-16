package windows.new_class;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.new_class.NewAttribute;
import controller.new_enum.NewEnum;

public class NewAttributeWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8957473323992016134L;
	private static NewAttributeWindow instance;
	private JTextField attributeName;
	private JComboBox<String> combo;
	private JCheckBox staticBox;
	private JCheckBox virtual;
	private JCheckBox getters;
	private JCheckBox setters;
	
	@SuppressWarnings("deprecation")
	public static NewAttributeWindow getInstance () {
	    if (NewAttributeWindow.instance == null) {
	    	NewAttributeWindow.instance = new NewAttributeWindow();
	    }
	    NewAttributeWindow.instance.show();
	    return NewAttributeWindow.instance;
	}

	public NewAttributeWindow() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(500, 200));
		this.pack();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Attribute");
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//detail of attributes panel
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.LEFT));
		attributeName = new JTextField();
		attributeName.setToolTipText("Name of the class");
		Dimension fieldDimension = new Dimension(100,25);
		attributeName.setPreferredSize(fieldDimension);
		String[] list = {"none", "int", "String", "boolean", "double", "char", "float"};
		combo = new JComboBox<String>(list);
		staticBox = new JCheckBox("Static");
		virtual = new JCheckBox("Virtual");
		getters = new JCheckBox("Getters");
		setters = new JCheckBox("Setters");
		
		//create cancel panel
		JPanel ccBtnPanel = new JPanel();
		JButton createButton = new JButton(new NewAttribute());
		JButton cancelButton = new JButton("Cancel");
		ccBtnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ccBtnPanel.add(createButton);
		ccBtnPanel.add(cancelButton);
		
		top.add(attributeName);
		top.add(combo);
		top.add(staticBox);
		top.add(virtual);
		top.add(getters);
		top.add(setters);
		this.setVisible(true);	
		this.add(top, BorderLayout.NORTH);
		this.add(ccBtnPanel, BorderLayout.SOUTH);
	}

	public JTextField getAttributeName() {
		return attributeName;
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

	public JCheckBox getGetters() {
		return getters;
	}

	public JCheckBox getSetters() {
		return setters;
	}
}
