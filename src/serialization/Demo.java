package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Demo {

	/*
	 * Serialization: (Saving State of an Object into a file)
	 * =============
	 * The process of converting Object from java supported form to
	 * File supported form or Network supported form is called Serialization.
	 * 
	 * Steps to achieve :
	 * ----------------
	 * 1.File Output Stream 
	 * 2.Object Output Stream
	 * 
	 * DeSerialization:
	 * =============== 
	 * The process of reading/ converting File or Network supported
	 * form into java supported form is called DeSerialization.
	 * 
	 * Steps to achieve :
	 * ---------------- 
	 * 1.File Input Stream 
	 * 2.Object Input Stream
	 * 
	 * NOTE: 
	 * > We can perform Serialization only on serialized objects 
	 * > if we trying to perform on non-serialized objects 
	 *   at compile time no problem 
	 *   but at runtime we can get java.io.NotSerializableException. 
	 *   
	 * > To overcome this class must implements Serializable interface.
	 * 
	 * 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Dog dog1 = new Dog();

		// Performing Serialization
		FileOutputStream fos = new FileOutputStream("dog.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(dog1);

		// Performing DeSerialization:
		FileInputStream fis = new FileInputStream("dog.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Dog dog2 = (Dog) ois.readObject();
		
		System.out.println("Name is :"+dog2.name + " \n" +"Breed is :"+dog2.breed);
	}
}

class Dog implements Serializable {

	String name = "tommy";
	String breed = "german";
}
