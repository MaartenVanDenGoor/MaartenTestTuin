package test;
public class Koala {
	public static int count=0;
	public static void main(String[] args) {
		System.out.println(Koala.count); //prima
		Koala k = null;
		System.out.println(k.count);     //mag
		Koala f;
	//	System.out.println(f.count);     //compileert niet
        f = new Koala();
		System.out.println(f.count);     //nu wel 
	}
}