package test;

import java.util.ArrayList;

class TestApplicatie
{
  public static void main(String args[])
  {
      int lengte=20 , breedte=10 , hoogte=10;
      System.out.println("Inhoud kubus = "+inhoud(hoogte,lengte,breedte));
      System.out.println("En de worp is "+gooiDobbelsteen());
      String tst = "Dit is een vraag";
      
      tst = tst.substring(tst.indexOf("Dit is"));
      System.out.println(tst);
  
  }	
  static int inhoud(int hoogte,int lengte, int breedte) {
  	   return lengte*hoogte*breedte;
  }
  static int gooiDobbelsteen() {
	  return  (int) (6.0 * Math.random()) + 1;
  }
}
