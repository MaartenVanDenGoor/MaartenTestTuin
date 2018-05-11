package nl.maarten.ocp.m4streams;
import java.util.stream.*;
import static java.lang.Math.sqrt;

public class PriemApp {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
	   	LongStream.range(2, n)
	   	          .filter(x -> LongStream.rangeClosed(2, (long) sqrt(x)).noneMatch(y -> x%y==0))
	   	          .filter(x -> x!=2)
	   	          .filter(x -> x!=n-1)
	   	          .forEach(System.out::println);
	   	        		  
	}
}
/*
Maak een LongStream getallen vanaf 2 (het eerste priemgetal), die steeds met 1 wordt opgehoogd.  
Start in een filter voor elk gegenereerd getal x een nieuwe LongStream vanaf 2 tot en met de wortel van x 
(LongStream.rangeClosed). 
De filter geeft true als x door geen van de getallen van deze stream deelbaar is, en als x zelf geen 2 is. 
Gebruik hierbij de method noneMatch().  
Limiteer het aantal priemgetallen tot n  
Sla n-1 priemgetallen over
*/