import java.util.Scanner;
import java.util.prefs.Preferences;
import javafx.scene.image.Image;

public class Figur {
	
	private int bewegungsmuster;
	private boolean aktiv;
	private String name;
	private int figurID;
	private String anzeigename;
	private int team;
	private int zugZaehler;
	private Image image;


	public Figur(int bewegungsmuster, boolean aktiv, String name, int figurID, String anzeigename, int team, int zugZaehler) {
		this.bewegungsmuster = bewegungsmuster;
		this.aktiv = aktiv;
		this.name = name;
		this.figurID = figurID;
		this.anzeigename = anzeigename;
		this.team = team;
		this.zugZaehler = zugZaehler;
	}

	public Image getImage() { return image; }

	public void setImage(Image image) { this.image = image; }

	public int getBewegungsmuster() {
		return bewegungsmuster;
	}

	public void setBewegungsmuster(int bewegungsmuster) {
		this.bewegungsmuster = bewegungsmuster;
	}

	public int getFigurID() {
		return figurID;
	}

	public void setFigurID(int figurID) {
		this.figurID = figurID;
	}

	public boolean isAktiv() {
		return aktiv;
	}

	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAnzeigename() {
		return anzeigename;
	}

	public void setAnzeigename(String anzeigename) {
		this.anzeigename = anzeigename;
	}
	
	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public int getZugZaehler() { return zugZaehler; }

	public void setZugZaehler(int zugZaehler) { this.zugZaehler = zugZaehler; }


	public static Figur[] schachFigurenSetErstellen() {
		
		Figur[] schachFigurenSet = new Figur[33];
		
		for (int i = 0; i < 8; i++) {											//schachFigurenSet[0]-schachFigurenSet[7] 			--> Bauern Spieler 1
			schachFigurenSet[i] = new Figur(1, true, "Bauer", i, "B-1", 1, 0);
		}
		
		schachFigurenSet[8] = new Figur(2, true, "Turm", 8, "T-1", 1, 0);				//schachFigurenSet[8]-schachFigurenSet[9] 		--> Türme Spieler 1
		schachFigurenSet[9] = new Figur(2, true, "Turm", 9, "T-1", 1, 0);
		
		schachFigurenSet[10] = new Figur(3, true, "Springer", 10, "S-1", 1, 0);			//schachFigurenSet[10]-schachFigurenSet[11] 	--> Springer Spieler 1
		schachFigurenSet[11] = new Figur(3, true, "Springer", 11, "S-1", 1, 0);
		
		schachFigurenSet[12] = new Figur(4, true, "Laeufer", 12, "L-1", 1, 0);			//schachFigurenSet[12]-schachFigurenSet[13] 	--> Laeufer Spieler 1
		schachFigurenSet[13] = new Figur(4, true, "Laeufer", 13, "L-1", 1, 0);
		
		schachFigurenSet[14] = new Figur(5, true, "Dame", 14, "D-1", 1, 0);				//schachFigurenSet[14]							--> Dame Spieler 1
		
		schachFigurenSet[15] = new Figur(6, true, "Koenig", 15, "K-1", 1, 0);			//schachFigurenSet[15]							--> Koenig Spieler 1
		
		
		
		for (int i = 16; i < 24; i++) {											//schachFigurenSet[16]-schachFigurenSet[23] 			--> Bauern Spieler 2
			schachFigurenSet[i] = new Figur(1, true, "Bauer", i, "B-2", 2, 0);
		}
		
		schachFigurenSet[24] = new Figur(2, true, "Turm", 24, "T-2", 2, 0);				//schachFigurenSet[24]-schachFigurenSet[25] 	--> Türme Spieler 2
		schachFigurenSet[25] = new Figur(2, true, "Turm", 25, "T-2", 2, 0);
		
		schachFigurenSet[26] = new Figur(3, true, "Springer", 26, "S-2", 2, 0);			//schachFigurenSet[26]-schachFigurenSet[27] 	--> Springer Spieler 2
		schachFigurenSet[27] = new Figur(3, true, "Springer", 27, "S-2", 2, 0);
		
		schachFigurenSet[28] = new Figur(4, true, "Laeufer", 28, "L-2", 2, 0);			//schachFigurenSet[28]-schachFigurenSet[29] 	--> Laeufer Spieler 2
		schachFigurenSet[29] = new Figur(4, true, "Laeufer", 29, "L-2", 2, 0);
		
		schachFigurenSet[30] = new Figur(5, true, "Dame", 30, "D-2", 2, 0);				//schachFigurenSet[30]							--> Dame Spieler 2
		
		schachFigurenSet[31] = new Figur(6, true, "Koenig", 31, "K-2", 2, 0);			//schachFigurenSet[31]							--> Koenig Spieler 2
		
		schachFigurenSet[32] = new Figur(0, false, "leer", 99, " ", 99, 99);			//schachFigurenSet[32]							--> Platzhalter leerfeld!
		
		return schachFigurenSet;
	}
	
	public static void spielzug(Spielbrett spielbrett, Figur[] schachFigurenSet, int team, Spielbrett schachbrettLetzteRunde) {
		
		//Auswahl der zu ziehenden Figur und Fehler anfangen
		Figur gewaehlteFigur = new Figur(0, false, "Platzhalter", 99, "PH", 99, 99);
		
		Scanner eingabe = new Scanner(System.in);
		String gewaehltesFeld = "99";
		char[] gewaehltesFeldChar = new char[2];
		int[] gewaehltesFeldInt = new int[2];
		boolean fehleingabe = true;
		
		System.out.println("Bitte waehlen sie das Feld aus indem die Figur steht, die sie ziehen moechten:\n");
		
		while(fehleingabe) {
			
			gewaehltesFeld = eingabe.next();
		gewaehltesFeldChar = gewaehltesFeld.toCharArray();
		gewaehltesFeldInt[0] = BewegungsMuster.buchstabeZuZahl(gewaehltesFeldChar);
		gewaehltesFeldInt[1] = BewegungsMuster.charZahlZuZahl(gewaehltesFeldChar);
			
				if ((gewaehltesFeldInt[0] == 9) || (gewaehltesFeldInt[1] == 9)) {
					System.out.println("Ungueltige Eingabe...\nBitte geben sie eine Koordinate von A1 bis H8 ein!\n");
				}
				else if (Spielbrett.spielfeldNachKoordinatenSuchen(gewaehltesFeldInt[1], gewaehltesFeldInt[0], spielbrett).getFigur().team != team) {
					System.out.println("Sie duerfen nur eigene Figuren bewegen");
				}
				else {
					fehleingabe=false;
					gewaehlteFigur = Spielbrett.spielfeldNachKoordinatenSuchen(gewaehltesFeldInt[1], gewaehltesFeldInt[0], spielbrett).getFigur();					
				}
		}

		//waehlen des gewuenschten Zielfeldes und Fehler abfangen
		String zielFeld = "99";
		char[] zielFeldChar = new char[2];
		int[] zielFeldInt = new int[2];
		fehleingabe = true;
		
		System.out.println("Bitte geben sie das Feld ein, auf das sie diese(n) " + gewaehlteFigur.getName() + " setzen moechten (A1 - H8):");
		
		while(fehleingabe) {
				
			zielFeld = eingabe.next();
			zielFeldChar = zielFeld.toCharArray();
			zielFeldInt[0] = BewegungsMuster.buchstabeZuZahl(zielFeldChar);
			zielFeldInt[1] = BewegungsMuster.charZahlZuZahl(zielFeldChar);
			
				if ((zielFeldInt[0] == 9) || (zielFeldInt[1] == 9)) {
					System.out.println("Ungueltige Eingabe...\nBitte geben sie eine Koordinate von A1 bis H8 ein!\n(qq zum Abbrechen, um eine andere Figur zu waehlen) ");
				}
				else if ((zielFeldInt[0] == 99) || (zielFeldInt[1] == 99)) {
					fehleingabe = false;
					spielzug(spielbrett, schachFigurenSet, team, schachbrettLetzteRunde);
				}
				else {
					//Validitaetsprüfung des eigegebenen Feldes 
					if (BewegungsMuster.spielzugUeberpruefung(gewaehlteFigur, gewaehltesFeldInt, zielFeldInt, spielbrett, team, schachFigurenSet)) {
						fehleingabe=false;
						//falls eine Figur geschlagen wird, wird sie auf inaktiv gesetzt(aktiv=false)
						if (Spielfeld.spielfeldNachKoordinatenSuchen(zielFeldInt[1], zielFeldInt[0], spielbrett).getFigur().isAktiv()) {
							Spielfeld.spielfeldNachKoordinatenSuchen(zielFeldInt[1], zielFeldInt[0], spielbrett).getFigur().setAktiv(false);
						}
						// ziehen der gewaehlten Figur auf das gewaehlte Feld
						// und auffüllen des verlassenen Feldes mit der Platzhalter-Figur
						// und inkrementieren des Zugzaehlers
						// und Speicherung des Spielbretts als schachbrettLetzteRunde
						schachbrettLetzteRunde = spielbrett;
						Spielfeld.spielfeldNachKoordinatenSuchen(gewaehltesFeldInt[1], gewaehltesFeldInt[0], spielbrett).getFigur().setZugZaehler( (Spielfeld.spielfeldNachKoordinatenSuchen(gewaehltesFeldInt[1], gewaehltesFeldInt[0], spielbrett).getFigur().getZugZaehler()+1) );
						Spielfeld.spielfeldNachKoordinatenSuchen(zielFeldInt[1], zielFeldInt[0], spielbrett).setFigur(gewaehlteFigur);
						Spielfeld.spielfeldNachKoordinatenSuchen(gewaehltesFeldInt[1], gewaehltesFeldInt[0], spielbrett).setFigur(schachFigurenSet[32]);
					}
					else {
						System.out.println("Dieser Zug ist nicht moeglich, bitte geben sie ein mit dieser Figur moegliches Zielfeld ein:\n(qq zum Abbrechen um eine andere Figur zu waehlen)");
					}
				}
		}
	}
}
