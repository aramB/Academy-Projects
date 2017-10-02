package Exercise8;

public class Ex8p1p4 {
    public static void main(String[] args) {
	String name = "Java Svensson";
	char[] array = new char[name.length()];
	for (int i = 0; i < array.length; i++) {
	    array[i]=name.charAt(i);
	}
	for (char elem : array){
	    System.out.print(elem);
	}
    }
}
