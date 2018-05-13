package nl.maarten.ocp.m4streams;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;
import java.math.*;

public class Faculteit100 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collector<BigInteger, BigInteger, BigInteger> factCollector =
			    Collector.of(() -> BigInteger.ONE              // supplier
			                ,(x, y) -> x.multiply(y)           // accumulator
			                ,(x2, y2) -> x2.multiply(y2));       // combiner
			                //,BigInteger::toString);            // finisher
	    /*
		
		String resultaat = IntStream.rangeClosed(1, 100)
				                 .parallel()
				                 .mapToObj(BigInteger::valueOf)
				                 .collect(() -> BigInteger.ONE   //Supplier
				                         ,BigInteger::multiply   //Accumulator
				                         ,BigInteger::multiply)  //combiner
    			                 .toString();
		System.out.println(resultaat);
		String resultaat = IntStream.rangeClosed(1, 7)
                .parallel()
                .mapToObj(MyBigInteger::new)
                .collect(MyBigInteger::new  //Supplier
                        ,(a, b) -> a.set(b.get())  //Accumulator
                        ,(a, b) -> a.multiply(b))  //combiner
                .toString();
		*/		
		String resultaat = IntStream.rangeClosed(1, 17)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .collect(MyBigInteger::new  //Supplier
                        ,MyBigInteger::add  //Accumulator
                        ,MyBigInteger::multiply)  //combiner
                .toString();		
        System.out.println("resultaat "+resultaat);		
		System.out.println("faculteit "+faculteit(7));
       /*
        BigInteger res = IntStream.rangeClosed(1, 100)
                           //  .parallel()
                             .mapToObj(BigInteger::valueOf)
                             .collect(factCollector);		

		System.out.println(res);

		BigInteger big = BigInteger.valueOf(3);
		System.out.println(big);
		big.multiply(BigInteger.valueOf(3));
		System.out.println(big);
		resultaat = IntStream.rangeClosed(1, 5)
                             .collect(() -> Integer(0)   //Supplier
                                     ,(x,y) -> x*y      //Accumulator
                                     ,(x,y) -> x*y )  //combiner		
        System.out.println(resultaat);                
        */
	}
	public static long faculteit (long p) {
		if (p == 1) return 1;
		return p* faculteit(p-1); 
	}
}
class MyBigInteger {
	private BigInteger big = BigInteger.ZERO;
	
	MyBigInteger () {
	}
	public void add (BigInteger p) {
		big = big.add(p);
	}
	public void multiply (MyBigInteger p) {
		System.out.println(big + " * " + p);
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