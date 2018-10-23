package springProblem;

public class ChessBoard extends Main{
	
	//Tabellen som vi skal bruke
	public final int rader = 8;
	public final int kolonner = 8;
	//setter opp tabellen til 12x12 for å få alle utennom 8x8 til -1
	public final int stoerrelse = 15;
	// 2-d array med 12x12 tabell
	private int [][] bordtabell = new int[stoerrelse][stoerrelse];

public ChessBoard() {
	//Denne setter opp alle mulig -1 felter
	//hvis y er mindre en bordtabell.length (12x12)
	for (int y = 0; y < bordtabell.length; y++){
		//hvis x er mindre enn bordtabell [y]
		for (int x = 0; x < bordtabell[y].length; x++){
			
			bordtabell[y][x] = -1;
		}
		for (int r = 2; r < rader + 2; r++){
		for(int k = 2; k < kolonner + 2; k++){
			bordtabell[r][k] = 0;
			
		}
	}
	}
}


	// overskriver slik at det bare er tabellen som vises. Alt utennom tabellen som er -1 vil ikke være synlig.
	public String toString(){
		String vise = "";
				for (int r = 2; r < rader + 2; r++){
					for(int k = 2; k < kolonner + 2; k++){
			vise += bordtabell[r][k];
			vise += "\t";
			}
			vise += "\n\n";
			}	
		return vise;
		
	}
	
	public void setPunkt(int rader, int kolonner, int step){
		if (rader > 1 && rader <= 10 && kolonner > 1 && kolonner <= 10){
			bordtabell[rader][kolonner] = step;
		}
		else{
			System.out.println("teit" + rader + " " + kolonner);
		}
	}
	public int getPunkt(int rader, int kolonner){
		return bordtabell[rader][kolonner];
	}
} // avslutter klassens.
	
/* Bretter ser egentlig slik ut
 * -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
 * -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
 * -1 -1  0  0  0  0  0  0  0 -1 -1
 * -1 -1  0  0  0  0  0  0  0 -1 -1
 * -1 -1  0  0  0  0  0  0  0 -1 -1
 * -1 -1  0  0  0  0  0  0  0 -1 -1
 * -1 -1  0  0  0  0  0  0  0 -1 -1
 * -1 -1  0  0  0  0  0  0  0 -1 -1
 * -1 -1  0  0  0  0  0  0  0 -1 -1
 * -1 -1  0  0  0  0  0  0  0 -1 -1
 * -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
 * -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
 * 
 * Alle felter som er -1 er ugyldige trekk
 * Alle felter med verdien 0 er felter som er 
 */
	
