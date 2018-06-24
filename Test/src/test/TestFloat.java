package test;

public class TestFloat {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float value1 = 102;
		float value2 = (int) 102.0;
	//	float value3 = 1f * 0.0;  // Mag niet, resultaat is een double
		float value4 = 1f * (short)0.0;
    //    float vaLue5 = 1f * (boolean) 0;
		float f = 0.0F;
		

		String s = null;
		System.out.println("s "+s);
		/*
		int x = 3;
		int y = 4;
	//	int z = --y + x++;
		
		int z = --y + 3;
		*
		*/
		short x = 10;
		short y = 3;
        double z = (double) x/y;
         System.out.println("z "+z);	

         int a = 5;
         int b = 7;
         int c = b++;
         System.out.println("c "+c);
		
	}
}
