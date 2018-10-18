package uebung4;

public class Numbers {

	public static void main(String[] args) {
		System.out.println("1234 palindromisch: " + isPalindrome(1234));
		System.out.println("1221 palindromisch: " + isPalindrome(1221));
		System.out.println("1234 ungekehrt: " + reverse(1234));
		System.out.println("127 Primzahl: " + isPrime(127));
		System.out.println("1234 Primzahl: " + isPrime(1234));

	}
	
	public static int reverse(int number) {
		int reversedNumber = 0;
		while (number > 0) {
			reversedNumber = (reversedNumber *10) + (number%10);
			number /= 10;
		}return reversedNumber;
	}
	
	public static boolean isPalindrome(int number) {
		int reversedNumber = reverse(number);
		return number == reversedNumber;
		
	}
	
	static boolean isPrime(int number) {
		int divider = 2;
		while(divider<=Math.sqrt(number)) {
			if(number%2 == 0) {
				return false;
			}
			divider++;
		}
		return true;
	
	}

}
