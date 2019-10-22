import javax.swing.UIManager;

import windows.main.MainWindow;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels(); 
        for (UIManager.LookAndFeelInfo look : looks) { 
            System.out.println(look.getClassName()); 
        } 
        
        try { 
        	  
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } 
        catch (Exception e) { 
            System.out.println("Look and Feel problem"); 
        } 
        
        MainWindow.getInstance();
	}

}
