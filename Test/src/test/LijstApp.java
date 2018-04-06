package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class LijstApp {
	  static int teller=0;
	  public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	     test();
		String [] lijst = {"Dit","is","een","nieuwe","gewone","lijst"};
		Lijst  l = new Lijst(lijst);
		Iterator<String>  it = l.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		ArrayList<? extends Number> q = new ArrayList<>();
		
		//List <String> c = Arrays.asList("a","b","c");
		List <String> c = Arrays.asList(new String[] {"a","b","c"});
		for (String s:c) {
			System.out.println(s);
		}
		String[] p = c.toArray(new String[0]);
		OuterClas oc = new OuterClas();
		OuterClas.InnerClass ic = oc.new InnerClass();
		
	}
	  private static void test(){
		    try{
		    System.out.println("test heeft zichzelf "+ teller+" keer aangeroepen.");
		    teller++;
		    test();
		    }
		    catch(StackOverflowError soe){
		        System.err.println("StackOverflowError: test() is te diep genest.");
		    }
		  }
		  	
}
class Lijst implements Iterable<String> {
	
    private String[] lijst;
    private int grootte;
    //
    Lijst(String[] lijst){
    	this.lijst = lijst;
    	this.grootte = lijst.length;
    }
    
	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		Iterator<String> it = new Iterator<String>() {
			private int currentIndex = 0;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return currentIndex < grootte && lijst[currentIndex] != null;
			}

			@Override
			public String next() {
				// TODO Auto-generated method stub
				return lijst[currentIndex++];
			}
		};
		return it;
	}
}
class OuterClas {
	class InnerClass {
		
	}
}
