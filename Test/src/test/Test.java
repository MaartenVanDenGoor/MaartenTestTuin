package test;

import java.util.function.Function;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println("Hello World!");
       Maat kledingmaat = Maat.XL; 
       System.out.println("Maat is : "+kledingmaat);  
       int miljoen = 1_000_000_000;
       System.out.println("miljoen "+miljoen);
       int verschil = Math.abs(6-9);
       System.out.println("verschil "+verschil);
       long uitkomst = Math.round(3.5d);
       System.out.println("uitkomst "+uitkomst);
       //
       
       Test test = new Test();
       test.doeIets(new Integer(1),new Integer(1));
       int a, b, c = 10;
       a = 1;
       a += b = 3;
       System.out.println("a "+a+" b "+b);
       a = ++b;
       System.out.println("a "+a+" b "+b);
       int y, x=1;
       y=x++;
       System.out.println(" x="+x+" y="+y);
       /*
       String s = "Dit Is Een String";
       System.out.println(testFunction(s,a -> a.toUpperCase()));
       System.out.println(testFunction(s,String::toUpperCase));
       */ 
       String ss = "ss";
       String bb = "ss";
       switch (ss) {
       case "aa": System.out.println("1"); break;
       case "ss":System.out.println("2"); 
       default: System.out.println("Default");
       }
	}
    public void doeIets() {
    	
    }
    public void doeIets(Integer... list) {
    	System.out.println("de lijst");
    }
    public void doeIets(Integer een) {
    	System.out.println("De een");
    }
    public static String testFunction(String s, Function<String, String> f) {
    	return f.apply(s);
    }

}

