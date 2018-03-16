package test;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println("Hello World!");
       Maat kledingmaat = Maat.XL; 
       System.out.println("Maat is : "+kledingmaat);  
       int miljoen = 1_000_000_000;
       System.out.println("miljoen "+miljoen);
       int verschil = Math.abs(6-9);
       System.out.println("verschil "+verschil);
       long uitkomst = Math.round(3.5d);
       System.out.println("uitkomst "+uitkomst);
       //
       Test test = new Test();
       test.doeIets(new Integer(1),new Integer(1));
	}
    public void doeIets() {
    	
    }
    public void doeIets(Integer... list) {
    	System.out.println("de lijst");
    }
    public void doeIets(Integer een) {
    	System.out.println("De een");
    }

}

