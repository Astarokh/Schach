import java.util.Scanner;

public class SchachStarten {

	public static void main(String[] args) {
		
		Figur[] schachfiguren = new Figur[33];
		schachfiguren = Figur.schachFigurenSetErstellen();
		Spielfeld[] spielfelder = new Spielfeld[64];
		spielfelder = Spielfeld.SchachSpielfelderErstellen();
		Spielbrett schachbrett = Spielbrett.SchachSpielbrettErstellen(spielfelder);
		
		Spielfeld.schachfigurenAufstellen(schachfiguren, spielfelder);
		
		//Spielbrett.spielbrettAnzeigen(schachbrett);
		Spielbrett.spielbrettVerdecktAnzeigen(schachbrett);
		
		boolean spielgewonnen=true;
		
		while(spielgewonnen) {
			spielzugSpieler1(schachbrett, schachfiguren);
			spielzugSpieler2(schachbrett, schachfiguren);

			if (schachfiguren[15].isAktiv() == false) {
				System.out.println("Spieler 2 hat gewonnen!!!\n\nSpieler 2 hat gewonnen!!!\n\nSpieler 2 hat gewonnen!!!");
				spielgewonnen = false;
			}

			if (schachfiguren[31].isAktiv() == false) {
				System.out.println("Spieler 1 hat gewonnen!!!\n\nSpieler 1 hat gewonnen!!!\n\nSpieler 1 hat gewonnen!!!");
				spielgewonnen = false;
			}
		}

	}
	
	private static void spielzugSpieler1(Spielbrett schachbrett, Figur[] schachfiguren){
		System.out.println("Spieler 1 ist am Zug:\n");
		Figur.spielzug(schachbrett, schachfiguren, 1);
		Spielbrett.spielbrettVerdecktAnzeigen(schachbrett);
	}
	private static void spielzugSpieler2(Spielbrett schachbrett, Figur[] schachfiguren){
		System.out.println("Spieler 2 ist am Zug:\n");
		Figur.spielzug(schachbrett, schachfiguren, 2);
		Spielbrett.spielbrettVerdecktAnzeigen(schachbrett);
	}
	

}
