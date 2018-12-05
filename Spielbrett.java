
public class Spielbrett {

	private int[] xAchse;
	private int[] yAchse;
	private Spielfeld[] spielfelder;
	
	public Spielbrett(int[] xAchse, int[] yAchse, Spielfeld[] spielfelder) {
		this.xAchse = xAchse;
		this.yAchse = yAchse;
		this.spielfelder = spielfelder;
	}
	
	public Spielbrett(int xAchsenLaenge, int yAchsenLaenge, Spielfeld[] spielfelder) {
		
		for (int i = 0; i < xAchsenLaenge; i++) {
			this.xAchse[i]=i;
		}
		
		for (int i = 0; i < yAchsenLaenge; i++) {
			this.yAchse[i]=i;
		}
				
		this.spielfelder = spielfelder;
	}

	public int[] getxAchse() {
		return xAchse;
	}

	public void setxAchse(int[] xAchse) {
		this.xAchse = xAchse;
	}

	public int[] getyAchse() {
		return yAchse;
	}

	public void setyAchse(int[] yAchse) {
		this.yAchse = yAchse;
	}

	public Spielfeld[] getSpielfelder() {
		return spielfelder;
	}

	public void setSpielfelder(Spielfeld[] spielfelder) {
		this.spielfelder = spielfelder;
	}
	
	public static Spielbrett SchachSpielbrettErstellen(Spielfeld[] spielfelder) {
		
		
		int[] xAchse = new int[8];
		int[] yAchse = new int[8];
		
		for (int i = 0; i < 8; i++) {
			xAchse[i]=i;
		}
		
		for (int i = 0; i < 8; i++) {
			yAchse[i]=i;
		}
		
		Spielbrett spielbrett = new Spielbrett(xAchse, yAchse, spielfelder);
		
		return spielbrett;
	}
	
	public static void spielbrettVerdecktAnzeigen(Spielbrett spielbrett) {
	
		int[] zahlenYKoordinaten = {1, 2, 3, 4, 5, 6, 7, 8};
	
		System.out.println("        Y\t|        \t|        \t|        \t|        \t|        \t|        \t|        \t|        \t|");
		System.out.println("         \t|     A  \t|     B  \t|     C  \t|     D  \t|     E  \t|     F  \t|     G  \t|     H  \t|");
		System.out.println("   X     \t|        \t|        \t|        \t|        \t|        \t|        \t|        \t|        \t|");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("        \t|        \t|        \t|        \t|        \t|        \t|        \t|        \t|        \t|");
		
		for (int i = 0; i < spielbrett.xAchse.length; i++) {
			
			System.out.print("     " + zahlenYKoordinaten[i] + "   \t|");
			
			for (int j = 0; j < spielbrett.yAchse.length; j++) {
				
					if(spielfeldNachKoordinatenSuchen(i,j,spielbrett).getFigur().getName().equalsIgnoreCase("leer")) {
						System.out.print("          \t|");
					}
					else {
						System.out.print("    " + spielfeldNachKoordinatenSuchen(i,j,spielbrett).getFigur().getAnzeigename() + "  \t|");			//(char)27 +"[31m - Escape Sequence und Formatierung des Strings
						//System.out.print("       " + spielfeldNachKoordinatenSuchen(i,j,spielbrett).getXKoordinate() + spielfeldNachKoordinatenSuchen(i,j,spielbrett).getYKoordinate() + "  \t|");
					}
				
			}
			System.out.println("\n        \t|        \t|        \t|        \t|        \t|        \t|        \t|        \t|        \t|");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.println("        \t|        \t|        \t|        \t|        \t|        \t|        \t|        \t|        \t|");
		}
		
	}
	
	public static void spielbrettAnzeigen(Spielbrett spielbrett) {
		
		for (int i = 0; i < spielbrett.xAchse.length; i++) {
			for (int j = 0; j < spielbrett.yAchse.length; j++) {
				System.out.print(spielfeldNachKoordinatenSuchen(i,j,spielbrett).getFigur().getName() + "\t");
			}
			System.out.println("\n\n");
		}
		
	}
	
	public static Spielfeld spielfeldNachKoordinatenSuchen(int xKoordinate, int yKoordinate, Spielbrett spielbrett) {
		
		Spielfeld[] moeglicheFelder = new Spielfeld[spielbrett.getSpielfelder().length];
		Spielfeld[] aktuellesSpielfeld = spielbrett.getSpielfelder();
		int zaehler2 = 0;
		Spielfeld spielfeld = aktuellesSpielfeld[0];
		
		for (int i = 0; i <moeglicheFelder.length; i++){
			if(aktuellesSpielfeld[i].getXKoordinate() == xKoordinate) {					
				moeglicheFelder[zaehler2] = aktuellesSpielfeld[i];
				zaehler2++;
			}
		}
		
		for (int i = 0; i <zaehler2; i++){
			if(moeglicheFelder[i].getYKoordinate() == yKoordinate) {
				spielfeld = moeglicheFelder[i];
			}
		}
		
		
		
		return spielfeld;
	}
	
	
	
	
	
}
