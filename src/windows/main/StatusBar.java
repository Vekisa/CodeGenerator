package windows.main;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import windows.InternalConfiguration;

public class StatusBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1213693678886950742L;
	
	public StatusBar() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel path = new JLabel("D:/dasdsa/nesto/dsadsadsa");
		this.setBackground(InternalConfiguration.themeColor);
		this.add(path);
	}

}
