package exercise17;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Ex17p3
{
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		//Reverse the nums List using a stack
		for (Integer num : nums) {
			System.out.println(num);
		}
		System.out.println("\n============ \n");
		Stack<Integer> stack = new Stack<>();
		for (int elem : nums) {
			stack.push(elem);
		}
		/*
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		*/
		while(stack.size()>0) {
			int current = stack.pop();
			System.out.println(current);
		}
	}
}
