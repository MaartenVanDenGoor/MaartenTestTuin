package test;

public class PriemApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int beginGetal = Integer.parseInt(args[0]);
		int eindGetal = Integer.parseInt(args[1]);
		for (int i=beginGetal;i<=eindGetal;i++) {
			System.out.println(i+(isPriem(i)?" is een Priemgetal":" is GEEN Priemgetal"));
		}
		
	}
	public static boolean isPriem(int getal) {
		if (getal==1) return false;
		if (getal==2) return true;
		if (getal>2 && getal%2==0) return false;
		int i=3;
		while (i<Math.sqrt(getal)) {
			if (getal%i==0) return false;
			i+=2;
		}
		return true;
	}
}
