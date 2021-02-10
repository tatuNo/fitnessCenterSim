package osat;
import eduni.distributions.*;

/**
 * Luo simulaattorin saapumiset.
 * @author Tatu Nordström
 * @author Nico Järvinen
 *
 */
public class Saapumisprosessi {
	/** Simulaattorin moottori. */
	private Moottori moottori;
	/** Jakauma.*/
	private ContinuousGenerator generaattori;
	/** Saapumistapahtumien tyyppi. */
	private TapahtumanTyyppi tyyppi;
	
	/**
	 * Saapumisprosessin konstruktori
	 * @param m moottori luokka, jotta päästään käsiksi moottorin metodeihin.
	 * @param g jakauma, jonka perusteella palvelupiste luo tapahtumiaan tulevalle ajan hetkelle. Käytetään eduni.distributions pakkausta.
	 * @param tyyppi skeduloitavan tapahtuman tyyppi.
	 */
	public Saapumisprosessi(Moottori m, ContinuousGenerator g, TapahtumanTyyppi tyyppi){
		this.moottori = m;
		this.tyyppi = tyyppi;
		this.generaattori = g;
	}

	/**
	 * Luo seuraavan saapumistapahtuman tulevalle ajanhetkelle jakauman mukaan.
	 */
	public void generoiSeuraava(){
		Tapahtuma t = new Tapahtuma(tyyppi, Kello.getInstance().getAika()+generaattori.sample());
		moottori.uusiTapahtuma(t);
	}

}
