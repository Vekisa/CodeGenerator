package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Configuration;
import serialization.Serializer;
import windows.main.MainWindow;

public class WindowListener extends WindowAdapter {

	public void windowClosing(WindowEvent e) {
        System.out.println("Window closing event received");
        MainWindow.getInstance().getConfiguration().setLastProject(MainWindow.getInstance().getModel().getProject());  
        Serializer.serializeConfiguration(MainWindow.getInstance().getConfiguration());
    }
	
    public void windowOpened(WindowEvent e) {
    	System.out.println("Window opened event received");
    	Configuration config = Serializer.deserializeConfiguration();
    	MainWindow.getInstance().setConfiguration(config);
    	MainWindow.getInstance().getModel().setProject(config.getLastProject());
    }
}
