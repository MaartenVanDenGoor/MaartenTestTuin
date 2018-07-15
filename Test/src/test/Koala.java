package test;

import java.util.List;
//import static java.util.Arrays; // does not compile, geen methodenaam
import static java.util.Arrays.asList;  // static import

import java.util.ArrayList;
//import java.util.Arrays;   // moet apart genoemd
class test {
	public static void main(String[] args) {
	//	List<String> lijst = Arrays.asList("one");  // Mag altijd
		List<String> lijst = asList("Two");                      // Mag bij static import
		for (String s:lijst) {
			System.out.println(s);
		}
		}
	public static List<String> asList(String s){
		ArrayList<String> l = new ArrayList<String>();
		l.add("One");
		return l;
	}
}
public class Koala {
	public static int count=0;
	public final static  int een;
	public static final  int twee = 2;
	public final static int drie = 3;
	public final int vijf;
	public final int zes = 6;
	public final int zeven ;
	static {
		een = 1;
	}
	{ vijf = 5;
	zeven = 7;
	}
}
