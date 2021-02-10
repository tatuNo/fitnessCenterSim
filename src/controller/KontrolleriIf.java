package controller;

import javafx.concurrent.Task;
import view.AnimationOverviewController;

/**
 * Kontrollerin Interface.
 * @author Tatu Nordström
 * @author Nico Järvinen
 *
 */
public interface KontrolleriIf {
	
	// Rajapinta, joka tarjotaan  käyttöliittymälle:
	
	public void kaynnistaSimulointi();
	public void nopeuta();
	public void hidasta();
	public boolean asiakkaanSukupuoli(); 
	
	// Rajapinta, joka tarjotaan moottorille:
	
	public void naytaLoppuaika(double aika);
	public long getViive();
	public void AsiakasVtoPH();
	public void AsiakasPHtoR();
	public void visualisoiAsiakas();
	public int getId();
	public void setId(int id);
	void AsiakasRtoPH();
	void AsiakasPHtoF();
	void AsiakasFtoPH();
	void AsiakasPHtoRL();
	void AsiakasRLtoPH();
	void AsiakasPHtoK();
	void AsiakasKtoPH();
	void AsiakasPHtoJ();
	void AsiakasJtoPH();
	void AsiakasPHtoH();
	void AsiakasHtoPH();
	void AsiakasPHtoS();
	public void setRLSize(int jonoSize);
	public void setJuoksuSize(int jonoSize);
	public void setKuntosaliSize(int jonoSize);
	public void setFysioSize(int jonoSize);
	public void setRontgenSize(int jonoSize);
	public void setMPHSize(int jonoSize);
	public void setNPHSize(int jonoSize);
	public void setHierontaSize(int jonoSize);
	public void setVastaanottoSize(int jonoSize);
	void deleteAsiakkaat();
	void tallennaTulokset();
	int getJakaumaX();
	int getJakaumaY();
	int getPalveltutAsiakkaat();
	int getKaikkiAsiakkaat();
	double getAika();

}
