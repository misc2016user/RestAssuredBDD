package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//IMPLEMENTS SERIALIZABLE IS REQUIRED
class Test implements Serializable{
	int i=10;
	int j=20;
}

public class Serialization_Deserialization {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Test t1= new Test();
		
		//SERIALIZATION
		FileOutputStream fos= new FileOutputStream("test.txt"); // A txt file named test.txt will be displayed in the exlipse project
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(t1);
				
		//DESERIALIZATION
		FileInputStream fis= new FileInputStream("test.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Test t2= (Test)ois.readObject();
		System.out.println("Deserialization::"+t2.i+ "  "+t2.j);
		
	}

}
