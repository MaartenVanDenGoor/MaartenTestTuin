package test;

public class InstanceTest {
	public static int een = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(InstanceTest.een);
	}
	static {
		een = 2;
	}
}
