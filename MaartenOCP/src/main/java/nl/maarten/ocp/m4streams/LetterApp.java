package nl.maarten.ocp.m4streams;
import java.util.stream.*;
import java.util.*;

public class LetterApp {
    
    public static void main (String[] args) {
        Stream.of(args).filter(s3 -> uniekeLetter(s3))
                              .forEach(System.out::println);
        Comparator<String> compByLength = (st1, st2) -> st1.length() - st2.length();
        Optional<String> opt = Stream.of(args).filter(s -> uniekeLetter(s))
                                              .max(Comparator.comparing(String::length));
        System.out.println(opt.orElse("niet gevonden"));
        //
        // Modeluitwerking
        String woord = Stream.of(args).filter(s -> s.chars()
        		                                    .distinct()
        		                                    .count() == s.length())
        		                      .max((s1,s2) -> s1.length() - s2.length())
        		                      .orElse("Niet gevonden");
        System.out.println(woord);
    }
    public static boolean uniekeLetter(String s){
        int[] aantal = new int[256];
        for (char c:s.toCharArray()){ 
           aantal[(int) c]++;  
        }
        for (int i:aantal) {
            if (i>1) return false;
        }
        return true;
    }
}
/*
Maak een applicatie LetterApp die van de opgegeven woorden alleen de woorden toont waarin elke letter maar één keer voorkomt (zoals problematisch en nachtverblijf) . Extra uitdaging: toon alleen het langste gevonden woord, en anders de melding: “niet gevonden”. Maak daarvoor gebruik van de functie max(). 
*/