package windows.main;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import windows.TextEditor;

public class Workspace extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3172249468615491293L;
	
	public Workspace() {
		this.setLayout(new BorderLayout());
	}
	
	public void showItem(String text) {
		TextEditor textEditor = new TextEditor();
		textEditor.setText(text);
		this.removeAll();
		this.add(textEditor,BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}

}
