package nl.maarten.ocp.m2advancedclassdesign;

import static nl.maarten.ocp.m2advancedclassdesign.Operator.*;
public class OperatorTest {
   public static void main(String[] args) {
   	bereken(2,Operator.PLUS,3);
   }
   static void bereken(double a, Operator o, double b) {
   	System.out.println(a+" "+o.getNaam()+" "+b+" = "+o.getBo().apply(a,b));
   }

}