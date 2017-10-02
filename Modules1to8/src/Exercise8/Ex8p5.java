package Exercise8;

public class Ex8p5 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n");
	for (int i = 0; i < 10; i++) {
		if (i%2==0) {
			sb.append("  <tr bgcolor = \"#ccccc\">\n");
		}
		else {
			sb.append("  <tr bgcolor = \"#fffff\">\n");
		}
		sb.append("    <td>Row"+i+"</td>\n"+"    <td>xxxxx<td>\n"
	    +"  </tr>\n");
	}
	sb.append("</table>");
	System.out.println(sb.toString());
    }
}
