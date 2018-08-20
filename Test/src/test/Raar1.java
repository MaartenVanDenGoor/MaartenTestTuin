package test;

public class Raar1 extends Raar {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Raar1 raar = new Raar1();
		int x = 1 + 2 *3;
		System.out.println("x="+x);
		double d = 0.1;
		double e = d+x;
		System.out.println("e="+e);
		byte f = 1;
		char c = '1';
		f =(byte) c;
		System.out.println("f="+f);
	}
	public Raar1() {
		super();
		System.out.println("Constructor Raar1");
		
	}
}
