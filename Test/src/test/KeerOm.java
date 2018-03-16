package test;

public class KeerOm {
	
	public static void main(String[] args) {
        if (args.length != 1) {
        	System.out.println("Een argument meegeven");
        } else {
            StringBuilder sb = new StringBuilder(args[0]);
            System.out.println(sb.reverse());
        }
	}

}
