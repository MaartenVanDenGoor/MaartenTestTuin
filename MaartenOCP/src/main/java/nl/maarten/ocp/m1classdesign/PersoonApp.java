package nl.maarten.ocp.m1classdesign;

import java.util.*;
public class PersoonApp {
    public static void main (String[] args) {
        List<String> lijst = new ArrayList<>();
        lijst.add("Maarten");
        lijst.add("Van");
        lijst.add("Den");
        lijst.add("Goor");
        Persoon p = new Persoon(lijst);
        System.out.println(p);
        List<String> l = p.getNamen();
        l.add("copie");
        System.out.println(p);
    }
}
class Persoon {
    private List<String> namen;
    Persoon(List<String> namen) {
        this.namen = new ArrayList<>(Arrays.asList(new String[namen.size()]));
        Collections.copy(this.namen, namen);    
    }
    public List<String> getNamen() {
        List<String> kopie = new ArrayList<>(Arrays.asList(new String[namen.size()]));
        Collections.copy(kopie,namen);
        return kopie;
    }
    public String toString() {
        return namen.toString();
    }
}