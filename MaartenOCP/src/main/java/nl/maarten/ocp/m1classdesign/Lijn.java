package nl.maarten.ocp.m1classdesign;

public final class Lijn {
	  private final Punt p1, p2;     // punt is mutable met accessors
	  private static Lijn INSTANCE;
	  private Lijn(Punt p1, Punt p2){
	    this.p1 = new Punt(p1.getX(),p1.getY()); // Punt(int x, int y)
	    this.p2 = new Punt(p2.getX(),p2.getY()); // {this.x=x;this.y=y}
	  }
	  public static Lijn getInstance(Punt p1, Punt p2) {
	    if (INSTANCE==null) {
	      synchronized (Lijn.class) {
	        if (INSTANCE==null) {
	            INSTANCE = new Lijn(p1,p2);
	        }
	      }
	    }
	    return INSTANCE;
	  }
	  public Punt getP1(){
	    return new Punt(p1.getX(),p1.getY());
	  }
	  public Punt getP2(){
	    return new Punt(p2.getX(),p2.getY());
	  }
	  public String toString() {
	    return p1+" - "+p2;
	  }
	  public static void main(String[] args) {
	    Punt a = new Punt(0,0);
	    Punt b = new Punt(5,5);
	    Lijn l = Lijn.getInstance(a,b);
	    System.out.println("lijn : "+l);
	  }
	}