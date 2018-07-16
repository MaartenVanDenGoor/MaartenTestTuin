package test;
import java.util.List;
import static java.util.Arrays.asList;  // static import

import java.io.IOException;
import java.util.ArrayList;
public class JavaImportStatic {
	public static void main(String[] args) {
		List<String> lijst = asList("Two");                      // Mag bij static import
		for (String s:lijst) {
			System.out.println(s);   // One
		}
		fly(1);
		}
	public static List<String> asList(String s){
		ArrayList<String> l = new ArrayList<String>();
		l.add("One");
		return l;
	}
//public static void fly(int parm) {
//	System.out.println("int");
//}
public static void fly(Object parm) {
	System.out.println("object");
}
public static void fly(int... parm) {
	System.out.println("int...");
}
//public static void fly(Integer parm) {
//	System.out.println("Integer");
//}
}
class Bunny {
	Bunny(int heigth) {
		this(heigth,"brown");  
	}   
	Bunny(int heigth, String  color){
	}
}