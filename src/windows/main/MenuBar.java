package windows.main;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.FileChooser;
import controller.NewClassOW;
import controller.NewPackageOW;
import controller.NewProjectOW;
import windows.Configuration;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2041014956312206381L;
	
	public MenuBar() {
		
		this.setBackground(Configuration.themeColor);
		
		JMenu files = new JMenu("File");
		
		
		JMenu newSubMenu = new JMenu("New");
		JMenuItem newProject = new JMenuItem(new NewProjectOW());
		JMenuItem newPackage = new JMenuItem(new NewPackageOW());
		JMenuItem newClass = new JMenuItem(new NewClassOW());
		JMenuItem newEnum = new JMenuItem("Enum");
		
		JMenuItem open = new JMenuItem(new FileChooser());
		
		newSubMenu.add(newProject);
		newSubMenu.add(newPackage);
		newSubMenu.add(newClass);
		newSubMenu.add(newEnum);
		
		JMenuItem exit = new JMenuItem("Exit");
		
		files.add(newSubMenu);
		files.add(open);
		files.add(exit);
		
		JMenu help = new JMenu("Help");
		
		newPackage.addActionListener(new NewPackageOW());
		newProject.addActionListener(new NewProjectOW());
		newClass.addActionListener(new NewClassOW());
		
		this.add(files);
		this.add(help);
	}
}
