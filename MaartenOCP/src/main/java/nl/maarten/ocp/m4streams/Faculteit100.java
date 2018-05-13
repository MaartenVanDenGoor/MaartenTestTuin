package nl.maarten.ocp.m4streams;

import java.util.stream.*;
import java.math.*;

public class Faculteit100 {
	public static void main(String[] args) {
		String resultaat = IntStream.rangeClosed(1, 100)
                                    .parallel()
                                    .mapToObj(BigInteger::valueOf)
                                    .collect(MyBigInteger::new         //Supplier
                                            ,MyBigInteger::multiply    //Accumulator
                                            ,MyBigInteger::combine)    //combiner
                                    .toString();		
        System.out.println("resultaat "+resultaat);		
		System.out.println("faculteit "+faculteit(7));
	}
	public static long faculteit (long p) {
		if (p == 1) return 1;
		return p* faculteit(p-1); 
	}
}
class MyBigInteger {
	private BigInteger big = BigInteger.ONE;
	
	MyBigInteger () {
	}
	public void multiply (BigInteger p) {
		big = big.multiply(p);
	}
	public void combine (MyBigInteger p) {
		big = big.multiply(p.big);
	}
	public String toString() {
		return big.toString();
	}
}

/*
 * R collect​(Supplier supplier,
             BiConsumer accumulator,
             BiConsumer combiner)

Maak een applicatie die de faculteit van 100 berekent (1 * 2 * 3 … * 100). Maak daarbij gebruik van een 
parallelle stream en een zelf gemaakte Collector.

Tips:  

   Laat een IntStream lopen van 1 t/m 100  
   De faculteit van 100 is groter dan in een long past. Gebruik daarom binnen de collector een BigInteger 
   object om de waarde bij te houden (java.math.BigInteger).  
   Maak biinnen de stream gebruik van mapToObj om elke int naar een BigInteger om te zetten.  
   Toon uiteindelijk de berekende waarde als een String.
*/