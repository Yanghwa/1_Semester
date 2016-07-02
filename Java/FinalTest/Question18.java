package FinalTest;

import java.util.ArrayList;
import java.util.List;

public class Question18 {
	
	public static void main(String[] args) {
		List<Integer> Integers = new ArrayList<Integer>();
		Integers.add(1);
		Integers.add(2);
		Integers.add(3);
		Integers.add(4);
		Integers.add(5);
		Integers.add(6);
		Integers.add(7);
		Integers.add(8);
		Integers.add(9);
		Integers.add(10);
		int sum = 0;
		for(int i=0; i < Integers.size(); i++) {
			sum += Integers.get(i);
			System.out.format("The current sum is %d \n", sum);
		}
		System.out.println("Thank you...come again!");
		
	}
}
