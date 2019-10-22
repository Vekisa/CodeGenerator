package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Configuration;
import windows.InternalConfiguration;

public class Serializer {
	
	public static void serialize(model.Project proj, String path) {
		try {    
            FileOutputStream file = new FileOutputStream(path + ".cg"); 
            ObjectOutputStream out = new ObjectOutputStream(file);  
            out.writeObject(proj); 
            out.close(); 
            file.close(); 
            System.out.println("Object has been serialized"); 
        }catch(IOException ex) { 
            System.out.println("IOException is caught"); 
            ex.printStackTrace();
        } 
	}
	
	public static model.Project deserialize(String path) {
		model.Project proj = null;
		try {    
            FileInputStream file = new FileInputStream(path); 
            ObjectInputStream in = new ObjectInputStream(file); 
            proj = (model.Project)in.readObject(); 
            in.close(); 
            file.close(); 
            System.out.println("Object has been deserialized "); 
        } catch(IOException ex) { 
            System.out.println("IOException is caught"); 
        } catch(ClassNotFoundException ex) { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
		
		return proj;
	}
	
	public static void serializeConfiguration(Configuration conf) {
		try {    
            FileOutputStream file = new FileOutputStream(InternalConfiguration.currentPath + "/config.config"); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
            out.writeObject(conf); 
            out.close(); 
            file.close();   
            System.out.println("Configuration has been serialized"); 
        } catch(IOException ex) { 
            System.out.println("IOException is caught"); 
            ex.printStackTrace();
        } 
	}
	
	public static Configuration deserializeConfiguration() {
		Configuration config = null;
		try {    
            FileInputStream file = new FileInputStream(InternalConfiguration.currentPath + "/config.config"); 
            ObjectInputStream in = new ObjectInputStream(file); 
            config = (Configuration)in.readObject(); 
            in.close(); 
            file.close(); 
            System.out.println("Object has been deserialized "); 
        } catch(IOException ex) { 
            System.out.println("IOException is caught"); 
        } catch(ClassNotFoundException ex) { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
		return config;
			
	}
}
