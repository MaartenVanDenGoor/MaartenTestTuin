package nl.maarten.oca.m5condities;

public class CharApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i=32 ; i < 132 ; i++) {
			System.out.print((char) i + " ");
			String s = Integer.toString(i);
			if (s.charAt(s.length()-1)=='1') {
				System.out.print("\n");
			}
		}
	}
	

}