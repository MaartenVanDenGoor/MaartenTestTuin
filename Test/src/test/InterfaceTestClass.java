package test;

public class InterfaceTestClass implements InterfaceTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfaceTest it = new InterfaceTestClass();
		it.doeIets(1,1);
		int i = InterfaceTest.getIets();
	}

	@Override
	public void doeIets() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doeIets(int in) {
		// TODO Auto-generated method stub
		
	}
}
