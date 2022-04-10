import java.io.*;
import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		ArrayList <String> names = new ArrayList<String>();
		
		names.add("aaa");
		names.add("bbb");
		names.add("ccc");
		names.add("ddd");
		
		try {
			File f = new File("newFile.txt");
			FileWriter writer = new FileWriter(f);
			for(String n : names) {
				writer.write(n);
				writer.write(System.lineSeparator());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		new GUI();
	}

}
