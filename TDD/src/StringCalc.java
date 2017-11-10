public class StringCalc
{
	public static void main(String[] args) {
		System.out.println(add("-5;2\n4"));
	}

	public static int add(String str) {
		int sum = 0;
		if (str.isEmpty()){
			return 0;
		}
		else if (str.length()==1){
			char num = str.charAt(0);
			return Character.getNumericValue(num);
		}
		else {
			String[] tokens = str.split(";|,|\\n");
			for (String elem : tokens) {
				sum += Integer.parseInt(elem);
			}
		}
		return sum;
	}
}

