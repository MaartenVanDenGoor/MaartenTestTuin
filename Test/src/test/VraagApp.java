package test;

public class VraagApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder vraag = new StringBuilder();
        if (args.length < 3) {
        	System.out.println("Minimaal 3 woorden meegeven");
        } else {
        	vraag.append(args[1]+" "+args[0]);
        	for (int i=2;i<args.length;i++) {
        		vraag.append(" " + args[i]);
        	}
            System.out.println(vraag+"?");
        }
	}

}
