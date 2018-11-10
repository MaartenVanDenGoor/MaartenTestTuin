package test;

import java.util.ArrayList;
import java.util.Arrays;

public class InstatClass {

	public static void main(String[] args) {
		InstatClass ic = new InstatClass();
		char c = 'a';
	    byte b = 1;
		int resultaat = b * c;
		System.out.println("resultaat"+resultaat);
		String[] lijstje = {"aa","bb","cc"};
		ArrayList<String>lijst = new ArrayList<>(Arrays.asList(lijstje));


	}
	public static int geefWaarde(int waarde) {
		System.out.println(waarde);
		return waarde;
		
	}
	static {
		twee = geefWaarde(2);
	}
	{
		int drie = geefWaarde(3);
	}
	public InstatClass() {
		int vier = geefWaarde(4);
	}
	static int een = geefWaarde(1);
	static int twee;
	int acht;
}
