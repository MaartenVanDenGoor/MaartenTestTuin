package nl.maarten.oca.m7construcorsenoverloading;

public class TestAdres {
    public static void main(String[] args) {
        Adres adres = new Adres("6523CX",307);
        adres.setStraatnaam ("Dommer van Poldersveldweg");
        adres.setPlaats("Nijmegen");
        System.out.println(adres);
    }    
}
