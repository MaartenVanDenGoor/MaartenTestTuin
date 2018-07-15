package test;
import java.util.List;
import static java.util.Arrays.asList;  // static import
import java.util.ArrayList;
public class JavaImportStatic {
	public static void main(String[] args) {
		List<String> lijst = asList("Two");                      // Mag bij static import
		for (String s:lijst) {
			System.out.println(s);   // One
		}
		}
	public static List<String> asList(String s){
		ArrayList<String> l = new ArrayList<String>();
		l.add("One");
		return l;
	}
}