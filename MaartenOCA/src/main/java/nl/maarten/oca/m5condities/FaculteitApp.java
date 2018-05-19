package nl.maarten.oca.m5condities;

public class FaculteitApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getFaculteit(3));
	

	}
	static long getFaculteit(int getal) {
		long resultaat = 1;
		while (getal >0 ) {
			resultaat *= getal;
			getal--;
		}
		return resultaat;
	}

}