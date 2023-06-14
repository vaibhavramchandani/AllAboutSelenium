package test;
import java.util.*; 
import java.io.FileInputStream;
import java.io.IOException;
public class testCase1 {
	public static void main(String args[]) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\object.properites");
		prop.load(fis);
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		System.out.println(System.getProperty("user.dir"));
	}
}
