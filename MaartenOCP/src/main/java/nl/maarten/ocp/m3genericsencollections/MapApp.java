package nl.maarten.ocp.m3genericsencollections;
import java.util.*;
import java.util.function.BiFunction;
public class MapApp {

public static void main (String[] args) {
	Map<Integer,String>  lijst = new TreeMap<>();
	Map<Integer,Integer> aantalLijst = new TreeMap<>();
	for (String s:args) {
		// Unieke key - Value in lijst
		lijst.merge(s.length(),s,(oldVal, newVal) ->  oldVal.compareTo(newVal)>=1?newVal:oldVal);
		// Aantallen per key in aantalLijst
		aantalLijst.compute(s.length(),(key, oldVal) -> oldVal==null?1:oldVal +1);
	   }
   lijst.forEach((k,v)->System.out.println("key : " + k + " value : " + v));
   // Verwijderen key - Value uit lijst als value = 1 bij key in aantalLijst
   for (int i=1;i<=30;i++){
       if (aantalLijst.getOrDefault(i,0)==1) {
           lijst.computeIfPresent(i,(x,y) -> null);
       }
   }
   System.out.println("Na verwijderen lengtes die maar een keer voorkomen");
   lijst.forEach((k,v)->System.out.println("key : " + k + " value : " + v + " aantal voorkomens "+aantalLijst.get(k) ));
  }
}
/*

Maak een applicatie MapApp die zal worden aangeroepen met een reeks woorden. In de applicatie wordt een Map met Integer keys en String values gevuld. De keys worden gevormd door de lengtes van de opgegeven woorden. De values zijn de woorden zelf. Als er meerdere woorden met dezelfde lengte worden meegegeven, worden alfabetisch kleinere woorden vervangen door alfabetisch grotere woorden. Toon na afloop de key-value paren in de Map.
 
Tips:  

    gebruik van merge() bij het vullen van de (eerste) map  
    Strings zijn Comparable: gebruik compareTo() in de BiFunction voor het bepalen van de value  
    gebruik forEach() voor het tonen van de key-value paren. 

 
Optioneel:
Vul een tweede map met per lengte het aantal woorden van die lengte. Lengtes die slechts één keer voor blijken te komen worden uit de eerste map verwijderd. Maak voor het tellen van de voorkomende lengtes gebruik van compute(). Voor het verwijderen kan computeIfPresent() worden gebruikt in een for loop, waarbij mogelijke woordlengtes van 1 t/m 30 worden gecontroleerd.
*/