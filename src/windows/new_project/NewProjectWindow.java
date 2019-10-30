package windows.new_project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.new_project.NewProject;

public class NewProjectWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6330958743257682244L;
	
	private static NewProjectWindow instance;
	private JTextField nameField;

	@SuppressWarnings("deprecation")
	public static NewProjectWindow getInstance () {
	    if (NewProjectWindow.instance == null) {
	    	NewProjectWindow.instance = new NewProjectWindow();
	    }
	    NewProjectWindow.instance.show();
	    return NewProjectWindow.instance;
	}

	public NewProjectWindow() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(300, 150));
		this.pack();
		this.setLocation(dim.width/2- this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Project");
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("Name: ");
		nameField = new JTextField();
		Dimension fieldDimension = new Dimension(200,25);
		nameField.setPreferredSize(fieldDimension);
		
		JButton cancel = new JButton("Cancel");
		JButton create = new JButton("Ok");
		create.addActionListener(new NewProject());
		
		inputPanel.add(label);
		inputPanel.add(nameField);
		buttonPanel.add(cancel);
		buttonPanel.add(create);
		
		this.add(inputPanel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.setVisible(true);
		this.getRootPane().setDefaultButton(create);
	}
	
	public String getValue() {
		return nameField.getText();
	}
	
}
