package nl.maarten.oca.m2datatypen;

public class TestApplicatie
{
	final static double EURO = 2.20371;
  public static void main(String args[])
  {
      // Regels die beginnen met // zijn commentaar. 
      // Schrijf hieronder de code die moet worden uitgevoerd.
      // Een variabele kan als volgt op het scherm worden getoond:
      // System.out.println(variabele);  
      double zak = 2.25;
      System.out.println("Zak appels kost in guldens "+(zak/TestApplicatie.EURO));
      //
      int lengte=20 , breedte=10 , hoogte=10;
      System.out.println("Inhoud kubus = "+inhoud(lengte,hoogte,breedte));      
      System.out.println("En de worp is "+gooiDobbelsteen());
  
  }

static double inhoud(int b, int h, int d){
   return b * h * d;
}
static int gooiDobbelsteen() {
	  return  (int) (6.0 * Math.random()) + 1;
}
}