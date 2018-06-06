package nl.maarten.oca.m6packagesandmodifiers;

public class BankRekening {
	final private int rekeningnummer;
	private float saldo;

	public BankRekening() {
		rekeningnummer = 12345678;
	}
	public int getRekeningnummer() {
		return rekeningnummer;
	}
	public void stort(float bedrag) {
		if (saldo + bedrag >= 0) {
			saldo = saldo + bedrag;
		}
	}
	public float getSaldo() {
		return saldo;
	}
}
class BankApp {
	public static void main(String args[]) {
		BankRekening rekening = new BankRekening();
		rekening.stort(150);
		rekening.stort(-80);
		rekening.stort(-100);
		System.out.println(rekening.getRekeningnummer());
		System.out.println(rekening.getSaldo());
	}
}
