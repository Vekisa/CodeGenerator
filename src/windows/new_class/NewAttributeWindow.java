package windows.new_class;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.new_class.NewAttribute;
import controller.new_class.SaveEditedAttribute;

public class NewAttributeWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8957473323992016134L;
	private static NewAttributeWindow instance;
	private JComboBox<String> acsModifier;
	private JTextField attributeName;
	private JComboBox<String> combo;
	private JCheckBox staticBox;
	private JCheckBox isConst;
	private JCheckBox getters;
	private JCheckBox setters;
	private JButton createButton;
	private JButton saveButton;
	
	@SuppressWarnings("deprecation")
	public static NewAttributeWindow getInstance () {
	    if (NewAttributeWindow.instance == null) {
	    	NewAttributeWindow.instance = new NewAttributeWindow();
	    }
	    NewAttributeWindow.instance.show();
	    return NewAttributeWindow.instance;
	}

	@SuppressWarnings("deprecation")
	public NewAttributeWindow() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(600, 200));
		this.pack();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Attribute");
		this.setLayout(new BorderLayout());
		
		//detail of attributes panel
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.LEFT));
		attributeName = new JTextField();
		attributeName.setToolTipText("Name of the attribute");
		Dimension fieldDimension = new Dimension(100,25);
		attributeName.setPreferredSize(fieldDimension);
		String[] list = {"void", "int", "String", "boolean", "double", "char", "float"};
		String[] list2 = {"public", "private", "protected"};
		acsModifier = new JComboBox<String>(list2);
		combo = new JComboBox<String>(list);
		staticBox = new JCheckBox("Static");
		isConst = new JCheckBox("Const");
		getters = new JCheckBox("Getters");
		setters = new JCheckBox("Setters");
		
		//create cancel panel
		JPanel ccBtnPanel = new JPanel();
		createButton = new JButton(new NewAttribute());
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(e ->{
			this.dispose();
		});
		saveButton = new JButton(new SaveEditedAttribute());
		saveButton.hide();
		createButton.hide();
		ccBtnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ccBtnPanel.add(saveButton);
		ccBtnPanel.add(createButton);
		ccBtnPanel.add(cancelButton);
		
		top.add(acsModifier);
		top.add(staticBox);
		top.add(combo);
		top.add(attributeName);
		top.add(isConst);
		top.add(getters);
		top.add(setters);
		this.setVisible(true);	
		this.add(top, BorderLayout.NORTH);
		this.add(ccBtnPanel, BorderLayout.SOUTH);
		this.getRootPane().setDefaultButton(createButton);
	}

	public JCheckBox getIsConst() {
		return isConst;
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

	public void setIsConst(JCheckBox isConst) {
		this.isConst = isConst;
	}

	public void setAttributeName(JTextField attributeName) {
		this.attributeName = attributeName;
	}

	public void setStaticBox(JCheckBox staticBox) {
		this.staticBox = staticBox;
	}

	public void setGetters(JCheckBox getters) {
		this.getters = getters;
	}

	public void setSetters(JCheckBox setters) {
		this.setters = setters;
	}

	public void setAttributeName(String t) {
		this.attributeName.setText(t);
	}

	public void setCombo(String s) {
		this.combo.setSelectedItem(s);;
	}

	public void setStaticBox(String b) {
		this.staticBox.setSelected(Boolean.parseBoolean(b));
	}

	public void setConst(String b) {
		this.isConst.setSelected(Boolean.parseBoolean(b));
	}

	public void setGetters(String b) {
		this.getters.setSelected(Boolean.parseBoolean(b));
	}

	public void setSetters(String b) {
		this.setters.setSelected(Boolean.parseBoolean(b));
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

	public JCheckBox getConst() {
		return isConst;
	}

	public JCheckBox getGetters() {
		return getters;
	}

	public JCheckBox getSetters() {
		return setters;
	}

	public JComboBox<String> getAcsModifier() {
		return acsModifier;
	}

	public void setAcsModifier(String s) {
		this.acsModifier.setSelectedItem(s);
	}
}
