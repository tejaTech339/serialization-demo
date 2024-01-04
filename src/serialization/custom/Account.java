package serialization.custom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String user="Teja";
	transient String password="tej339@";
	
	private void writeObject(ObjectOutputStream output) throws IOException {
		
		output.defaultWriteObject();// this method meant for default Serialization
		String enPassword="123"+password;//like encryption
		output.writeObject(enPassword);
	}
	
	private void readObject(ObjectInputStream input) throws ClassNotFoundException, IOException {
		
		input.defaultReadObject();// this method meant for default DeSerialization
		String readObject = (String) input.readObject();
		password=readObject.substring(3);// like decryption
	}
}
