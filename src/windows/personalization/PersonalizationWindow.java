package windows.personalization;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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
		
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("Tab 1", null, panel1,
		                  "Does nothing");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JPanel panel2 = new JPanel();
		tabbedPane.addTab("Tab 2", null, panel2,
		                  "Does twice as much nothing");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		this.add(tabbedPane,BorderLayout.CENTER);
		this.setVisible(true);
	}
}
