package test;

public class While {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int teller = 1;
		do {
			System.out.println("teller = " + teller);
			teller++;
		} while (teller <= 10);
		//
		for (int i = 1; i <= 10; i++) {
			System.out.println("De waarde van i is " + i);
		}
		teller = 1;
		INNERLOOP:
		while(teller < 10) {
			teller++;
			System.out.println("INNERLOOP teller = " + teller);
			continue INNERLOOP;
			
		}
		IFLOOP:
		if ( teller==2) {
			break IFLOOP;
		}
	}
}
