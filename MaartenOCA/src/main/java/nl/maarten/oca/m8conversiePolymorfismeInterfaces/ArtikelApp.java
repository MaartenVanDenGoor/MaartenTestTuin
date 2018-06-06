package nl.maarten.oca.m8conversiePolymorfismeInterfaces;

public class ArtikelApp {
    public static void main (String[] args){
         Artikell a = new Artikell("Honing",12);
         Artikell b = new Artikell("Honing",12);
         Artikell c = new Artikell("Jam",12);
         System.out.println("a=b "+a.equals(b));
         System.out.println("a=c "+a.equals(c));
       
   }    
}


class Artikell {
    private String naam;
    private float prijs;

    Artikell(String naam, float prijs) {
       this.naam = naam;
       this.prijs = prijs;
   }
   public String getNaam() {
       return naam;
   }
   public float getPrijs() {
       return prijs;   
   }
   @Override
   public boolean equals(Object o){
       if (o != null) {
           if ( o instanceof Artikell) {
        	   Artikell a = (Artikell) o;
               if (naam.equals(a.getNaam()) &&
                   prijs == a.getPrijs() ) {
                     return true;
               }
           }
       }
       return false;
   }
}