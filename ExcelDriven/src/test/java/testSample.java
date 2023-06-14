import java.io.IOException;
import java.util.ArrayList;

public class testSample {
	public static void main(String[] args) throws IOException {
		dataDriven d=new dataDriven();
		ArrayList<String>l=d.getData("login");
		System.out.println(l.get(0));
		System.out.println(l.get(1));
		System.out.println(l.get(2));
		System.out.println(l.get(3));
	} 
}
