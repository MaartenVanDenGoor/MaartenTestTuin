package nl.maarten.oca.m4overerving;

public class Vormen {

	public static void main(String[] args) {
		Vorm v = new Cirkel(5);
		System.out.println(v);
		v = new Rechthoek(10,4);
		System.out.println(v);
        v = new Vierkant(3);
		System.out.println(v);
		

	}

}
abstract class Vorm{
	double omtrek;
	double getOmtrek() {
		return omtrek;
	};
	
}
class Cirkel extends Vorm {
	private double straal;
	public Cirkel(double straal) {
		super();
		this.straal = straal;
		this.omtrek = 2 * Math.PI * straal;
	}
	public String toString() {
		return "Circel met omtrek "+getOmtrek();
	}

}
class Rechthoek extends Vorm {
	private double breedte;
	private double hoogte;

	public Rechthoek(double breedte, double hoogte) {
		super();
		this.breedte = breedte;
		this.hoogte = hoogte;
		this.omtrek = 2 * (hoogte + breedte);
	}
	public String toString() {
		return "Rechthoek met omtrek "+getOmtrek();
	}	
}
class Vierkant extends Rechthoek {
	public Vierkant (double zijde) {
		super(zijde,zijde);
	}
	public String toString() {
		return "Vierkant met omtrek "+getOmtrek();
	}		
	
	
}