package springProblem;

import java.util.Scanner;

public class Main{
	private static ChessBoard sjakk = new ChessBoard();

	private static int stepCount;
	private static int radNaa;
	private static int kolonneNaa;
	private int startRad;
	private int startKolonne;
	public static int nr;
	public static int bord;
	

	// Mulige trekk som kan gjøres lagre i to forskjellige arrays.
	static int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public void getInputFromUser() {
		// henter inn informasjon frabruker
		Scanner input = new Scanner(System.in);
		System.out.println("Bestem hvilken rad springeren skal starte: ");
		int startRad = input.nextInt();
		System.out.println("Bestem hvilken kolonne springeren skal starte: ");
		int startKolonne = input.nextInt();
		radNaa = startRad + 1;
		kolonneNaa = startKolonne + 1;
		
		// setter brikken på den valgte plassen
		sjakk.setPunkt(radNaa, kolonneNaa, stepCount++);
		// skriver ut hvor den er plassert
	}

	// funksjonen skal hente startsposisjon og sette punktet som brukt.
	public boolean finnPos() {
		// sjekker om punktet er brukt
		if (sjakk.getPunkt(radNaa, kolonneNaa) == 0 || sjakk.getPunkt(radNaa, kolonneNaa) != -1) {
			sjakk.setPunkt(radNaa, kolonneNaa, stepCount++);
		}
		return false;
	}

	public boolean findSolution(int radNaa, int kolonneNaa, int stepCount) {
		// setter variabler som trengs i kjøringen
		int k, next_x, next_y;
		// om stepcount skulle være rader*kolonner er kjøringen gjennomført
		if (stepCount == (sjakk.rader * sjakk.kolonner) +1 ) {
			//System.out.println("den er ferdig" + " " + stepCount + "\n");
			System.out.println(sjakk);
			return true;
		}
		// for løkke for å sjekke mulige trekk som kan benyttes
		for (k = 0; k < 8; k++) {
			next_x = radNaa + xMove[k];
			next_y = kolonneNaa + yMove[k];
			// hvis punktet kan settes
			if (sjakk.getPunkt(next_x, next_y) == 0) {
				//System.out.println((next_x-2) + " " + (next_y-2));
				sjakk.setPunkt(next_x, next_y, stepCount);
				if(findSolution(next_x, next_y, stepCount +1)){
					//System.out.println(next_x + " " + next_y + " " + stepCount);
					return true;
				}
				//Backtracking setter det punktet du ikke kan finne et nytt punkt tilbake til punktet du kom fra og setter punktet du fikk fra til 0
				//System.out.println("backtrack" + next_x + " " + next_y);
				sjakk.setPunkt(next_x, next_y, 0);
				//System.out.println("backTraking fra" + next_x + " " + next_y);
			}
			
		}
		// Ingen løsning
		System.out.println("ingen løsning");
		return false;
	}

	public static void main(String[] args) {
		Main o = new Main();
		o.getInputFromUser();
		o.finnPos();
		o.findSolution(radNaa, kolonneNaa, stepCount);

	}

}
