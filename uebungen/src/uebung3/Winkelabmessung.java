package uebung3;
import java.util.Scanner;
public class Winkelabmessung {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		double winkel;
		char einheit;
		do {
			System.out.print("Winkeleingabe: ");
			winkel = in.nextDouble();
			
			System.out.print("Einheiteingabe: ");
			String symbole = in.next();
			einheit = symbole.charAt(0);
			
			if(einheit == 'r') {
				double neuWinkel = winkel / Math.PI*180;
				System.out.println("Winkel: "+ neuWinkel + "g");
			}else if(einheit == 'g') {
				double neuWinkel = winkel*Math.PI/180;
				System.out.println("winkel: " + neuWinkel + "r");
			}
		}while(einheit == 'g'|| einheit =='r');
		

	}

}
