package test;
import java.util.stream.*;
import java.util.*;

public class TestStream {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	int[] y = {2,5,6,8};
		IntStream s1 = Arrays.stream(y);
		s1.forEach(System.out::println);
		Random random = new Random();
		System.out.println("--------------");
		IntStream.generate(() -> random.nextInt(100))
		         .peek(x -> System.out.println("generated : "+x))
		         .skip(5)
		         .peek(x -> System.out.println("skip : "+x))
		         .limit(10)
		         .peek(x -> System.out.println("limit : "+x))
		         .filter(x -> x%2==0)
		         .forEach(x -> System.out.println("filter : "+x));
	   Container c1 = new Container();
	   Container c2 = new Container();
	   c1.combine(c2);;
	   System.out.println(c1.getAantal());
	   */

        Integer[] getallen = {1,2,3,4,5,6,7,8,9};
        getallen = Stream.of(getallen)
                .map(getal -> getal%2==0?getal*10:getal)
                .toArray(Integer[]::new);
      
         Stream.of(getallen).forEach(System.out::println);
	}
}
class Container {
	private int aantal = 1;
	public void combine (Container c) {
		this.aantal += c.aantal;
	}
	public int getAantal() {
		return aantal;
	}
}
