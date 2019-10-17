package windows.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import model.Model;
import model.Project;
import windows.TextEditor;

public class MainWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2552188593184181609L;
	
	private static MainWindow instance;
	private Model model;
	private NavigationBar navigationBar;

	public static MainWindow getInstance () {
	    if (MainWindow.instance == null) {
	      MainWindow.instance = new MainWindow();
	    }
	    return MainWindow.instance;
	}
	
	public MainWindow() {
		model = new Model();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.setTitle("CodeGenerator");
		this.setLayout(new BorderLayout());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(dim.width - 200, dim.height - 200));
		this.pack();
		MenuBar menuBar = new MenuBar();
		ToolBar toolBar = new ToolBar();
		navigationBar = new NavigationBar();
		StatusBar statusBar = new StatusBar();
		Workspace workspace = new Workspace();
		
		JSplitPane splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigationBar, workspace);
		splitPanel.setOneTouchExpandable(true);
		splitPanel.setDividerLocation(350);
		
		this.setJMenuBar(menuBar);
		this.add(toolBar,BorderLayout.NORTH);
		this.add(statusBar,BorderLayout.SOUTH);
		this.add(splitPanel,BorderLayout.CENTER);
		
		this.setMaximumSize(dim);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setVisible(true);
		
	}
	
	public Model getModel() {
		return model;
	}
	
	public NavigationBar getNavigationBar() {
		return navigationBar;
	}
}	
