package test;

import java.util.ArrayList;
import java.util.List;

public class Primitives {
	static char cc;
	public static void main (String[] args) {
		byte b = 1;
		short s = 1;
		int i = 1;
		long l = 1;
		char c = 1;
		if (b==s) System.out.println("b==s");
		if (i==l) System.out.println("i==l");
		if (b==c) System.out.println("b==c");
	    else System.out.println("b!=c");
		c++;
		System.out.println("c= "+c);
		String st = null;
		if (!(st instanceof String) )System.out.println("st instanceof String is false");
		st = "tekst";
		if (st instanceof String) System.out.println("st instanceof String is true");
		boolean bool = true;
		System.out.println(bool? null:doeIets(2));

		System.out.println(getVal(1));
		int k = 1;
		k += 3 + k++;
		System.out.println("k="+k);
		k = 1;
		k = k + 3 + (++k); // k = 1 + 3 + (2)
		System.out.println("k="+k);
		
        List lijst = new ArrayList();
        lijst.add("nul");
        lijst.add(1,"een");
        lijst.add(1,"twee");
        lijst.add(3,"drie");
        lijst.add(4,"vijf");
        lijst.stream().forEach(System.out::println);
        System.out.println("cc"+cc);
        System.out.println("(int)cc"+((int)cc));
        int ii = 'a';
        double dd = (long) 1 / 2D;
        System.out.println(dd);

        
        char ci;
        for (ci=0;ci<5;ci++) {
        	System.out.println("ci "+ci);
        }
        short sh = 1;
        int a = 'a';
        System.out.println("a="+a);
        }
	public static void doeNiets() {
		
	}
	public static int doeIets(int x) {
		return x;
		
	}
	public static int getVal(int i) {
		return i++;
	}
}
