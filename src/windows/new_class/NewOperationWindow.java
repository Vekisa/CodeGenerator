package windows.new_class;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewOperationWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6886496950805053857L;
	private static NewOperationWindow instance;
	private JTextField methodnName;
	
	@SuppressWarnings("deprecation")
	public static NewOperationWindow getInstance () {
	    if (NewOperationWindow.instance == null) {
	    	NewOperationWindow.instance = new NewOperationWindow();
	    }
	    NewOperationWindow.instance.show();
	    return NewOperationWindow.instance;
	}

	public NewOperationWindow() {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(300, 200));
		this.pack();
		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		this.setTitle("Operation");
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//detail of operations panel
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.LEFT));
		methodnName = new JTextField();
		methodnName.setToolTipText("Name of the method");
		Dimension fieldDimension = new Dimension(100,25);
		methodnName.setPreferredSize(fieldDimension);
		String[] list = {""};
		
		this.setVisible(true);	
	}
}
