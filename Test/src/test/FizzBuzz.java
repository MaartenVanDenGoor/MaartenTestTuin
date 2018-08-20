package test;

import java.util.Arrays;

public class FizzBuzz {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(doe(1,6)));
	}
	public static String[] doe(int start, int end) {
		  int lengte = end-start;
		  String[] lijst = new String[lengte];
		  System.out.println("end-start "+(end-start));
		  for (int i =0;i<lengte;i++,start++) {
			  System.out.println("i "+i+" start "+start);
	    
		    if (start%3==0 && start%5==0) lijst[i]="FizzBuzz";
		    if (start%3==0 && start%5!=0) lijst[i]="Fizz";
		    if (start%3!=0 && start%5==0) lijst[i]="Buzz";
		    if (start%3!=0 && start%5!=0) lijst[i]=""+start; 
		  } 
		  return lijst;
		}
	
}
