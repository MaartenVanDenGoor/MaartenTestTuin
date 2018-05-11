package nl.maarten.ocp.m4streams;

import java.util.stream.*;
import java.math.*;

public class Faculteit100 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collector<BigInteger, BigInteger, String> factCollector =
			    Collector.of(() -> BigInteger.ONE              // supplier
			                ,(x, y) -> x.multiply(y)           // accumulator
			                ,(x2, y2) -> x2.multiply(y2)       // combiner
			                ,BigInteger::toString);            // finisher
	
		
		String resultaat = IntStream.rangeClosed(1, 100)
				                 .parallel()
				                 .mapToObj(BigInteger::valueOf)
				                 .collect(() -> BigInteger.ONE   //Supplier
				                         ,BigInteger::multiply   //Accumulator
				                         ,BigInteger::multiply)  //combiner
    			                 .toString();
        resultaat = IntStream.rangeClosed(1, 100)
                             .parallel()
                             .mapToObj(BigInteger::valueOf)
                             .collect(factCollector);		

		System.out.println(resultaat);

	}
}
/*
Maak een applicatie die de faculteit van 100 berekent (1 * 2 * 3 … * 100). Maak daarbij gebruik van een 
parallelle stream en een zelf gemaakte Collector.

Tips:  

   Laat een IntStream lopen van 1 t/m 100  
   De faculteit van 100 is groter dan in een long past. Gebruik daarom binnen de collector een BigInteger 
   object om de waarde bij te houden (java.math.BigInteger).  
   Maak biinnen de stream gebruik van mapToObj om elke int naar een BigInteger om te zetten.  
   Toon uiteindelijk de berekende waarde als een String.
*/