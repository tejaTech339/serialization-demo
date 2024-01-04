package serialization.custom;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestAccount {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Account account1=new Account();
		System.out.println(account1.user+"--"+account1.password);
		
		FileOutputStream fos=new FileOutputStream("account.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(account1);
		
		FileInputStream fis=new FileInputStream("account.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Account account2 = (Account) ois.readObject();
		
		System.out.println(account2.user+"---"+account2.password);
	}
}
