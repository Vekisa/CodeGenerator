package windows.personalization;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

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
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		tabbedPane.addTab("Predefined", null, panel1, "Something");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		JLabel classesLabel = new JLabel("Classes");
		DefaultListModel<String> extendsModel = new DefaultListModel<>();
		JList<String> predefinedClasses = new JList<String>(extendsModel);
		predefinedClasses.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		predefinedClasses.setLayoutOrientation(JList.VERTICAL);
		predefinedClasses.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(predefinedClasses);
		listScroller.setPreferredSize(new Dimension(300, 150));
		JButton addClass = new JButton("Add");
		
		panel1.add(classesLabel);
		panel1.add(listScroller);
		panel1.add(addClass);
		
		//TAB 2
		JPanel panel2 = new JPanel();
		tabbedPane.addTab("Tab 2", null, panel2, "Does twice as much nothing");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		this.add(tabbedPane,BorderLayout.CENTER);
		this.setVisible(true);
	}
}
