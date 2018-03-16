package test;

public class SubstringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        if (args.length < 2) {
        	System.out.println("Minimaal 2 argumenten meegeven");
        } else {
        	int beginIndex = Integer.parseInt(args[1])-1;
        	int eindIndex  = beginIndex + Integer.parseInt(args[2]);
            System.out.println(args[0].substring(beginIndex,eindIndex));
        }
	}

}
