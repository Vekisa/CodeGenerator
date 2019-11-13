package windows.new_interface;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JFrame;

public class NewMethodWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7389292506004714169L;
	private static NewMethodWindow instance;
	
	@SuppressWarnings("deprecation")
	public static NewMethodWindow getInstance() {
		if(NewMethodWindow.instance == null) {
			NewMethodWindow.instance = new NewMethodWindow();
		}
		NewMethodWindow.instance.show();
		return NewMethodWindow.instance;
	}
	
	public NewMethodWindow() {
		Box box = Box.createVerticalBox();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(550, 350));
		this.pack();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setTitle("Method");
	}
}
