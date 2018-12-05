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
	
	
	
	public static boolean spielzugUeberpruefung(Figur figur, int[] startFeld, int[] zielFeld, Spielbrett spielbrett, int team) {
		
		boolean spielzugZulaessig = false;
		
		switch (figur.getBewegungsmuster()) {
		
			case 1: 
				spielzugZulaessig = bewegungBauer(figur, startFeld, zielFeld, spielbrett, team);
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
				spielzugZulaessig = bewegungKoenig(figur, startFeld, zielFeld, spielbrett, team);
				break;
				
		}		
		return spielzugZulaessig;
	}
	
	public static boolean bewegungBauer(Figur figur, int[] startFeld, int[] zielFeld, Spielbrett spielbrett, int team) {			//nur geradeaus, max. 1 Feld ACHTUNG: DIAGONALES SCHLAGEN VON FIGUREN fehlt noch!!!!
		
		boolean spielzugZulaessig = false;
		Scanner input = new Scanner(System.in);
		
		if (figur.getFigurID() >= 16 
		 && figur.getFigurID() < 24) {
			
			if(startFeld[1] == 1) {
				if (((startFeld[0] == zielFeld[0]) 
						 && (startFeld[1] == (zielFeld[1]-1))
					||((startFeld[0] == zielFeld[0]) 
							 && (startFeld[1] == (zielFeld[1]-2))))
							 &&(!(Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1]+1, zielFeld[0], spielbrett).getFigur().isAktiv()))				//Kollisionsabfrage!
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
			if (((Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().isAktiv()) && ((startFeld[0] == zielFeld[0]+1) && (startFeld[1] == (zielFeld[1]+1)))) 
					|| ((Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().isAktiv()) && ((startFeld[0] == zielFeld[0]-1) && (startFeld[1] == (zielFeld[1]+1))))) {
				spielzugZulaessig = true;
			}
		}
		else if (figur.getFigurID() >= 0 
			  && figur.getFigurID() < 8) {
			
			if(startFeld[1] == 6) {
				if (((startFeld[0] == zielFeld[0]) 
						 && (startFeld[1] == (zielFeld[1]+1))
					||((startFeld[0] == zielFeld[0]) 
							 && (startFeld[1] == (zielFeld[1]+2))))
							 &&(!(Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1]-1, zielFeld[0], spielbrett).getFigur().isAktiv()))				//Kollisionsabfrage!
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
			if (((Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().isAktiv()) && ((startFeld[0] == zielFeld[0]+1) && (startFeld[1] == (zielFeld[1]+1)))) 
					|| ((Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().isAktiv()) && ((startFeld[0] == zielFeld[0]-1) && (startFeld[1] == (zielFeld[1]+1))))) {
				spielzugZulaessig = true;
			}
		}

		if (Spielfeld.spielfeldNachKoordinatenSuchen(zielFeld[1], zielFeld[0], spielbrett).getFigur().getTeam() == team) {
			System.out.println("Sie duerfen keine eigene Figur schlagen!");
			spielzugZulaessig = false;
		}

		//Bauer zu einer gewaehlten Figur tauschen, wenn er die letzte Reihe erreicht
		int gewaehlteFigur = 1;
		boolean figurGewaehlt=true;

		while(figurGewaehlt && ( (zielFeld[1] == 7) && (figur.getTeam() ==2) || (zielFeld[1] == 0) && (figur.getTeam() ==1) ) ) {

			if ((zielFeld[1] == 0) && (figur.getTeam() ==1)) {
				System.out.println("Der Bauer hat die letzte Reihe erreicht, bitte waehlen sie eine Figur, durch die dieser Bauer ersetzt werden soll: (2 fuer Turm, 3 fuer Springer, 4 fuer Laeufer, 5 fuer Dame)");
				gewaehlteFigur = input.nextInt();

				switch (gewaehlteFigur) {
					case 2:
						figur.setBewegungsmuster(2);
						figur.setAnzeigename("T-1");
						figur.setName("Turm");
						figurGewaehlt=false;
						break;
					case 3:
						figur.setBewegungsmuster(3);
						figur.setAnzeigename("S-1");
						figur.setName("Springer");
						figurGewaehlt=false;
						break;
					case 4:
						figur.setBewegungsmuster(4);
						figur.setAnzeigename("L-1");
						figur.setName("Laeufer");
						figurGewaehlt=false;
						break;
					case 5:
						figur.setBewegungsmuster(5);
						figur.setAnzeigename("D-1");
						figur.setName("Dame");
						figurGewaehlt=false;
						break;
					default:
						System.out.println("ungueltige Eingabe.  Bitte geben sie eine Zahl von 2 bis 5 ein:");
				}

			}

			if ((zielFeld[1] == 7) && (figur.getTeam() ==2)) {
				System.out.println("Der Bauer hat die letzte Reihe erreicht, bitte waehlen sie eine Figur, durch die dieser Bauer ersetzt werden soll: (2 fuer Turm, 3 fuer Springer, 4 fuer Laeufer, 5 fuer Dame)");
				gewaehlteFigur = input.nextInt();

				switch (gewaehlteFigur) {
					case 2:
						figur.setBewegungsmuster(2);
						figur.setAnzeigename("T-2");
						figur.setName("Turm");
						figurGewaehlt=false;
						break;
					case 3:
						figur.setBewegungsmuster(3);
						figur.setAnzeigename("S-2");
						figur.setName("Springer");
						figurGewaehlt=false;
						break;
					case 4:
						figur.setBewegungsmuster(4);
						figur.setAnzeigename("L-2");
						figur.setName("Laeufer");
						figurGewaehlt=false;
						break;
					case 5:
						figur.setBewegungsmuster(5);
						figur.setAnzeigename("D-2");
						figur.setName("Dame");
						figurGewaehlt=false;
						break;
					default:
						System.out.println("ungueltige Eingabe.  Bitte geben sie eine Zahl von 2 bis 5 ein:");
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
	
	public static boolean bewegungKoenig(Figur figur, int[] startFeld, int[] zielFeld, Spielbrett spielbrett, int team) {			// Beliebige Richtung, aber nur 1 Feld
		
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
			spielzugZulaessig=true;
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
			default:
				xKoordinate = 9;                                                            // 9 = Fehleingabe
				break;
		}
				
		return xKoordinate;
	}

}
