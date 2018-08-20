package test;

public interface InterfaceTest {
	public static final int veld = 1;
	public abstract void doeIets();
	public abstract void doeIets(int in);
	default public void doeIets(int in,int uit) {
		System.out.println("a");
	}
	static int getIets() {
		return 1;
	}
}
