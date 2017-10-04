package exercise12.recursion;

public class Test {
	public int fac(int n) {
		if (n==0){
			return 1;
		}
		return n*fac(n-1);
	}

	public int facTail(int n, int acc) {
		if (n==0) {
			return 1;
		}
		return facTail(n-1, n*acc);
	}
}

class Main {
	public static void main(String[] args) {
		int n= 5;
		Test factorial = new Test();
		System.out.println(factorial.fac(n));
	}
}