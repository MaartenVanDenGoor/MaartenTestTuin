package test;

class Papa {
	public int variabele = 1;
	public static void toon() {
		System.out.println("toon papa");
	}
}
public class HideClass extends Papa {
	public int variabele = 2;
	public static void main (String[] args ) {
		Papa papa = new HideClass();
		System.out.println(papa.variabele); // 1
		papa.toon();
		HideClass  hc = (HideClass) papa;
		System.out.println(hc.variabele); // 2
		hc.toon();
		
	}
	public static  void toon() {
		System.out.println("toon son");
	}
}
