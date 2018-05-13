package nl.maarten.ocp.m3genericsencollections;
import java.util.*;
public class SorteerApp {
    public static void main(String[] args) {
        Integer [] getallen = new Integer[Integer.parseInt(args[0])];
        Arrays.setAll(getallen, i -> (i+1)*2);
     //   Arrays.sort(getallen,Comparator.reverseOrder());
        Arrays.sort(getallen, (a,b) -> b.compareTo(a));
        System.out.println(Arrays.toString(getallen));
    }
}