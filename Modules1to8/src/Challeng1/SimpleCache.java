package Challeng1;

public class SimpleCache {
    //int[] key;
    //int[] values;
    CacheData[] array;
    public SimpleCache(int cacheCapacity) {
        array = new CacheData[cacheCapacity];
        /*key = new int[cacheCapacity];
        values = new int[cacheCapacity];
        for (int i = 0; i < key.length; i++) {
            key[i]=-1;
        }*/
    }

    public int calculate(int value) throws InterruptedException {
        Calculator calc = new Calculator();
        int result;
        for (int i = 0; i < array.length; i++) {
            //if (array[i])
        }
        /*if (key[value] == value) {
            System.out.println("Using cached data");
            return values[value];
        }
        else{
            key[value] = value;
            values[value] = calc.doComplexCalculation(value);
            //values[value]=result;
        }
        return values[value];*/
        return 2;
    }

}
