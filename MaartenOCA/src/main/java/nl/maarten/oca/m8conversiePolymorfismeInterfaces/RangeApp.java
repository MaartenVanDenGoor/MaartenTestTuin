package nl.maarten.oca.m8conversiePolymorfismeInterfaces;

public class RangeApp  {
	  public static void main(String args[]){
	      Fahrenheit f = new Fahrenheit(96);
	      System.out.println(f.pctInRange());
	      System.out.println(f.getCelsius());

	  }
	}