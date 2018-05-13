package nl.maarten.ocp.m3genericsencollections;

import java.util.*;
public class GetallenApp {
    public static void main(String[] args) {
        List<Integer> getallen = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        getallen.removeIf(i -> i%2==0);
        getallen.forEach(System.out::println);
        getallen.replaceAll(i -> i*2);
        getallen.forEach(System.out::println);
        
    }
}
/*
Maak een applicatie GetallenApp en vul daarin een List met de getallen 1 t/m 10. Gebruik daarna de method removeIf() van Collection om de even getallen te verwijderen. Gebruik vervolgens replaceAll() van List om de overgebleven getallen te verdubbelen. Toon na afloop alle waarden met forEach(). 
*/