package test;

import java.math.BigDecimal;

public class Telop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        if (args.length < 2) {
        	System.out.println("Minimaal 2 argumenten meegeven");
        } else {
        	// Dit levert dus niet het goede resultaat op, blijft bizar
        	double d = Double.parseDouble(args[0])+Double.parseDouble(args[1]);
        	System.out.println("Resultaat double= "+d);
        	// Dit levert dus niet het goede resultaat op, blijft bizar
        	BigDecimal bd1 = new BigDecimal(Double.parseDouble(args[0]));
        	BigDecimal bd2 = new BigDecimal(Double.parseDouble(args[1]));
        	BigDecimal bd3 = bd1.add(bd2);
        	System.out.println("Resultaat BigDecimal= "+bd3);  
        	// 
        	int een  = (int) (Double.parseDouble(args[0]) * 10);
        	int twee = (int) (Double.parseDouble(args[1]) * 10);
        	double resultaat = (een + twee) /10D;
        	System.out.println("Resultaat int= "+ resultaat);  
            //
            float a = Float.parseFloat(args[0]); 
            float b = Float.parseFloat(args[1]); 
            float uitkomst = a+b; 
            System.out.println("Float "+a + " + " + b + " = " + uitkomst); 

        	}

	}

}
