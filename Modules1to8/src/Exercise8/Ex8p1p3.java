package Exercise8;

public class Ex8p1p3 {
    public static void main(String[] args) {
	char[] a = {'J','a','v','a','R','u','l','e','s'};
	StringBuilder stringBuilder = new StringBuilder();
	for (int i = 0; i < a.length; i++) {
	    stringBuilder.append(a[i]);
	}
	String str = stringBuilder.toString();
	System.out.println(str);
    }
}
