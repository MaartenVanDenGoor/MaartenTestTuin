package test;
class Mammal {
	public Mammal(int age) {
		System.out.print("Mammal");
	}
}
public class Platypus extends Mammal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Mammal(5);
	}
	public Platypus() {
		super(5);
		System.out.print("Platypus");		
	}
}
