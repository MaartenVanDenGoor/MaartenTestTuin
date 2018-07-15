package test;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TestFloat {
	public static void main(String[] args) {
/*
         int x = 0;
         for(long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
         System.out.print(y + " ");
         }
         System.out.print(x);         
         for (;x<8;) {
        	 x++;
        	 System.out.println("infinity loop"+x);
         }
         System.out.println("---------");
         int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
         for(int[] mySimpleArray : myComplexArray) {
            for(int i=0; i<mySimpleArray.length; i++) {
                System.out.print(mySimpleArray[i]+"\t");
             }
            System.out.println("=========");
        	for (int i: mySimpleArray) {
        		System.out.print(i+"\t");
        	}
         System.out.println();
         } 
     	int y = 5;
    	optionalLabel: //ok
    	while(y< 10) {
           middleLabel:   // Fout, niet gevolgd door while 
           System.out.println("Loop out "+y);
           InnerLabel: //ok
    	   while (y < 10) {
	      	  y++;
	      	  System.out.println("Loop in "+y);
	      	  break optionalLabel;
    	   }
    	}   
    	System.out.println(" einde "+y);
 
		FIRST_CHAR_LOOP: 
		for (int a = 1; a <= 4; a++) {
			System.out.println("Outer loop a="+a);
			for (char x = 'a'; x <= 'c'; x++) {
				System.out.println("Inner loop x="+x);
				if (a == 2 || x == 'b')
				   continue;// FIRST_CHAR_LOOP;
				System.out.println(" " + a + x);
			}
	     }
	     TEST_LABEL:
	     if (1==1) {
	     }
	     int x = 4;
	     long y = x * 4 - x++;
	     System.out.println("y "+y+" x "+x);
	     boolean b1 = true, b2 = true;
	     int i1 = 20;
	     b1 = (i1 != 10) ^ (b2=false);
	     if(b1 = false) System.out.println("Success");
	     else System.out.println("Failure");
	     int w=2;
         System.out.println(w>1? w>2? "dit":"mag":"dus");
         int i =0;
         i = i++;
         System.out.println("i "+i);
         String x = "Hello World";
         String z = "Hello World ".trim();
         System.out.println(x == z); // false
         
         
         int[] numbers = {2,7,4,6,8,3};
         System.out.println(Arrays.binarySearch(numbers,4));
         
         String[] lijst = {"drie","twee","vier","vijf","een"};
         System.out.println(Arrays.binarySearch(lijst,"twee"));
 
         ArrayList<Integer> list2 = new ArrayList<>(10);
         list2.add(1);
         for (Integer i:list2) {
        	 System.out.println(i);
         }
         List<String> birds = new ArrayList<>();
         birds.add(new String("mus"));
         birds.add("spreeuw");
         birds.remove(new String("mus"));
         System.out.println(birds);
         
         Character a = Character.valueOf('a');
         Character b = new Character('a');
         System.out.println(a.equals(b)?"Gelijk":"Ongelijk");
         Double d;
         d = 10d;                    // AutoBoxing
         d = new Double(50d);
         d = Double.parseDouble("50");
         
         List<Integer> numbers = new ArrayList<>();
         numbers.add(1);
         numbers.add(2);
         numbers.remove(1); // LET OP !! geen autoboxing, maar index 1 wordt
                            //  verwijderd
         System.out.println(numbers);

         
         String[] array = { "hawk", "robin" };
         List<String> list = Arrays.asList(array);
         list.set(1, "test");
         // list en array wijzen naar zelfde object !!
         for (String s:array) {
        	 System.out.print(s+" ");  // hawk test
         }
         
         String[] words = {"ace","boom","crew","dog","eon"};
         List<String> arrayList = new ArrayList<>(); 
         Collections.addAll(arrayList, words); 
         
         LocalDate date1 = LocalDate.of(2000,1,1);
         LocalDate date2 = date1.plusDays(1);
         System.out.println(date1);
         System.out.println(date2);
         
         Period wrong = Period.ofYears(1).ofWeeks(7);
         System.out.println("period "+formatPeriod(wrong));
  
         LocalDate date = LocalDate.of(2015, 1, 20);
         LocalTime time = LocalTime.of(6, 15);
         LocalDateTime dateTime = LocalDateTime.of(date, time);
         Period period = Period.ofMonths(1);
         System.out.println(date.plus(period));  // 2015-02-20
         System.out.println(dateTime.plus(period)); // 2015-02-20T06:15
     //    System.out.println(time.plus(period));  // rumtime error
         
         LocalDateTime dateNu = LocalDateTime.now();
         System.out.println(dateNu);
         System.out.println(dateNu.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
         dateNu = dateNu.minusMonths(2);
         DateTimeFormatter shortDateTime =
        		 DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
         System.out.println(shortDateTime.format(dateNu));
         System.out.println(dateNu.format(shortDateTime));
         System.out.println('a');
         System.out.println('a'+'b');
         System.out.println(""+'a'+'b');
         StringBuilder sba = new StringBuilder("aa");
         StringBuilder sbb = new StringBuilder("aa");
         
         System.out.println(sba.equals(sbb));
         Object[][][] cubbies = new Object[3][0][5];
         
         int[] numbers = new int[10];
         int ii = numbers.length;
         int[][] scores = new int[5][];
         scores[0] = new int[5];
         
         String[] sar = {"b","d","a","c","e"};
         for (String s:sar) {
        	 System.out.println(s);
         }
                      
		String[] s1 = {"a","b","c"};
		String[] s2 = {"a","b","c"};
		System.out.println(s1.equals(s2));
		List<Integer> list = Arrays.asList(10, 4, -1, 5);
		Collections.sort(list);
		Integer array[] = list.toArray(new Integer[4]);
		System.out.println(array[0]);
	    List<String> list = Arrays.asList("a","b");
        Object[] objectArray = list.toArray();      // Naar Object[] mag
        String[] sArray = (String[])list.toArray(); // Naar String[] casten!
        sArray = list.toArray(new String[list.size()]);       // Dit mag ook !
        */
        List<Integer> list = Arrays.asList(10, 4, -1, 5);
        List<Integer> list1 = Arrays.asList(10, 4, -1, 5);
        System.out.println(list.equals(list1));

        walk(4,new int[] {1,2,3,4});
        walk(5,new int[0]);
        walk(6,null);
	}
	public static String formatPeriod(Period p) {
        return "jaren:"+p.getYears() + "maanden:"+p.getMonths() +  " dagen"+p.getDays();
       	}

	public static void walk(int ia, int[] inums) {
		System.out.println("----"+ia);
	//	for (int i:inums) {
	//		System.out.println(i);
	//	}
		
	}
}
