package test;

import java.util.ArrayList;

public class SwitchSample {
	public static void main(String[] args) {
		FIRST_CHAR_LOOP: 
		for (int a = 1; a <= 4; a++) {
			for (char x = 'a'; x <= 'c'; x++) {
				if (a == 2 || x == 'b')
					continue FIRST_CHAR_LOOP;
				System.out.print(" " + a + x);
			}
		}
	System.out.println();
	System.out.println(1 + 2 + "3") ;
	StringBuilder sb = new StringBuilder("Dit is een nieuwe sb");
	System.out.println(sb);
	StringBuilder sb2 = sb.insert(0, "Voor");
	System.out.println("sb  "+sb);
	System.out.println("sb2 "+sb2);
	int numbers[] = new int[3];
	int[] lijst = {1,2,3,8,9};
	System.out.println("lijst "+lijst.length);
	ArrayList<Integer> alijst = new ArrayList<>();
	alijst.add(1);
	alijst.add(4);
	System.out.println("alijst "+alijst.size());
	int i = Integer.parseInt("1");
	Integer inti = Integer.valueOf(1);
    Double d;
    d = 10d;                    // AutoBoxing
    d = new Double(50d);
    d = Double.valueOf(50);
    System.out.println("d="+d);
	}
}
