package test;

public class Vlucht {
    int aantalStoelen = 150;
	public int getAantalStoelen() {
		return aantalStoelen;
	}
	public void setAantalStoelen(int aantalStoelen) {
		this.aantalStoelen = aantalStoelen;
	}
	private void start() {
		
	}
	private void start(int snelheid) {
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Vlucht v = new VrachtVlucht();
//		System.out.println(v.getAantalStoelen());
//		System.out.println(v.aantalStoelen);
//		VrachtVlucht vv = new VrachtVlucht();
//		System.out.println(vv.getAantalStoelen());
//		System.out.println(vv.aantalStoelen);
		
		int i = 4;
		switch (i) {
		case 1:System.out.println(i);
		case 2:System.out.println(i);
		case 3:System.out.println(i);
		case 4:System.out.println(i);break;
		case 5:System.out.println(i);
		case 6:System.out.println(i);
		
		}

	}
}
class VrachtVlucht extends Vlucht {
	 int aantalStoelen = 50;
	 @Override
	public int getAantalStoelen() {
		return super.aantalStoelen;
	}
 
}
