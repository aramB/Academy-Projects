package Exercise10;

import java.util.Scanner;

public class Crypto {
	public String encrypt(String input) {
		String encrypted = "";
		for (int i = 0; i < input.length(); i++) {
			int encryptedAscii;
			encryptedAscii = (int)input.charAt(i)+1;
			encrypted += (char)encryptedAscii;
		}
		return encrypted;
	}
	public String decrypt(String input) {
		String encrypted = "";
		for (int i = 0; i < input.length(); i++) {
			int encryptedAscii;
			encryptedAscii = (int)input.charAt(i)-1;
			encrypted += (char)encryptedAscii;
		}
		return encrypted;
	}
}

class Main3 {
	public static void main(String[] args) {
		Crypto crypto = new Crypto();
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter the combination: ");
		String in = sc.nextLine();
		System.out.println(crypto.encrypt(in));
		System.out.println("Please enter the decrypted combination: ");
		String out = sc.nextLine();
		System.out.println(crypto.decrypt(out));
	}
}
