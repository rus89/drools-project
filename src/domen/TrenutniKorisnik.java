package domen;

public class TrenutniKorisnik {

	private static TrenutniKorisnik obj;
	private Dom dom;
	private int pitanje;
	private char odgovor;
	private boolean odabrano;

	private TrenutniKorisnik() {
		dom = new Dom();
	}

	public static TrenutniKorisnik vratiObjekat() {
		if (obj == null)
			obj = new TrenutniKorisnik();
		return obj;
	}

	public static TrenutniKorisnik getObj() {
		return obj;
	}

	public static void setObj(TrenutniKorisnik obj) {
		TrenutniKorisnik.obj = obj;
	}

	public Dom getDom() {
		return dom;
	}

	public void setDom(Dom dom) {
		this.dom = dom;
	}

	public int getPitanje() {
		return pitanje;
	}

	public void setPitanje(int pitanje) {
		this.pitanje = pitanje;
	}

	public char getOdgovor() {
		return odgovor;
	}

	public void setOdgovor(char odgovor) {
		this.odgovor = odgovor;
	}

	public boolean isOdabrano() {
		return odabrano;
	}

	public void setOdabrano(boolean odabrano) {
		this.odabrano = odabrano;
	}

}
