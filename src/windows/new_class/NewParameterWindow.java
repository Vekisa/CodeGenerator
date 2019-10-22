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

import controller.new_class.NewOperationParameter;

public class NewParameterWindow extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8649572864215527663L;
	private static NewParameterWindow instance;
	private JTextField parameterName;
	private JComboBox<String> combo;
	private JCheckBox staticBox;
	private JCheckBox virtual;
	private JCheckBox getters;
	private JCheckBox setters;
	
	@SuppressWarnings("deprecation")
	public static NewParameterWindow getInstance() {
		if(NewParameterWindow.instance == null) {
			NewParameterWindow.instance = new NewParameterWindow();
		}
		NewParameterWindow.instance.show();
		return NewParameterWindow.instance;
	}
	public NewParameterWindow() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(700, 200));
		this.pack();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Operation");
		this.setLayout(new BorderLayout());
		
		//parameter panel
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.LEFT));
		parameterName = new JTextField();
		Dimension fieldDimension = new Dimension(100,25);
		parameterName.setPreferredSize(fieldDimension);
		String[] list = {"int", "String", "boolean", "double", "char", "float"};
		combo = new JComboBox<String>(list);
		staticBox = new JCheckBox("Static");
		virtual = new JCheckBox("Virtual");
		getters = new JCheckBox("Getters");
		setters = new JCheckBox("Setters");
		
		//create cancel panel
		JPanel ccBtnPanel = new JPanel();
		JButton createButton = new JButton(new NewOperationParameter());
		JButton cancelButton = new JButton("Cancel");
		ccBtnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		ccBtnPanel.add(createButton);
		ccBtnPanel.add(cancelButton);
		
		top.add(combo);
		top.add(parameterName);
		top.add(staticBox);
		top.add(virtual);
		top.add(getters);
		top.add(setters);
		this.add(top, BorderLayout.NORTH);
		this.add(ccBtnPanel, BorderLayout.SOUTH);
		this.setVisible(true);
		
	}
	public JTextField getParameterName() {
		return parameterName;
	}
	public void setParameterName() {
		this.parameterName.setText("");
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
