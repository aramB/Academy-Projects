package exercise17;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Ex17p4
{
	public static void main(String[] args) {
		// write your code here
		Scanner scanner = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		while(true) {
			producer(queue);
			consumer(queue);
			System.out.println("Queue length: " + queue.size());
			scanner.nextLine();
		}
	}

	public static void producer(Queue<Integer> queue) {
		Random random = new Random();
		for (int i = 0; i < random.nextInt(5); i++) {
			queue.add(i);
		}
	}

	public static void consumer(Queue<Integer> queue) {
		Random random = new Random();
		for (int i = 0; i < random.nextInt(5); i++) {
			if (!queue.isEmpty()) {
				queue.remove();
			}
		}
	}
}
