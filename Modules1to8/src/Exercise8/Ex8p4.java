package Exercise8;

public class Ex8p4 {
    public static void main(String[] args) {
	/*String s1 = "+462131421";
	if (s1.startsWith("+46")) {
	    s1 = s1.substring(3);
	}
	System.out.println(s1);
	//====================================
	String s2 = "127.0.0.0";
	String s3 = s2.replace(".", "");
	System.out.println(s3);
	//=====================================
	*/
	String s4 = "123, 45,-34,231, 0,-1,-12312 , 12312,23423";
	String[] arrayStr = s4.split(",");
	String s5 = "";
	for (String elem : arrayStr) {
	    if (elem.startsWith("-")) {
	        elem="0";
	    }
	    s5+=elem.trim()+",";
	}
	System.out.println(s5);

	String s6 = "akfndslf";
	if (!s6.endsWith(".")) {
	    s6 += ".";
	}
	System.out.println(s6);
    }
}

