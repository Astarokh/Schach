
public class Spielfeld {

	private int xKoordinate;
	private int YKoordinate;
	private boolean belegt;
	private Figur figur;
	private int spielfeldID;
	private boolean aufgedeckt;
	
	public Spielfeld(int xKoordinate, int yKoordinate, boolean belegt, Figur figur, int spielfeldID) {
		this.xKoordinate = xKoordinate;
		this.YKoordinate = yKoordinate;
		this.belegt = belegt;
		this.figur = figur;
		this.spielfeldID=spielfeldID;
		this.aufgedeckt=false;
	}

	public int getXKoordinate() {
		return xKoordinate;
	}

	public void setXKoordinate(int xKoordinate) {
		this.xKoordinate = xKoordinate;
	}

	public int getYKoordinate() {
		return YKoordinate;
	}

	public void setYKoordinate(int yKoordinate) {
		YKoordinate = yKoordinate;
	}

	public boolean getBelegt() {
		return belegt;
	}

	public void setBelegt(boolean belegt) {
		this.belegt = belegt;
	}

	public Figur getFigur() {
		return figur;
	}

	public void setFigur(Figur figur) {
		this.figur = figur;
	}
	
	public int getSpielfeldID() {
		return spielfeldID;
	}

	public void setSpielfeldID(int spielfeldID) {
		this.spielfeldID = spielfeldID;
	}

	public boolean getAufgedeckt() {
		return aufgedeckt;
	}

	public void setAufgedeckt(boolean aufgedeckt) {
		this.aufgedeckt = aufgedeckt;
	}	
	
	public static Spielfeld[] SchachSpielfelderErstellen() {
		
		Spielfeld[] spielfeld = new Spielfeld[64];
		Figur platzhalter = new Figur(0, false, "leer", 99, " ", 99);
		int zaehler1 = 0;
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {				
					spielfeld[zaehler1] = new Spielfeld((i), j, false, platzhalter, zaehler1);
					zaehler1++;
			}			
		}
		
		return spielfeld;
	}
	
	public static Spielfeld[] schachfigurenAufstellen(Figur[] schachfiguren, Spielfeld[] spielfeld) {
		
		Spielfeld[] schachbrett = spielfeld;
		
		schachbrett[0].setFigur(schachfiguren[24]);						//obere Brettseite (schwarze Figuren / Spieler 2)
		schachbrett[1].setFigur(schachfiguren[26]);
		schachbrett[2].setFigur(schachfiguren[28]);
		schachbrett[3].setFigur(schachfiguren[30]);
		schachbrett[4].setFigur(schachfiguren[31]);
		schachbrett[5].setFigur(schachfiguren[29]);
		schachbrett[6].setFigur(schachfiguren[27]);
		schachbrett[7].setFigur(schachfiguren[25]);
		schachbrett[8].setFigur(schachfiguren[16]);
		schachbrett[9].setFigur(schachfiguren[17]);
		schachbrett[10].setFigur(schachfiguren[18]);
		schachbrett[11].setFigur(schachfiguren[19]);
		schachbrett[12].setFigur(schachfiguren[20]);
		schachbrett[13].setFigur(schachfiguren[21]);
		schachbrett[14].setFigur(schachfiguren[22]);
		schachbrett[15].setFigur(schachfiguren[23]);
		
		schachbrett[48].setFigur(schachfiguren[0]);						//untere Brettseite (wei�e Figuren / Spieler 1)
		schachbrett[49].setFigur(schachfiguren[1]);
		schachbrett[50].setFigur(schachfiguren[2]);
		schachbrett[51].setFigur(schachfiguren[3]);
		schachbrett[52].setFigur(schachfiguren[4]);
		schachbrett[53].setFigur(schachfiguren[5]);
		schachbrett[54].setFigur(schachfiguren[6]);
		schachbrett[55].setFigur(schachfiguren[7]);
		schachbrett[56].setFigur(schachfiguren[8]);
		schachbrett[57].setFigur(schachfiguren[10]);
		schachbrett[58].setFigur(schachfiguren[12]);
		schachbrett[59].setFigur(schachfiguren[14]);
		schachbrett[60].setFigur(schachfiguren[15]);
		schachbrett[61].setFigur(schachfiguren[13]);
		schachbrett[62].setFigur(schachfiguren[11]);
		schachbrett[63].setFigur(schachfiguren[9]);
		
		return schachbrett;
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
