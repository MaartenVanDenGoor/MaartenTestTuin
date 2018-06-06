package nl.maarten.oca.m8conversiePolymorfismeInterfaces;

interface Range {
	  int getLowerBound();
	  int getUpperBound();

	  default int pctInRange(int value){
	    int range = getUpperBound()-getLowerBound();
	    double pct = (double) (value - getLowerBound())/range * 100;
	    return (int)pct;
	  }

	  static Range of (int x, int y){
	    return new Range(){ // anonieme inner class
	      public int getLowerBound(){ return x<y?x:y; }
	      public int getUpperBound(){ return x>y?x:y; }
	    };
	  }
	}

	class Fahrenheit implements Range {
	  public final static int VRIESPUNT = 32;
	  public final static int KOOKPUNT = 212;
	  private int graden;

	  Fahrenheit(int graden){
	    this.graden=graden;
	  }

	  public int getGraden(){
	    return graden;
	  }
	  public  int getLowerBound() {
	    return VRIESPUNT;  
	  }
	  public int getUpperBound() {
	    return KOOKPUNT;  
	  }
	  public int pctInRange(){
	  	  return Range.super.pctInRange(graden);
	  }
	  public int getCelsius(){
		  Double resultaat =  (graden-32) * (5/9D);
		  return resultaat.intValue();
	  }
	}


