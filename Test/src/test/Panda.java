package test;

public class Panda extends Beer {
	public String naam = "Panda";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Beer b = new Beer();
		System.out.println(b.naam);  // Beer
		Panda p = new Panda();
		System.out.println(p.naam);  // Panda
		b=p;
		System.out.println(b.naam);  // Beer
		//
		p.toonNaamPanda();           // Panda
		p.toonNaamBeer();            // Beer
		p.toonNaamSuper();
	}  
	public void toonNaamPanda() {
		System.out.println(naam);
	}
	public void toonNaamSuper() {
		System.out.println(super.naam);
	}
}
/*
Panda is eating
Bear is eating
Bear is eating
Bear is eating
*/