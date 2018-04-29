package test;

public class TestBreak {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean conditie = false;
		int i = 1;
		mijnLabel:
			for(;;)
			{ System.out.println("for loop");
			  while(i < 5)
			  {
				 System.out.println("while loop");
			    if(conditie)
			    break mijnLabel;
			    if(!conditie) break;
			    i++;
			  }
			}																																																																																																																																																				
	}
	public double getWaarde(int in) {
		return 0.1;
	}
	public int getWaarde(int in, int in2)																																																																																																																																																																																																																																																																																							 {
		return 1;
	}	
}
