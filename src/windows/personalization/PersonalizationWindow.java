package windows.personalization;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import windows.main.MainWindow;

public class PersonalizationWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3046554652875177529L;
	private static PersonalizationWindow instance;
	@SuppressWarnings("deprecation")
	public static PersonalizationWindow getInstance() {
		if(PersonalizationWindow.instance == null) {
			PersonalizationWindow.instance = new PersonalizationWindow();
		}
		PersonalizationWindow.instance.show();
		return PersonalizationWindow.instance;
	}

	public PersonalizationWindow() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(700, 700));
		this.pack();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Personalization");
		this.setLayout(new BorderLayout());
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		//PREDEFINED PANEL
		JPanel predefinedPanel = new JPanel();
		predefinedPanel.setLayout(new BorderLayout());
		JPanel classesPane = new JPanel();
		classesPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel interfacesPane = new JPanel();
		interfacesPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		predefinedPanel.add(classesPane, BorderLayout.NORTH);
		predefinedPanel.add(interfacesPane,BorderLayout.SOUTH);
		tabbedPane.addTab("Predefined", null, predefinedPanel, "Something");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		JLabel classesLabel = new JLabel("Classes");
		if(MainWindow.getInstance().getConfiguration().getExtendsModel() == null)
			MainWindow.getInstance().getConfiguration().setExtendsModel(new DefaultListModel<String>());
		JList<String> predefinedClasses = new JList<String>(MainWindow.getInstance().getConfiguration().getExtendsModel());
		predefinedClasses.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		predefinedClasses.setLayoutOrientation(JList.VERTICAL);
		predefinedClasses.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(predefinedClasses);
		listScroller.setPreferredSize(new Dimension(300, 150));
		JPanel addPanel = new JPanel();
		addPanel.setLayout(new BorderLayout());
		JTextField className = new JTextField();
		className.setPreferredSize(new Dimension(200,25));
		JButton removeClass = new JButton("Remove");
		removeClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(predefinedClasses.getSelectedIndex() != -1)
					MainWindow.getInstance().getConfiguration().getExtendsModel()
						.remove(predefinedClasses.getSelectedIndex());
				
			}
		});
		JButton addClass = new JButton("Add");
		addClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(className.getText() != "" && className.getText() != null && className.getText().length() > 0) {				
					MainWindow.getInstance().getConfiguration().getExtendsModel()
						.addElement(className.getText());
					className.setText("");
				}
			}
		});
		
		addPanel.add(className,BorderLayout.NORTH);
		addPanel.add(addClass,BorderLayout.CENTER);
		addPanel.add(removeClass,BorderLayout.SOUTH);
		
		JLabel interfacesLabel = new JLabel("Interfaces");
		if(MainWindow.getInstance().getConfiguration().getImplementsModel() == null)
			MainWindow.getInstance().getConfiguration().setImplementsModel(new DefaultListModel<String>());
		JList<String> predefinedInterfaces = new JList<String>(MainWindow.getInstance().getConfiguration().getImplementsModel());
		predefinedInterfaces.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		predefinedInterfaces.setLayoutOrientation(JList.VERTICAL);
		predefinedInterfaces.setVisibleRowCount(-1);
		JScrollPane listScrollerI = new JScrollPane(predefinedInterfaces);
		listScrollerI.setPreferredSize(new Dimension(300, 150));
		JPanel addPanelInterface = new JPanel();
		addPanelInterface.setLayout(new BorderLayout());
		JTextField interfaceName = new JTextField();
		interfaceName.setPreferredSize(new Dimension(200,25));
		JButton removeInterface = new JButton("Remove");
		removeInterface.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(predefinedInterfaces.getSelectedIndex() != -1)
					MainWindow.getInstance().getConfiguration().getImplementsModel()
						.remove(predefinedInterfaces.getSelectedIndex());
				
			}
		});
		JButton addInterface = new JButton("Add");
		addInterface.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(interfaceName.getText() != "" && interfaceName.getText() != null && interfaceName.getText().length() > 0) {
					MainWindow.getInstance().getConfiguration().getImplementsModel()
						.addElement(interfaceName.getText());
					interfaceName.setText("");
				}
			}
		});
		
		addPanelInterface.add(interfaceName,BorderLayout.NORTH);
		addPanelInterface.add(addInterface,BorderLayout.CENTER);
		addPanelInterface.add(removeInterface,BorderLayout.SOUTH);
		
		classesPane.add(classesLabel);
		classesPane.add(listScroller);
		classesPane.add(addPanel);
		
		interfacesPane.add(interfacesLabel);
		interfacesPane.add(listScrollerI);
		interfacesPane.add(addPanelInterface);
		
		//TAB 2
		JPanel panel2 = new JPanel();
		tabbedPane.addTab("Tab 2", null, panel2, "Does twice as much nothing");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		this.add(tabbedPane,BorderLayout.CENTER);
		this.setVisible(true);
	}
}
