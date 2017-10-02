package Exercise8;

public class Ex8p1p1 {
    public static void main(String[] args) {
	char[] a = {'J','a','v','a','R','u','l','e','s'};
	String s = "";
	/*for (int i = a.length-1; i >= 0 ; i--) {
	    System.out.print(a[i]);
	}
	System.out.println();

	for (int i =0; i<a.length; i+=2) {
	    s += a[i];
	}
	System.out.println(s);
	String str = new String(a);
	System.out.println(str);*/

	//System.out.println(a);
	String namestr = a.toString();
	System.out.println(namestr);
    }
}
