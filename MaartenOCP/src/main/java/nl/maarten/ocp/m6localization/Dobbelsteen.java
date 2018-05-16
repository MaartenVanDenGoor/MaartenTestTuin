package nl.maarten.ocp.m6localization;

import java.util.*;
import java.util.stream.*;
public class Dobbelsteen {
    public static void main(String[] args) {
        Locale loc = new Locale.Builder()
                                .setLanguage(args[0])
                                .setRegion(args[0].toUpperCase())
                                .build();
        ResourceBundle dobbelsteen = ResourceBundle.getBundle("nl.maarten.ocp.m6localization.dobbelsteen",loc);
        IntStream.rangeClosed(1, 10).map(.
                 .
        for (int i=1;i<=10;i++) {
            int worp =(int)(Math.random()*6+1);
            System.out.println("worp "+dobbelsteen.getString(""+worp));
        }
    }
}