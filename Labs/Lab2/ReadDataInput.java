package Lab2;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataInput {
	public static void main(String[] args) throws IOException {
		/* Establishing streams */
		//File file = new File("persondata.dat");
		FileInputStream fileInputStream = new FileInputStream("persondata.dat");
		DataInputStream in = new DataInputStream(fileInputStream);
		
		/* Fetching all primitive types 
		 * Storing it back into person object */
		Person2 person2 = new Person2(in.readInt(), in.readInt(), in.readFloat());
		in.close();
		
		
		
		System.out.println("Person2: "+person2);
	}
}
