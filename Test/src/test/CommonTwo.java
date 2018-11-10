package test;

public class CommonTwo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonTwo ct = new CommonTwo();
		String a[] = {"a", "c", "x"};
		String[] b = {"b", "c", "d", "x"};
		ct.doe(a,b );
		//
		int[] c = {5, 3, 6, 7, 2};
		ct.bigHeights(c, 2, 4);
	}
	public int doe(String[] a, String[] b) {
		  int aantal = 0;
		  int teller = 0;
		  String t = null;
		  for (String s:a) {
		     while (true) {
			  t = b[teller];
		      if (s.compareTo(t) < 0) break;
		      if (s.compareTo(t) > 0) teller++;
		      if (s.compareTo(t) == 0) { aantal++; 
		                               teller++; 
		                               break; }
		    }
		     
		  }
		  return aantal;
		}
	public int bigHeights(int[] heights, int start, int end) {
		  int aantal = 0;
		  for (int i = start ;i <= end;i++) {
			System.out.println("i="+i);
		    if (i > start ) {
		    	System.out.println(heights[i] - heights[i-1]);
		    	if (heights[i] - heights[i-1] >= 5 ) aantal++;
		    	if (heights[i] - heights[i-1] <= -5 ) aantal++;
		    }

		  }
		  byte b1 = 1;
		  return aantal;
		  
		}

}
