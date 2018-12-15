import java.util.Scanner;

public class BewegungsMuster {
	
	/*
	 * Bewegungsmuster als int-wert hinterlegt in Figur:
	 * Bauer 	= 	1
	 * Turm 	= 	2
	 * Springer	=	3
	 * Laeufer	=	4
	 * Dame		=	5
	 * Koenig	=	6
	 */
	
	
	
	public static boolean spielzugUeberpruefung(Figur figur, int[] startFeld, int[] zielFeld, Spielbrett spielbrett, int team, Figur[] schachFigurenSet) {
		
		boolean spielzugZulaessig = false;
		
		switch (figur.getBewegungsmuster()) {
		
			case 1: 
				spielzugZulaessig = bewegungBauer(figur, startFeld, zielFeld, spielbrett, team, schachFigurenSet);
				break;
			
			case 2:
				spielzugZulaessig = bewegungTurm(figur, startFeld, zielFeld, spielbrett, team);
				break;
			case 3:
				spielzugZulaessig = bewegungSpringer(figur, startFeld, zielFeld, spielbrett, team);
				break;
			case 4:
				spielzugZulaessig = bewegungLaeufer(figur, startFeld, zielFeld, spielbrett, team);
				break;
			case 5:
				spielzugZulaessig = bewegungDame(figur, startFeld, zielFeld, spielbrett, team);
				break;
			case 6:
				spielzugZulaessig = bewegungKoenig(figur, startFeld, zielFeld, spielbrett, team, schachFigurenSet);
				break;
				
		}		
		return spielzugZulaessig;
	}
	
	public static boolean bewegungBauer(Figur figur, int[] startFeld, int[] zielFeld, Spielbrett spielbrett, int team, Figur[] schachFigurenSet) {			//nur geradeaus, max. 1 Feld ACHTUNG: DIAGONALES SCHLAGEN VON FIGUREN fehlt noch!!!!
		
		boolean spielzugZulaessig = false;
		Scanner input = new Scanner(System.in);
		//Abfrage, zu welchem Team der Bauer gehört
		if (figur.getFigurID() >= 16 
		 && figur.getFigurID() < 24) {

			//2 Felder möglich, wenn der Bauer in Startposition steht, ansonsten 1 Feld

			if(startFeld[1] == 1) {
				if (((startFeld[0] == zielFeld[0]) 
						 && (startFeld[1] == (zielFeld[1]-1))
					||((startFeld[0] == zielFeld[0]) 
							 && (startFeld[1] == (zielFeld[1]-2))))
							 &&(!(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]+1), zielFeld[0], spielbrett).getFigur().isAktiv()))				//Kollisionsabfrage!
							 &&(!(Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().isAktiv()))) {				//Kollisionsabfrage!
							spielzugZulaessig = true;
						}
			}
			else {
				if ((startFeld[0] == zielFeld[0]) 
				 && (startFeld[1] == (zielFeld[1]-1))
				 	&&(!(Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().isAktiv()))) {				//Kollisionsabfrage!)
					
					spielzugZulaessig = true;
				}
			}
			//wenn diagonal vor dem Bauern eine Figur steht, darf er schlagen
			if (((Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().isAktiv()) && ((startFeld[0] == zielFeld[0]+1) && (startFeld[1] == (zielFeld[1]-1))))
					|| ((Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().isAktiv()) && ((startFeld[0] == zielFeld[0]-1) && (startFeld[1] == (zielFeld[1]-1))))) {
				spielzugZulaessig = true;
			}
		}
		//Abfrage, zu welchem Team der Bauer gehört
		else if (figur.getFigurID() >= 0 
			  && figur.getFigurID() < 8) {

			//2 Felder möglich, wenn der Bauer in Startposition steht, ansonsten 1 Feld

			if(startFeld[1] == 6) {
				if (((startFeld[0] == zielFeld[0]) 
						 && (startFeld[1] == (zielFeld[1]+1))
					||((startFeld[0] == zielFeld[0]) 
							 && (startFeld[1] == (zielFeld[1]+2))))
							 &&(!(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]-1), zielFeld[0], spielbrett).getFigur().isAktiv()))				//Kollisionsabfrage!
							 &&(!(Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().isAktiv()))) {				//Kollisionsabfrage!
							spielzugZulaessig = true;
				}
			}
			else {			
				if ((startFeld[0] == zielFeld[0]) 
				 && (startFeld[1] == (zielFeld[1]+1))
					&&(!(Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().isAktiv()))) {				//Kollisionsabfrage!
					spielzugZulaessig = true;
				}				
			}
			//wenn diagonal vor dem Bauern eine Figur steht, darf er schlagen
			if (((Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().isAktiv()) && ((startFeld[0] == zielFeld[0]+1) && (startFeld[1] == (zielFeld[1]+1))))
					|| ((Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().isAktiv()) && ((startFeld[0] == zielFeld[0]-1) && (startFeld[1] == (zielFeld[1]+1))))) {
				spielzugZulaessig = true;
			}
		}
		//Pruefung ob die Figur die geschlagen werden soll eine eigene ist
		if (Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().getTeam() == team) {
			System.out.println("Sie duerfen keine eigene Figur schlagen!");
			spielzugZulaessig = false;
		}

		//en passant:

		if ((team == 1) && (startFeld[1] == 3)
				&& (Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]+1), zielFeld[0], spielbrett).getFigur().getTeam() == 2)					// Spielfigur auf dem Feld ist im gegnerischen Team
				&& (Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]+1), zielFeld[0], spielbrett).getFigur().getBewegungsmuster() == 1)		// Spielfigur ist ein Bauer
				&& (Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]+1), zielFeld[0], spielbrett).getFigur().getZugZaehler() == 1)				// Spielfigur hat einen Zug gemacht -> 2 Felder gezogen
				&& ((zielFeld[1] == 2) && ((zielFeld[0] == startFeld[0]+1) || (zielFeld[0] == startFeld[0]-1)))	 ) {									// Zielfeld liegt diagonal vor Startfeld

			spielzugZulaessig = true;
			Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]+1), zielFeld[0], spielbrett).getFigur().setAktiv(false);
			Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]+1), zielFeld[0], spielbrett).setFigur(schachFigurenSet[32]);
			System.out.println("En passant!");
		}

		if ((team == 2) && (startFeld[1] == 4)
				&& (Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]-1), zielFeld[0], spielbrett).getFigur().getTeam() == 1)					// Spielfigur auf dem Feld ist im gegnerischen Team
				&& (Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]-1), zielFeld[0], spielbrett).getFigur().getBewegungsmuster() == 1)		// Spielfigur ist ein Bauer
				&& (Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]-1), zielFeld[0], spielbrett).getFigur().getZugZaehler() == 1)				// Spielfigur hat einen Zug gemacht -> 2 Felder gezogen
				&& ((zielFeld[1] == 5) && ((zielFeld[0] == startFeld[0]+1) || (zielFeld[0] == startFeld[0]-1)))	 ) {									// Zielfeld liegt diagonal vor Startfeld

			spielzugZulaessig = true;
			Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]-1), zielFeld[0], spielbrett).getFigur().setAktiv(false);
			Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]-1), zielFeld[0], spielbrett).setFigur(schachFigurenSet[32]);
			System.out.println("En passant!");
		}

		//Bauer zu einer gewaehlten Figur tauschen, wenn er die letzte Reihe erreicht (Spieler 1)
		String gewaehlteFigur = "";
		boolean figurGewaehlt=true;

		if (spielzugZulaessig) {

			while (figurGewaehlt && ((zielFeld[1] == 7) && (figur.getTeam() == 2) || (zielFeld[1] == 0) && (figur.getTeam() == 1))) {

				if ((zielFeld[1] == 0) && (figur.getTeam() == 1)) {
					System.out.println("Der Bauer hat die letzte Reihe erreicht, bitte waehlen sie eine Figur, durch die dieser Bauer ersetzt werden soll: (T fuer Turm, S fuer Springer, L fuer Laeufer, D fuer Dame)");
					gewaehlteFigur = input.next();

					switch (gewaehlteFigur) {
						case "T":
						case "t":
							figur.setBewegungsmuster(2);
							figur.setAnzeigename("T-1");
							figur.setName("Turm");
							figurGewaehlt = false;
							break;
						case "S":
						case "s":
							figur.setBewegungsmuster(3);
							figur.setAnzeigename("S-1");
							figur.setName("Springer");
							figurGewaehlt = false;
							break;
						case "L":
						case "l":
							figur.setBewegungsmuster(4);
							figur.setAnzeigename("L-1");
							figur.setName("Laeufer");
							figurGewaehlt = false;
							break;
						case "D":
						case "d":
							figur.setBewegungsmuster(5);
							figur.setAnzeigename("D-1");
							figur.setName("Dame");
							figurGewaehlt = false;
							break;
						default:
							System.out.println("ungueltige Eingabe.  Bitte geben sie eine Zahl von 2 bis 5 ein:");
					}
				}

				//Bauer zu einer gewaehlten Figur tauschen, wenn er die letzte Reihe erreicht (Spieler 2)
				if ((zielFeld[1] == 7) && (figur.getTeam() == 2)) {
					System.out.println("Der Bauer hat die letzte Reihe erreicht, bitte waehlen sie eine Figur, durch die dieser Bauer ersetzt werden soll: (T fuer Turm, S fuer Springer, L fuer Laeufer, D fuer Dame)");
					gewaehlteFigur = input.next();

					switch (gewaehlteFigur) {
						case "T":
						case "t":
							figur.setBewegungsmuster(2);
							figur.setAnzeigename("T-2");
							figur.setName("Turm");
							figurGewaehlt = false;
							break;
						case "S":
						case "s":
							figur.setBewegungsmuster(3);
							figur.setAnzeigename("S-2");
							figur.setName("Springer");
							figurGewaehlt = false;
							break;
						case "L":
						case "l":
							figur.setBewegungsmuster(4);
							figur.setAnzeigename("L-2");
							figur.setName("Laeufer");
							figurGewaehlt = false;
							break;
						case "D":
						case "d":
							figur.setBewegungsmuster(5);
							figur.setAnzeigename("D-2");
							figur.setName("Dame");
							figurGewaehlt = false;
							break;
						default:
							System.out.println("ungueltige Eingabe.  Bitte geben sie eine Zahl von 2 bis 5 ein:");
					}

				}

			}

		}

		return spielzugZulaessig;		
	}
	
	public static boolean bewegungTurm(Figur figur, int[] startFeld, int[] zielFeld, Spielbrett spielbrett, int team) {		//gerade Bewegeung, egal wie weit
		
		boolean spielzugZulaessig = false;
		int bewegungsrichtung = 0;
		
//		if (figur.getFigurID() == 8 
//		 || figur.getFigurID() == 9 
//		 || figur.getFigurID() == 24
//		 || figur.getFigurID() == 25) {
			
			if (((startFeld[0] == zielFeld[0]) 				//yKoordinate bleibt gleich und xKoordinate ERHOEHT sich um einen beliebigen Wert
			 && ((startFeld[1] == (zielFeld[1]+1))
			 || (startFeld[1] == (zielFeld[1]+2))
			 || (startFeld[1] == (zielFeld[1]+3))
			 || (startFeld[1] == (zielFeld[1]+4))
			 || (startFeld[1] == (zielFeld[1]+5))
			 || (startFeld[1] == (zielFeld[1]+6))
			 || (startFeld[1] == (zielFeld[1]+7))))) {
				spielzugZulaessig = true;
				bewegungsrichtung = 1;
			}
				
			if (((startFeld[0] == zielFeld[0])			 //yKoordinate bleibt gleich und xKoordinate VERRINGERT sich um einen beliebigen Wert
				&& ((startFeld[1] == (zielFeld[1]-1))
				|| (startFeld[1] == (zielFeld[1]-2))
				|| (startFeld[1] == (zielFeld[1]-3))
				|| (startFeld[1] == (zielFeld[1]-4))
				|| (startFeld[1] == (zielFeld[1]-5))
				|| (startFeld[1] == (zielFeld[1]-6))
				|| (startFeld[1] == (zielFeld[1]-7))))) {
			spielzugZulaessig = true;
			bewegungsrichtung = 2;
			}
			if ((startFeld[1] == zielFeld[1])			 	//xKoordinate bleibt gleich und YKoordinate ERHOEHT sich um einen beliebigen Wert
			&& ((startFeld[0] == (zielFeld[0]+1))
			|| (startFeld[0] == (zielFeld[0]+2))
			|| (startFeld[0] == (zielFeld[0]+3))
			|| (startFeld[0] == (zielFeld[0]+4))
			|| (startFeld[0] == (zielFeld[0]+5))
			|| (startFeld[0] == (zielFeld[0]+6))
			|| (startFeld[0] == (zielFeld[0]+7)))) {
				spielzugZulaessig = true;
				bewegungsrichtung = 3;
			}
				
			if ((startFeld[1] == zielFeld[1])			 //xKoordinate bleibt gleich und YKoordinate VERRINGERT sich um einen beliebigen Wert
				&& ((startFeld[0] == (zielFeld[0]-1))
				|| (startFeld[0] == (zielFeld[0]-2))
				|| (startFeld[0] == (zielFeld[0]-3))
				|| (startFeld[0] == (zielFeld[0]-4))
				|| (startFeld[0] == (zielFeld[0]-5))
				|| (startFeld[0] == (zielFeld[0]-6))
				|| (startFeld[0] == (zielFeld[0]-7))))   {
				spielzugZulaessig = true;
				bewegungsrichtung = 4;
			}
//		}
		//Kollisionsabfrage:
		if (bewegungsrichtung == 1) {
			for (int i = 1; i < (startFeld[1]-zielFeld[1]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]+i), (zielFeld[0]), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}

		if (bewegungsrichtung == 2) {
			for (int i = 1; i < (zielFeld[1]-startFeld[1]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]-i), (zielFeld[0]), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}

		if (bewegungsrichtung == 3) {
			for (int i = 1; i < (startFeld[0]-zielFeld[0]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]), (zielFeld[0]+i), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}

		if (bewegungsrichtung == 4) {
			for (int i = 1; i < (zielFeld[0]-startFeld[0]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]), (zielFeld[0]-i), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}

		if (Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().getTeam() == team) {
			System.out.println("Sie duerfen keine eigene Figur schlagen!");
			spielzugZulaessig = false;
		}

		return spielzugZulaessig;		
	}
	
	public static boolean bewegungSpringer(Figur figur, int[] startFeld, int[] zielFeld, Spielbrett spielbrett,int team) {			//2 Felder auf einer Achse 1 Feld auf der anderen
		
		boolean spielzugZulaessig = false;
		
//		if (figur.getFigurID() == 10 
//		 || figur.getFigurID() == 11 
//		 || figur.getFigurID() == 26
//		 || figur.getFigurID() == 27) {
			
			if ( ((startFeld[0]+1) == zielFeld[0]) && (startFeld[1]+2 == (zielFeld[1]))
			  || ((startFeld[0]+1) == zielFeld[0]) && (startFeld[1]-2 == (zielFeld[1]))	
			  || ((startFeld[0]-1) == zielFeld[0]) && (startFeld[1]+2 == (zielFeld[1]))	
			  || ((startFeld[0]-1) == zielFeld[0]) && (startFeld[1]-2 == (zielFeld[1]))	
			  || ((startFeld[0]+2) == zielFeld[0]) && (startFeld[1]+1 == (zielFeld[1]))	
			  || ((startFeld[0]+2) == zielFeld[0]) && (startFeld[1]-1 == (zielFeld[1]))	
			  || ((startFeld[0]-2) == zielFeld[0]) && (startFeld[1]+1 == (zielFeld[1]))	
			  || ((startFeld[0]-2) == zielFeld[0]) && (startFeld[1]-1 == (zielFeld[1]))	) {
				spielzugZulaessig = true;
			}
//		}

		if (Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().getTeam() == team) {
			System.out.println("Sie duerfen keine eigene Figur schlagen!");
			spielzugZulaessig = false;
		}

		return spielzugZulaessig;
	}
	
	public static boolean bewegungLaeufer(Figur figur, int[] startFeld, int[] zielFeld, Spielbrett spielbrett, int team) {			//Diagonale Bewegung, egal wie weit
		
		boolean spielzugZulaessig = false;
		int bewegungsrichtung = 0;
		
//		if (figur.getFigurID() == 12 
//		 || figur.getFigurID() == 13 
//		 || figur.getFigurID() == 28
//		|| figur.getFigurID() == 29) {
			
			for (int i = 1; i < 8; i++) {								// Beide Koordinaten ERHOEHEN sich um denselben Wert
				if ( (((startFeld[0] + i) == zielFeld[0]) 					
					&& ((startFeld[1] + i) == zielFeld[1])) ){
						spielzugZulaessig = true;
						bewegungsrichtung = 1;
					}
			}
			
			for (int i = 1; i < 8; i++) {								// Beide Koordinaten REDUZIEREN sich um denselben Wert
				if ((((startFeld[0] - i) == zielFeld[0]) 					
					&& ((startFeld[1] - i) == zielFeld[1])) ){
						spielzugZulaessig = true;
						bewegungsrichtung = 2;
					}
			}
			
			for (int i = 1; i < 8; i++) {								// Beide Koordinaten entwickeln sich umgekehrt proportional zueinander (x sinkt y steigt)
				if ((((startFeld[0] - i) == zielFeld[0]) 					
					&& ((startFeld[1] + i) == zielFeld[1])) ){
						spielzugZulaessig = true;
						bewegungsrichtung = 3;
					}
			}
			
			for (int i = 1; i < 8; i++) {								// Beide Koordinaten entwickeln sich umgekehrt proportional zueinander (x steigt y sinkt)
				if ((((startFeld[0] + i) == zielFeld[0]) 					
					&& ((startFeld[1] - i) == zielFeld[1])) ){
						spielzugZulaessig = true;
						bewegungsrichtung = 4;
					}
			}						
//		}

		//Kollisionsabfrage:

		if (bewegungsrichtung == 1) {
			for (int i = 1; i < (zielFeld[1]-startFeld[1]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]-i), (zielFeld[0]-i), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}

		if (bewegungsrichtung == 2) {
			for (int i = 1; i < (startFeld[1]-zielFeld[1]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]+i), (zielFeld[0]+i), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}

		if (bewegungsrichtung == 3) {
			for (int i = 1; i < (zielFeld[1]-startFeld[1]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]-i), (zielFeld[0]+i), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}

		if (bewegungsrichtung == 4) {
			for (int i = 1; i < (zielFeld[0]-startFeld[0]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]+i), (zielFeld[0]-i), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}

		if (Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().getTeam() == team) {
			System.out.println("Sie duerfen keine eigene Figur schlagen!");
			spielzugZulaessig = false;
		}

		return spielzugZulaessig;		
	}
	
	public static boolean bewegungDame(Figur figur, int[] startFeld, int[] zielFeld, Spielbrett spielbrett, int team) {			//Diagonale Bewegung, egal wie weit oder gerade Bewegeung, egal wie weit
		
		boolean spielzugZulaessig = false;
		int bewegungsrichtung = 0;
		
//		if (figur.getFigurID() == 14 
//		 || figur.getFigurID() == 30) {

		if (((startFeld[0] == zielFeld[0]) 				//YKoordinate bleibt gleich und XKoordinate ERHOEHT sich um einen beliebigen Wert
				&& ((startFeld[1] == (zielFeld[1]+1))
				|| (startFeld[1] == (zielFeld[1]+2))
				|| (startFeld[1] == (zielFeld[1]+3))
				|| (startFeld[1] == (zielFeld[1]+4))
				|| (startFeld[1] == (zielFeld[1]+5))
				|| (startFeld[1] == (zielFeld[1]+6))
				|| (startFeld[1] == (zielFeld[1]+7))))) {
			spielzugZulaessig = true;
			bewegungsrichtung = 1;
		}

		if (((startFeld[0] == zielFeld[0])			 //YKoordinate bleibt gleich und XKoordinate VERRINGERT sich um einen beliebigen Wert
				&& ((startFeld[1] == (zielFeld[1]-1))
				|| (startFeld[1] == (zielFeld[1]-2))
				|| (startFeld[1] == (zielFeld[1]-3))
				|| (startFeld[1] == (zielFeld[1]-4))
				|| (startFeld[1] == (zielFeld[1]-5))
				|| (startFeld[1] == (zielFeld[1]-6))
				|| (startFeld[1] == (zielFeld[1]-7))))) {
			spielzugZulaessig = true;
			bewegungsrichtung = 2;
		}
		if ((startFeld[1] == zielFeld[1])			 	//XKoordinate bleibt gleich und YKoordinate ERHOEHT sich um einen beliebigen Wert
				&& ((startFeld[0] == (zielFeld[0]+1))
				|| (startFeld[0] == (zielFeld[0]+2))
				|| (startFeld[0] == (zielFeld[0]+3))
				|| (startFeld[0] == (zielFeld[0]+4))
				|| (startFeld[0] == (zielFeld[0]+5))
				|| (startFeld[0] == (zielFeld[0]+6))
				|| (startFeld[0] == (zielFeld[0]+7)))) {
			spielzugZulaessig = true;
			bewegungsrichtung = 3;
		}

		if ((startFeld[1] == zielFeld[1])			 //XKoordinate bleibt gleich und YKoordinate VERRINGERT sich um einen beliebigen Wert
				&& ((startFeld[0] == (zielFeld[0]-1))
				|| (startFeld[0] == (zielFeld[0]-2))
				|| (startFeld[0] == (zielFeld[0]-3))
				|| (startFeld[0] == (zielFeld[0]-4))
				|| (startFeld[0] == (zielFeld[0]-5))
				|| (startFeld[0] == (zielFeld[0]-6))
				|| (startFeld[0] == (zielFeld[0]-7))))   {
			spielzugZulaessig = true;
			bewegungsrichtung = 4;
		}

		for (int i = 1; i < 8; i++) {								// Beide Koordinaten ERHOEHEN sich um denselben Wert
			if ( (((startFeld[0] + i) == zielFeld[0])
					&& ((startFeld[1] + i) == zielFeld[1])) ){
				spielzugZulaessig = true;
				bewegungsrichtung = 5;
			}
		}

		for (int i = 1; i < 8; i++) {								// Beide Koordinaten REDUZIEREN sich um denselben Wert
			if ((((startFeld[0] - i) == zielFeld[0])
					&& ((startFeld[1] - i) == zielFeld[1])) ){
				spielzugZulaessig = true;
				bewegungsrichtung = 6;
			}
		}

		for (int i = 1; i < 8; i++) {								// Beide Koordinaten entwickeln sich umgekehrt proportional zueinander (x sinkt y steigt)
			if ((((startFeld[0] - i) == zielFeld[0])
					&& ((startFeld[1] + i) == zielFeld[1])) ){
				spielzugZulaessig = true;
				bewegungsrichtung = 7;
			}
		}

		for (int i = 1; i < 8; i++) {								// Beide Koordinaten entwickeln sich umgekehrt proportional zueinander (x steigt y sinkt)
			if ((((startFeld[0] + i) == zielFeld[0])
					&& ((startFeld[1] - i) == zielFeld[1])) ){
				spielzugZulaessig = true;
				bewegungsrichtung = 8;
			}
		}

		//Kollisionsabfrage:
		if (bewegungsrichtung == 1) {
			for (int i = 1; i < (startFeld[1]-zielFeld[1]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]+i), (zielFeld[0]), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}

		if (bewegungsrichtung == 2) {
			for (int i = 1; i < (zielFeld[1]-startFeld[1]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]-i), (zielFeld[0]), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}

		if (bewegungsrichtung == 3) {
			for (int i = 1; i < (startFeld[0]-zielFeld[0]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]), (zielFeld[0]+i), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}

		if (bewegungsrichtung == 4) {
			for (int i = 1; i < (zielFeld[0]-startFeld[0]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]), (zielFeld[0]-i), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}

		if (bewegungsrichtung == 5) {
			for (int i = 1; i < (zielFeld[1]-startFeld[1]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]-i), (zielFeld[0]-i), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}

		if (bewegungsrichtung == 6) {
			for (int i = 1; i < (startFeld[1]-zielFeld[1]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]+i), (zielFeld[0]+i), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}

		if (bewegungsrichtung == 7) {
			for (int i = 1; i < (zielFeld[1]-startFeld[1]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]-i), (zielFeld[0]+i), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}

		if (bewegungsrichtung == 8) {
			for (int i = 1; i < (zielFeld[0]-startFeld[0]); i++) {
				if(Spielfeld.spielfeldNachKoordinatenSuchen((zielFeld[1]+i), (zielFeld[0]-i), spielbrett).getFigur().isAktiv()) {
					spielzugZulaessig = false;
				}
			}
		}
//		}

		if (Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().getTeam() == team) {
			System.out.println("Sie duerfen keine eigene Figur schlagen!");
			spielzugZulaessig = false;
		}

		return spielzugZulaessig;		
	}
	
	public static boolean bewegungKoenig(Figur figur, int[] startFeld, int[] zielFeld, Spielbrett spielbrett, int team, Figur[] schachFigurenSet) {			// Beliebige Richtung, aber nur 1 Feld
		
		boolean spielzugZulaessig = false;
		
//		if (figur.getFigurID() == 15 
//		 || figur.getFigurID() == 31) {
			
			if ( (((startFeld[0] + 1) == zielFeld[0]) 					
				&&((startFeld[1]) == zielFeld[1])) 
					
			||	 (((startFeld[0] - 1) == zielFeld[0]) 					
			    &&((startFeld[1]) == zielFeld[1])) 
			
			||	 (((startFeld[0]) == zielFeld[0]) 					
				&&((startFeld[1] + 1) == zielFeld[1])) 
			
			||	 (((startFeld[0]) == zielFeld[0]) 					
				&&((startFeld[1] - 1) == zielFeld[1])) 
			
			||	 (((startFeld[0] + 1) == zielFeld[0]) 					
				&&((startFeld[1] + 1) == zielFeld[1])) 
			
			||	 (((startFeld[0] - 1) == zielFeld[0]) 					
				&&((startFeld[1] - 1) == zielFeld[1]))
			
			||	 (((startFeld[0] + 1) == zielFeld[0]) 					
				&&((startFeld[1] - 1) == zielFeld[1]))
			
			||	 (((startFeld[0] - 1) == zielFeld[0]) 					
				&&((startFeld[1] + 1) == zielFeld[1])) ) {
			spielzugZulaessig = true;
			}

			//Rochade:

			if (team == 1) {
				if ( (figur.getZugZaehler() == 0) && (schachFigurenSet[8].getZugZaehler() == 0)																//Koenig und betroffener Turm wurden noch nicht bewegt
					&& (!(Spielfeld.spielfeldNachKoordinatenSuchen(7, 1, spielbrett).getFigur().isAktiv()))							//Ueberpruefung der Felder zwischen Turm und Koenig
					&& (!(Spielfeld.spielfeldNachKoordinatenSuchen(7, 2, spielbrett).getFigur().isAktiv()))
					&& (!(Spielfeld.spielfeldNachKoordinatenSuchen(7, 3, spielbrett).getFigur().isAktiv())) ) {

					if ((zielFeld[1] == 7) && (zielFeld[0] == 2)) {
						spielzugZulaessig = true;
						Spielfeld.spielfeldNachKoordinatenSuchen(7, 3, spielbrett).setFigur(schachFigurenSet[8]);						//Umsetzen des Turms (Koenig wird "normal" gesetzt)
						Spielfeld.spielfeldNachKoordinatenSuchen(7, 0, spielbrett).setFigur(schachFigurenSet[32]);					//Ursprungsfeld des Turmes wird "leer" gesetzt (Platzhalter)
						System.out.println("ROCHADE!");
					}
				}
			}

			if (team == 1) {
				if ((figur.getZugZaehler() == 0) && (schachFigurenSet[9].getZugZaehler() == 0)																//Koenig und betroffener Turm wurden noch nicht bewegt
						&& (!(Spielfeld.spielfeldNachKoordinatenSuchen(7, 5, spielbrett).getFigur().isAktiv()))						//Ueberpruefung der Felder zwischen Turm und Koenig
						&& (!(Spielfeld.spielfeldNachKoordinatenSuchen(7, 6, spielbrett).getFigur().isAktiv())) ) {

					if ((zielFeld[1] == 7) && (zielFeld[0] == 6)) {
						spielzugZulaessig = true;
						Spielfeld.spielfeldNachKoordinatenSuchen(7, 5, spielbrett).setFigur(schachFigurenSet[9]);						//Umsetzen des Turms (Koenig wird "normal" gesetzt)
						Spielfeld.spielfeldNachKoordinatenSuchen(7, 7, spielbrett).setFigur(schachFigurenSet[32]);					//Ursprungsfeld des Turmes wird "leer" gesetzt (Platzhalter)
						System.out.println("ROCHADE!");
					}
				}
			}

			if (team == 2) {
				if ((figur.getZugZaehler() == 0) && (schachFigurenSet[24].getZugZaehler() == 0)																//Koenig und betroffener Turm wurden noch nicht bewegt
						&& (!(Spielfeld.spielfeldNachKoordinatenSuchen(0, 1, spielbrett).getFigur().isAktiv()))						//Ueberpruefung der Felder zwischen Turm und Koenig
						&& (!(Spielfeld.spielfeldNachKoordinatenSuchen(0, 2, spielbrett).getFigur().isAktiv()))
						&& (!(Spielfeld.spielfeldNachKoordinatenSuchen(0, 3, spielbrett).getFigur().isAktiv())) ) {

					if ((zielFeld[1] == 0) && (zielFeld[0] == 2)) {
						spielzugZulaessig = true;
						Spielfeld.spielfeldNachKoordinatenSuchen(0, 3, spielbrett).setFigur(schachFigurenSet[24]);					//Umsetzen des Turms (Koenig wird "normal" gesetzt)
						Spielfeld.spielfeldNachKoordinatenSuchen(0, 0, spielbrett).setFigur(schachFigurenSet[32]);					//Ursprungsfeld des Turmes wird "leer" gesetzt (Platzhalter)
						System.out.println("ROCHADE!");
					}
				}
			}

			if (team == 2) {
				if ((figur.getZugZaehler() == 0) && (schachFigurenSet[25].getZugZaehler() == 0)																//Koenig und betroffener Turm wurden noch nicht bewegt
						&& (!(Spielfeld.spielfeldNachKoordinatenSuchen(0, 5, spielbrett).getFigur().isAktiv()))						//Ueberpruefung der Felder zwischen Turm und Koenig
						&& (!(Spielfeld.spielfeldNachKoordinatenSuchen(0, 6, spielbrett).getFigur().isAktiv())) ) {

					if ((zielFeld[1] == 0) && (zielFeld[0] == 6)) {
						spielzugZulaessig = true;
						Spielfeld.spielfeldNachKoordinatenSuchen(0, 5, spielbrett).setFigur(schachFigurenSet[25]);					//Umsetzen des Turms (Koenig wird "normal" gesetzt)
						Spielfeld.spielfeldNachKoordinatenSuchen(0, 7, spielbrett).setFigur(schachFigurenSet[32]);					//Ursprungsfeld des Turmes wird "leer" gesetzt (Platzhalter)
						System.out.println("ROCHADE!");
					}
				}
			}

//		}

		if (Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().getTeam() == team) {
			System.out.println("Sie duerfen keine eigene Figur schlagen!");
			spielzugZulaessig = false;
		}

		return spielzugZulaessig;
	}
	
	
	
	
	
	
	public static int buchstabeZuZahl(char[] feldkoordinate) {
		
		int yKoordinate=9;

		switch (feldkoordinate[0]) {
			case 'a':
			case 'A':
				yKoordinate = 0;
				break;
			case 'b':
			case 'B':
				yKoordinate = 1;
				break;
			case 'c':
			case 'C':
				yKoordinate = 2;
				break;
			case 'd':
			case 'D':
				yKoordinate = 3;
				break;
			case 'e':
			case 'E':
				yKoordinate = 4;
				break;
			case 'f':
			case 'F':
				yKoordinate = 5;
				break;
			case 'g':
			case 'G':
				yKoordinate = 6;
				break;
			case 'h':
			case 'H':
				yKoordinate = 7;
				break;
			case 'q':
			case 'Q':
				yKoordinate =99;
				break;
			default:
				yKoordinate = 9;                                                            // 9 = Fehleingabe

				break;
		}
				
		return yKoordinate;
	}
	
	
	
	public static int charZahlZuZahl(char[] feldkoordinate) {
		
		int xKoordinate=9;

		switch (feldkoordinate[1]) {
			case '1':
				xKoordinate = 0;
				break;
			case '2':
				xKoordinate = 1;
				break;
			case '3':
				xKoordinate = 2;
				break;
			case '4':
				xKoordinate = 3;
				break;
			case '5':
				xKoordinate = 4;
				break;
			case '6':
				xKoordinate = 5;
				break;
			case '7':
				xKoordinate = 6;
				break;
			case '8':
				xKoordinate = 7;
				break;
			case 'q':
			case 'Q':
				xKoordinate =99;
				break;
			default:
				xKoordinate = 9;                                                            // 9 = Fehleingabe
				break;
		}
				
		return xKoordinate;
	}

}
