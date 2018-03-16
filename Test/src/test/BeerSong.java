package test;

public class BeerSong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int beernum = 99;
        String word = "bottles";
        while (beernum > 0) {

        	System.out.println(beernum+" "+word+" of beer on the wall");
        	System.out.println(beernum+" "+word+" of beer");
        	System.out.println("Take on down");
        	System.out.println("Pass it around");
        	beernum = beernum - 1;
        	//
        	if (beernum==1) {
        		word = "bottle";
        	}
        	if (beernum > 0) {
        		System.out.println(beernum+" "+word+" of beer on the wall");
        	} else {
        		System.out.println("No more bottles of beer on the wall");
        	}
        }
	} 

}
