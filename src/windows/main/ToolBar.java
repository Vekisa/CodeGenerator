package windows.main;

import javax.swing.JButton;
import javax.swing.JToolBar;
import windows.Configuration;

public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1923088154892884764L;
	
	public ToolBar() {
		
		this.setBackground(Configuration.themeColorToolBar);
		
		JButton newProjectBtn = new JButton("NewProject");
		newProjectBtn.addActionListener(new controller.NewProjectOW());
		JButton newPackageBtn = new JButton("NewPackage");
		newPackageBtn.addActionListener(new controller.NewPackageOW());
		JButton newClassBtn = new JButton("NewClass");
		newClassBtn.addActionListener(new controller.NewClassOW());
		JButton newEnumBtn = new JButton("NewEnum");
		
		this.add(newProjectBtn);
		this.add(newPackageBtn);
		this.add(newClassBtn);
		this.add(newEnumBtn);
		
	}
	
}
