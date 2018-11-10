package test;
import java.util.List;
//import static java.util.Arrays; // does not compile, geen methodenaam
import static java.util.Arrays.asList;  // static import
import java.util.Arrays;   // moet als je  Arrays.asList gebruikt

public class ImportStatic {
	public static void main(String[] args) {
		Paps p = new Zoon();
		try {
			p.m1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //  moet try /  catch om !!
		
		int [] l = new int[10];
	}  
}
class Paps {
	public void m1() throws Exception {
		throw new Exception();
	}
}
class Zoon extends Paps {
	public void m1() {}
}
