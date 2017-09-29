package Challeng1;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int cacheCapacity = 10;
        SimpleCache cache = new SimpleCache(cacheCapacity);
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            int value = rand.nextInt(cacheCapacity); //Det tar ett tal i [0,1) och multiplicerar med cacheCapacity
            System.out.println("Getting result for value " + value);
            int result = cache.calculate(value);
            System.out.println("Result: " + result);
            System.out.println();
        }
    }
}
