package uebung3;

public class Nummernsuche {

	public static void main(String[] args) {
	int numberCount = 1;
	for(int number = 100; number<=1000;number++) {
		if(number % 5 == 0 && number % 6 == 0) {
			if(numberCount %10 == 0) {
				System.out.println(number);
			}else {
				System.out.print(number + " ");
			}
			numberCount++;
		}
	}

	}

}
