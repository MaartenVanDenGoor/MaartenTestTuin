package nl.maarten.oca.m3applicaties;

public class Keerom {
	
	public static void main(String[] args) {
        if (args.length != 1) {
        	System.out.println("Een argument meegeven");
        } else {
            StringBuilder sb = new StringBuilder(args[0]);
            System.out.println(sb.reverse());
        }
	}

}