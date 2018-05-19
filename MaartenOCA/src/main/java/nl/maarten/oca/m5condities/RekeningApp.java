package nl.maarten.oca.m5condities;

public class RekeningApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if ( geldigRekeningNummer(args[0])) {
			System.out.println(args[0]+" is een geldig rekeningnummer");
		} else {
			System.out.println(args[0]+" is GEEN geldig rekeningnummer");
		}

	}
    public static boolean geldigRekeningNummer(String rekening) {
    	//
    	// Geen 9 cijfers dan fout
    	if (rekening.length()!=9 ) {
    		return false;
    	}
    	// 11-proef
    	int som = 0;
    	for (int i=0, j=9;i<9;i++, j--) {
    		som += Integer.parseInt(rekening.substring(i, i+1)) * j;
    	}
    	if (som%11 == 0) {
    		return true;
    	}
    	return false; 
    }
}