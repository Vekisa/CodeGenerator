import javax.swing.UIManager;

import model.Project;
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
            System.out.println("Look and Feel not set"); 
        } 
        
        MainWindow mainWindow = MainWindow.getInstance();
		/*Project p = new Project("Project");
		model.Package p1 = new model.Package("Package");
		p1.addChild(new model.Package("Class"));
		p.addChild(p1);
		p.addChild(new model.Package("Package2"));
		MainWindow.getInstance().getModel().setProject(p);*/
	}

}
