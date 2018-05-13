package nl.maarten.ocp.m2advancedclassdesign;

import java.util.function.BinaryOperator;
public enum Operator {
   PLUS("+",(d1,d2) -> d1+d2), 
   KEER("*",(d1,d2) -> d1*d2), 
   MIN("-",(d1,d2) -> d1-d2), 
   GEDEELD_DOOR("/",(d1,d2) -> d1/d2);
   private final String naam;
   BinaryOperator<Double>  bo;
   Operator(String naam, BinaryOperator<Double>  bo) {
   	this.naam = naam;
   	this.bo   = bo;
    }
   public BinaryOperator<Double> getBo() {
      return bo;	
   }
   public String getNaam() {
   	return naam;
   }
   
}