package windows.new_class;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;

public class NewAttributeWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8957473323992016134L;
	private static NewAttributeWindow instance;
	
	@SuppressWarnings("deprecation")
	public static NewAttributeWindow getInstance () {
	    if (NewAttributeWindow.instance == null) {
	    	NewAttributeWindow.instance = new NewAttributeWindow();
	    }
	    NewAttributeWindow.instance.show();
	    return NewAttributeWindow.instance;
	}

	public NewAttributeWindow() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(300, 200));
		this.pack();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Attribute");
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.setVisible(true);	
	}
}
