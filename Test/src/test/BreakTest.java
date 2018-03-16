package test;

public class BreakTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		mijnLabel: for (;;) {
			while (true) {
				if (i == 1) {
				    System.out.println("Innerloop" );
				    break mijnLabel;
				}
			}
	//		System.out.println("Outerloop");
		}
		System.out.println("Klaar");
	}
}
