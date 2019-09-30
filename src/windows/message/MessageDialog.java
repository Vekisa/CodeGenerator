package windows.message;

import javax.swing.JOptionPane;

public class MessageDialog {

	public static void showMessage(String text) {
		JOptionPane.showMessageDialog(null, text );
	}
}
