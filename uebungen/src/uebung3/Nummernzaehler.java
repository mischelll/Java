package uebung3;
import java.util.Scanner;
public class Nummernzaehler {

	public static void main(String[] args) {
		int positiv = 0, negativ = 0, anzahl = 0;
		double summe = 0;
		
		System.out.println("Geben Sie Zahlen ein: ");
		Scanner input = new Scanner(System.in);
		int zahl = input.nextInt();
		while (zahl != 0) {
			if(zahl >0) {
				positiv++;
			}else {
				negativ++;
			}
			
			anzahl++;
			summe += zahl;
			
			zahl = input.nextInt();
		}
		System.out.format("Pos; %s, Neg:%s",positiv,negativ);
		System.out.println("Anzahl: " +anzahl);
	
		System.out.println("Summe: " + summe);
		
		double durchschnitt = summe / anzahl;
		System.out.println("Durchschnitt: " + durchschnitt);

	}

}
