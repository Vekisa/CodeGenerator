package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
	
	public static void serialize(model.Project proj, String path) {
		try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(path + ".cg"); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(proj); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
            ex.printStackTrace();
        } 
	}
	
	public static model.Project deserialize(String path) {
		model.Project proj = null;
		try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(path); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            proj = (model.Project)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
            System.out.println("Object has been deserialized "); 
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
		
		return proj;
	}
}
