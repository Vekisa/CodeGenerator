package windows.new_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.new_interface.NewMethodParameter;

public class NewMethodParameterWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8861218283615155270L;
	private static NewMethodParameterWindow instance;
	private JComboBox<String> combo;
	private JTextField parameterName;
	private JCheckBox isStatic;
	private JCheckBox isConst;
	private JCheckBox getters;
	private JCheckBox setters;
	
	@SuppressWarnings("deprecation")
	public static NewMethodParameterWindow getInstance() {
		if(NewMethodParameterWindow.instance == null) {
			NewMethodParameterWindow.instance = new NewMethodParameterWindow();
		}
		NewMethodParameterWindow.instance.show();
		return NewMethodParameterWindow.instance;
	}
	
	public NewMethodParameterWindow() {
		Box box = Box.createVerticalBox();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(450, 250));
		this.pack();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setTitle("Method parameter");
		
		
		//paramteres panel
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.LEFT));
		String[] list = {"void", "int", "String", "boolean", "double", "char", "float", "Object"};
		combo = new JComboBox<String>(list);
		parameterName = new JTextField();
		Dimension nameDimension = new Dimension(100, 25);
		parameterName.setPreferredSize(nameDimension);
		isStatic = new JCheckBox("Static");
		isConst = new JCheckBox("Const");
		getters = new JCheckBox("getter");
		setters = new JCheckBox("setter");
		
		//buttton panel
		JPanel bot = new JPanel();
		bot.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton addBtn = new JButton(new NewMethodParameter());
		JButton cancelBtn = new JButton("cancel");
		cancelBtn.addActionListener(e ->{
			this.dispose();
		});
		
		top.add(combo);
		top.add(parameterName);
		top.add(isStatic);
		top.add(isConst);
		top.add(getters);
		top.add(setters);
		bot.add(addBtn);
		bot.add(cancelBtn);
		
		//adding to box
		this.add(top, BorderLayout.NORTH);
		this.add(bot, BorderLayout.SOUTH);
		this.setVisible(true);
		
	}

	public JComboBox<String> getCombo() {
		return combo;
	}

	public void setCombo(JComboBox<String> combo) {
		this.combo = combo;
	}

	public JTextField getParameterName() {
		return parameterName;
	}

	public void setParameterName(String a) {
		this.parameterName.setText(a);;
	}

	public JCheckBox getIsStatic() {
		return isStatic;
	}

	public void setIsStatic(JCheckBox isStatic) {
		this.isStatic = isStatic;
	}

	public JCheckBox getIsConst() {
		return isConst;
	}

	public void setIsConst(JCheckBox isConst) {
		this.isConst = isConst;
	}

	public JCheckBox getGetters() {
		return getters;
	}

	public void setGetters(JCheckBox getters) {
		this.getters = getters;
	}

	public JCheckBox getSetters() {
		return setters;
	}

	public void setSetters(JCheckBox setters) {
		this.setters = setters;
	}

	public void setParameterName(JTextField parameterName) {
		this.parameterName = parameterName;
	}
}
