package nl.maarten.oca.m4overerving;

public class VormenApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rechthoeka r= new Rechthoeka();
		r.setHoogte(2.1);
		r.setBreedte(3.5);
		System.out.println(r);
	}

}
abstract class Vorma{
	public abstract double getOmtrek();
}
class Cirkela extends Vorma {
	private double straal;
	public Cirkela(double straal) {
		super();
		this.straal = straal;
	}
	public String toString() {
		return "Circel met omtrek "+getOmtrek();
	}
	public double getOmtrek() {
		return 2 * Math.PI * straal;
	}

}
class Rechthoeka extends Vorma {
	private double breedte;
	private double hoogte;

	public Rechthoeka() {
		super();
	}
	public double getBreedte() {
		return breedte;
	}
	public void setBreedte(double breedte) {
		this.breedte = breedte;
	}
	public double getHoogte() {
		return hoogte;
	}
	public void setHoogte(double hoogte) {
		this.hoogte = hoogte;
	}
	public String toString() {
		return "Rechthoek ("+hoogte+"x"+breedte+") met omtrek "+getOmtrek();
	}	
	public double getOmtrek() {
		return 2 * (hoogte+breedte);
	}	
}
class Vierkanta extends Rechthoeka {
	public Vierkanta (double zijde) {
		super();
		setHoogte(zijde);
		setBreedte(zijde);
	}
	public String toString() {
		return "Vierkant met omtrek "+getOmtrek();
	}		
	
	
}