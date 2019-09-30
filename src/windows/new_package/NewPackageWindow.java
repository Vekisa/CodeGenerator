package windows.new_package;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.new_package.NewPackage;

public class NewPackageWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4354250301592285012L;
	
	private static NewPackageWindow instance;
	private JTextField nameField;
	
	@SuppressWarnings("deprecation")
	public static NewPackageWindow getInstance () {
	    if (NewPackageWindow.instance == null) {
	    	NewPackageWindow.instance = new NewPackageWindow();
	    }
	    NewPackageWindow.instance.show();
	    return NewPackageWindow.instance;
	}

	public NewPackageWindow() {
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.setLayout(new BorderLayout());
		
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(300, 150));
		this.pack();
		
		this.setLocation(dim.width/2- this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		
		this.setTitle("Package");
		
		JLabel label = new JLabel("Name: ");
		nameField = new JTextField();
		Dimension fieldDimension = new Dimension(200,25);
		nameField.setPreferredSize(fieldDimension);
		
		JButton cancel = new JButton("Cancel");
		JButton create = new JButton("Ok");
		create.addActionListener(new NewPackage());
		
		inputPanel.add(label);
		inputPanel.add(nameField);
		buttonPanel.add(cancel);
		buttonPanel.add(create);
		
		this.add(inputPanel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public String getValue() {
		return nameField.getText();
	}
}
