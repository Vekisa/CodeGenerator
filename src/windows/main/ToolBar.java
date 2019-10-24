package windows.main;

import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.ow.NewClassOW;
import controller.ow.NewEnumOW;
import controller.ow.NewInterfaceOW;
import controller.ow.NewPackageOW;
import controller.ow.NewProjectOW;
import windows.InternalConfiguration;

public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1923088154892884764L;
	
	public ToolBar() {
		
		this.setBackground(InternalConfiguration.themeColorToolBar);
		
		JButton newProjectBtn = new JButton(new NewProjectOW());
		newProjectBtn.setHideActionText(true);
		
		JButton newPackageBtn = new JButton(new NewPackageOW());
		newPackageBtn.setHideActionText(true);
		
		JButton newClassBtn = new JButton(new NewClassOW());
		newClassBtn.setHideActionText(true);
		
		JButton newInterfaceBtn = new JButton(new NewInterfaceOW());
		newInterfaceBtn.setHideActionText(true);
	
		JButton newEnumBtn = new JButton(new NewEnumOW());
		newEnumBtn.setHideActionText(true);

		this.add(newProjectBtn);
		this.add(newPackageBtn);
		this.add(newClassBtn);
		this.add(newInterfaceBtn);
		this.add(newEnumBtn);
		
	}
	
}
