package test;

public class CharApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i=32 ; i < 132 ; i+=10) {
			for (int j = i; j< i+10; j++) {
			System.out.print((char) j + " ");
			}
			System.out.print("\n");
		}
	}
	

}