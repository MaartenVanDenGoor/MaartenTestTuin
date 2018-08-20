package test;

import java.util.Arrays;
import java.util.List;

public class TestLambdaListReplaceAll {
	public static void main(String[] args) {
		Integer[] myArray = { 1, 12, 34, 66,8 };
		List<Integer> list = Arrays.asList(myArray);
		list = rightDigit(list);
		System.out.println(Arrays.toString(list.toArray()));
		
	}
	public static List<Integer> rightDigit(List<Integer> nums) {
		nums.replaceAll(n ->  n%10);
		return nums;
	}
}
