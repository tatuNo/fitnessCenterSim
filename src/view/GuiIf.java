package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Circle;

public interface GuiIf {
	
	// Kontrolleri tarvitsee syötteitä, jotka se välittää Moottorille
	public double getAika();
	public long getViive();

	//Kontrolleri antaa käyttöliittymälle tuloksia, joita Moottori tuottaa 
	public void setLoppuaika(double aika);
	void vastaanottoToPH();
	void PHtoR();
	int getId();
	void RtoPH();
	void PHtoF();
	void FtoPH();
	void PHtoRL();
	void RLtoPH();
	void PHtoK();
	void KtoPH();
	void PHtoJ();
	void JtoPH();
	void PHtoH();
	void HtoPH();
	void PHtoS();
	public void setVastaanottoAsiakkaat(int jonoSize);
	public void setRLAsiakkaat(int jonoSize);
	public void setKuntosaliAsiakkaat(int jonoSize);
	public void setFysioAsiakkaat(int jonoSize);
	public void setRontgenAsiakkaat(int jonoSize);
	public void setHierontaAsiakkaat(int jonoSize);
	public void setMPHAsiakkaat(int jonoSize);
	public void setNPHAsiakkaat(int jonoSize);
	public void setJuoksuAsiakkaat(int jonoSize);
	void deleteAllAsiakkaat();
	int getJakaumaX();
	int getJakaumaY();
	int getPalveltutAsiakkaat();
	int getKaikkiAsiakkaat();
	void createAsiakas();
	double getAikaT();
}
