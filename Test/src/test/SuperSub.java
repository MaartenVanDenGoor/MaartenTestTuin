package test;

public class SuperSub extends SubKlas{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperSub ss = new SuperSub();
		System.out.println(ss);
		SuperKlas sk = new SuperSub();
		System.out.println(sk);
	}
	public String toString() {
		return "SuperSub";
	}	
	SuperSub getElement() {
		return this;
	}
}
class SuperKlas {
	public String toString() {
		return "Superklas";
	}
}
class SubKlas extends SuperKlas {
	public String toString() {
		return "Subklas";
	}	
	SubKlas getElement() {
		return this;
	}
	
}


