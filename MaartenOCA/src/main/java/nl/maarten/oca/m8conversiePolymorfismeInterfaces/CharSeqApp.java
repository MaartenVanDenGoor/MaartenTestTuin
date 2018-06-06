package nl.maarten.oca.m8conversiePolymorfismeInterfaces;

public class CharSeqApp {

public static void main (String[] args) {
	
	 System.out.println(CharSeqApp.eersteLaatst("tram"));
	
   }
   public static CharSequence eersteLaatst(CharSequence seq){
      return seq.subSequence(1,seq.length()).toString()+seq.charAt(0);
   
   } 
}