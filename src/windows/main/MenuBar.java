package windows.main;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.NewClassOW;
import controller.NewEnumOW;
import controller.NewPackageOW;
import controller.NewProjectOW;
import controller.open.CloseProject;
import controller.open.Open;
import controller.save.Save;
import controller.save.SaveAs;
import windows.InternalConfiguration;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2041014956312206381L;
	
	public MenuBar() {
		
		this.setBackground(InternalConfiguration.themeColor);
		
		JMenu files = new JMenu("File");
		
		JMenu newSubMenu = new JMenu("New");
		JMenuItem newProject = new JMenuItem(new NewProjectOW());
		JMenuItem newPackage = new JMenuItem(new NewPackageOW());
		JMenuItem newClass = new JMenuItem(new NewClassOW());
		JMenuItem newEnum = new JMenuItem(new NewEnumOW());
		
		JMenuItem open = new JMenuItem(new Open());
		JMenuItem saveAS = new JMenuItem(new SaveAs());
		JMenuItem save = new JMenuItem(new Save());
		
		newSubMenu.add(newProject);
		newSubMenu.add(newPackage);
		newSubMenu.add(newClass);
		newSubMenu.add(newEnum);
		
		JMenuItem closeProject = new JMenuItem(new CloseProject());
		
		JMenuItem exit = new JMenuItem("Exit");
		
		files.add(newSubMenu);
		files.add(open);
		files.add(save);
		files.add(saveAS);
		files.add(closeProject);
		files.add(exit);
		
		JMenu help = new JMenu("Help");
		
		newPackage.addActionListener(new NewPackageOW());
		newProject.addActionListener(new NewProjectOW());
		newClass.addActionListener(new NewClassOW());
		newEnum.addActionListener(new NewEnumOW());
		
		this.add(files);
		this.add(help);
	}
}
