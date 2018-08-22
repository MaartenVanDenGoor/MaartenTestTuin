package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.Arrays.*;

class Mammal {
	public Mammal(int age) {
		System.out.println("Mammal");
	}
}
public class Platypus extends Mammal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Mammal(5);
		int x = 1;
		x = --x;
		System.out.println("x="+x);
		MIJLABEL:
		if (x==0) {
			break MIJLABEL;
		}
		int w=2;
		 System.out.println(w>1? w>2? "dit":"mag":"dus");
		int i = 3;
		switch (i) {
		default:
			System.out.println("default");
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");

		}
		double d = Double.valueOf("50D");
		System.out.println("d="+d);
		
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		//
		String[] array = { "hawk", "robin" };
        List<String> list = Arrays.asList(array);
     //   list.add("sparrow");
        int[] lijst = {1,2,3,5};
        lijst = new int[] {1,2,3,4};
        walk(1, new int[5]);
        //
        List<String> lijstje = asList("Two");  // static import
        Object obj = new Integer(3);
        String str = (String) obj;
        System.out.println(str);
        //
        try {
        	System.out.println("work real hard");
        	} catch ( StackOverflowError
        	e) {
        	} catch (RuntimeException e) {
        	}
        
	}
	public Platypus() {
		super(5);
		System.out.println("Platypus");		
	}
	public static void walk(int ia, int...inums) {
	}
}
