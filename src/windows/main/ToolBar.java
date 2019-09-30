package windows.main;

import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.NewClassOW;
import controller.NewPackageOW;
import controller.NewProjectOW;
import windows.Configuration;

public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1923088154892884764L;
	
	public ToolBar() {
		
		this.setBackground(Configuration.themeColorToolBar);
		
		JButton newProjectBtn = new JButton(new NewProjectOW());
		newProjectBtn.setHideActionText(true);
		newProjectBtn.addActionListener(new controller.NewProjectOW());
		JButton newPackageBtn = new JButton(new NewPackageOW());
		newPackageBtn.setHideActionText(true);
		newPackageBtn.addActionListener(new controller.NewPackageOW());
		JButton newClassBtn = new JButton(new NewClassOW());
		newClassBtn.setHideActionText(true);
		newClassBtn.addActionListener(new controller.NewClassOW());
		JButton newEnumBtn = new JButton("NewEnum");
		
		this.add(newProjectBtn);
		this.add(newPackageBtn);
		this.add(newClassBtn);
		this.add(newEnumBtn);
		
	}
	
}
