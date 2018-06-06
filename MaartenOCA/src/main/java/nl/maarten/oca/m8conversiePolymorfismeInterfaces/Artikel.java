package nl.maarten.oca.m8conversiePolymorfismeInterfaces;

public class Artikel {
    private String naam;
    private float prijs;
    public static void main (String[] args){
         Artikel a = new Artikel("Honing",12);
         Artikel b = new Artikel("Honing",12);
         Artikel c = new Artikel("Jam",12);
         System.out.println("a=b "+a.equals(b));
         System.out.println("a=c "+a.equals(c));
       
   }
   Artikel(String naam, float prijs) {
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
           if ( o instanceof Artikel) {
               Artikel a = (Artikel) o;
               if (naam.equals(a.getNaam()) &&
                   prijs == a.getPrijs() ) {
                     return true;
               }
           }
       }
       return false;
   }
}