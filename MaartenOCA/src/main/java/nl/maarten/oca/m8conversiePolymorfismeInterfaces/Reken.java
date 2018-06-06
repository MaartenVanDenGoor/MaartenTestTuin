package nl.maarten.oca.m8conversiePolymorfismeInterfaces;

public class Reken {
    public static void main (String[] args){
        System.out.println(Reken.rondAf(4.5678F, (short) 3));
        
    }
    public static float rondAf(float invoer, short decimalen) {
             float resultaat = invoer * (float) Math.pow(10,decimalen);
             resultaat = Math.round(resultaat);
             resultaat /= Math.pow(10,decimalen);
            return resultaat;
    }
}