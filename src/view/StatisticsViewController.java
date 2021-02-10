package view;

import java.net.URL;
import java.util.ResourceBundle;



import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import osat.ISuorituskykysuureetDAO;
import osat.Suorituskykysuureet;
import osat.SuorituskykysuureetAccessObject;

/**
 * Luokka, joka kontrolloi StatisticsViewiä, jossa esitämme simulointituloksia TableView näkymässä.
 * @author Tatu Nordström
 *
 */
public class StatisticsViewController  {
	
	
	private Main main;
	/** FXML Tabit jokaiselle taulululle. */
	@FXML
	private Tab hierontaTab;
	@FXML
	private Tab fysioTab;
	@FXML
	private Tab kuntosaliTab;
	@FXML
	private Tab juoksuTab;
	@FXML
	private Tab miestenPHTab;
	@FXML
	private Tab naistenPHTab;
	@FXML
	private Tab rontgenTab;
	@FXML
	private Tab vastaanottoTab;
	@FXML
	private Tab ryhmaliikuntaTab;
	/**TableViewit jokaiselle taululle. */
	@FXML
	private TableView<Object> ryhmaliikuntaTable;
	@FXML
	private TableView <Object> vastaanottoTable;
	@FXML
	private TableView<Object> rontgenTable;
	@FXML
	private TableView<Object> naistenPHTable;
	@FXML
	private TableView <Object> kuntosaliTable;
	@FXML
	private TableView <Object> juoksuTable;
	@FXML
	private TableView <Object> hierontaTable;
	@FXML
	private TableView <Object> fysio;
	@FXML
	private TableView<Object> miestenPHTable;
	/**Päiväys sarakkeet. */
	@FXML
	private TableColumn<Suorituskykysuureet, String> paivays; @FXML TableColumn <Suorituskykysuureet, String> paivays2; @FXML TableColumn <Suorituskykysuureet, String> paivays3; @FXML TableColumn <Suorituskykysuureet, String> paivays4; @FXML TableColumn <Suorituskykysuureet, String> paivays5; @FXML TableColumn <Suorituskykysuureet, String> paivays6; @FXML TableColumn <Suorituskykysuureet, String> paivays7; @FXML TableColumn <Suorituskykysuureet, String> paivays8; @FXML TableColumn <Suorituskykysuureet, String> paivays9;
	/**Simulointiaika sarakkeet. */
	@FXML
	private TableColumn<Suorituskykysuureet, Integer> simulointiaika;@FXML TableColumn<Suorituskykysuureet, Integer> simulointiaika2;;@FXML TableColumn<Suorituskykysuureet, Integer> simulointiaika3; @FXML TableColumn<Suorituskykysuureet, Integer> simulointiaika4; @FXML TableColumn<Suorituskykysuureet, Integer> simulointiaika5; @FXML TableColumn<Suorituskykysuureet, Integer> simulointiaika6; @FXML TableColumn<Suorituskykysuureet, Integer> simulointiaika7; @FXML TableColumn<Suorituskykysuureet, Integer> simulointiaika8; @FXML TableColumn<Suorituskykysuureet, Integer> simulointiaika9;
	/**Palveltut asiakkaat sarakkeet. */
	@FXML
	private TableColumn<Suorituskykysuureet, Integer> palveltutasiakkaat;@FXML TableColumn<Suorituskykysuureet, Integer> palveltutasiakkaat2; @FXML TableColumn<Suorituskykysuureet, Integer> palveltutasiakkaat3; @FXML TableColumn<Suorituskykysuureet, Integer> palveltutasiakkaat4; @FXML TableColumn<Suorituskykysuureet, Integer> palveltutasiakkaat5; @FXML TableColumn<Suorituskykysuureet, Integer> palveltutasiakkaat6; @FXML TableColumn<Suorituskykysuureet, Integer> palveltutasiakkaat7; @FXML TableColumn<Suorituskykysuureet, Integer> palveltutasiakkaat8; @FXML TableColumn<Suorituskykysuureet, Integer> palveltutasiakkaat9;
	/**Aktiiviaika sarakkeet. */
	@FXML
	private TableColumn<Suorituskykysuureet, Double> aktiiviaika;@FXML TableColumn<Suorituskykysuureet, Double> aktiiviaika2; @FXML TableColumn<Suorituskykysuureet, Double> aktiiviaika3; @FXML TableColumn<Suorituskykysuureet, Double> aktiiviaika4; @FXML TableColumn<Suorituskykysuureet, Double> aktiiviaika5; @FXML TableColumn<Suorituskykysuureet, Double> aktiiviaika6; @FXML TableColumn<Suorituskykysuureet, Double> aktiiviaika7; @FXML TableColumn<Suorituskykysuureet, Double> aktiiviaika8; @FXML TableColumn<Suorituskykysuureet, Double> aktiiviaika9;
	/**Käyttöaste sarakkeet. */
	@FXML
	private TableColumn<Suorituskykysuureet, Double> kayttoaste;@FXML TableColumn<Suorituskykysuureet, Double> kayttoaste2; @FXML TableColumn<Suorituskykysuureet, Double> kayttoaste3; @FXML TableColumn<Suorituskykysuureet, Double> kayttoaste4; @FXML TableColumn<Suorituskykysuureet, Double> kayttoaste5; @FXML TableColumn<Suorituskykysuureet, Double> kayttoaste6; @FXML TableColumn<Suorituskykysuureet, Double> kayttoaste7; @FXML TableColumn<Suorituskykysuureet, Double> kayttoaste8; @FXML TableColumn<Suorituskykysuureet, Double> kayttoaste9;
	/**Suoritusteho sarakkeet. */
	@FXML
	private TableColumn<Suorituskykysuureet, Double> suoritusteho;@FXML TableColumn<Suorituskykysuureet, Double> suoritusteho2; @FXML TableColumn<Suorituskykysuureet, Double> suoritusteho3; @FXML TableColumn<Suorituskykysuureet, Double> suoritusteho4; @FXML TableColumn<Suorituskykysuureet, Double> suoritusteho5; @FXML TableColumn<Suorituskykysuureet, Double> suoritusteho6; @FXML TableColumn<Suorituskykysuureet, Double> suoritusteho7; @FXML TableColumn<Suorituskykysuureet, Double> suoritusteho8; @FXML TableColumn<Suorituskykysuureet, Double> suoritusteho9;
	/**Keskimääräinen palveluaika sarakkeet. */
	@FXML
	private TableColumn<Suorituskykysuureet, Double> avgpalveluaika;@FXML TableColumn<Suorituskykysuureet, Double> avgpalveluaika2; @FXML TableColumn<Suorituskykysuureet, Double> avgpalveluaika3; @FXML TableColumn<Suorituskykysuureet, Double> avgpalveluaika4; @FXML TableColumn<Suorituskykysuureet, Double> avgpalveluaika5; @FXML TableColumn<Suorituskykysuureet, Double> avgpalveluaika6; @FXML TableColumn<Suorituskykysuureet, Double> avgpalveluaika7; @FXML TableColumn<Suorituskykysuureet, Double> avgpalveluaika8; @FXML TableColumn<Suorituskykysuureet, Double> avgpalveluaika9;
	/**Kokonaisoleskeluaika sarakkeet. */
	@FXML
	private TableColumn<Suorituskykysuureet, Double> kokonaisoleskeluaika;@FXML TableColumn<Suorituskykysuureet, Double> kokonaisoleskeluaika2; @FXML TableColumn<Suorituskykysuureet, Double> kokonaisoleskeluaika7; @FXML TableColumn<Suorituskykysuureet, Double> kokonaisoleskeluaika8;
	/**Keskimääräinen läpimenoaika sarakkeet. */
	@FXML
	private TableColumn<Suorituskykysuureet, Double> avglapimenoaika;@FXML TableColumn<Suorituskykysuureet, Double> avglapimenoaika2; @FXML TableColumn<Suorituskykysuureet, Double> avglapimenoaika7; @FXML TableColumn<Suorituskykysuureet, Double> avglapimenoaika8;
	/**Keskimääräinen jonon pituus sarakkeet. */
	@FXML
	private TableColumn<Suorituskykysuureet, Double> avgjononpituus;@FXML TableColumn<Suorituskykysuureet, Double> avgjononpituus2; @FXML TableColumn<Suorituskykysuureet, Double> avgjononpituus7; @FXML TableColumn<Suorituskykysuureet, Double> avgjononpituus8;
	
	/**Data access objekti. */
	private ISuorituskykysuureetDAO dao;
	/**Listat tietokannasta luetulle datalle. */
	private ObservableList<Object> fysiodata;
	private ObservableList<Object> hierontadata;
	private ObservableList<Object> kuntosalidata;
	private ObservableList<Object> juoksudata;
	private ObservableList<Object> miestenPHdata;
	private ObservableList<Object> naistenPHdata;
	private ObservableList<Object> rontgendata;
	private ObservableList<Object> vastaanottodata;
	private ObservableList<Object> ryhmaliikuntadata;
	
	/**
	 * @param main Asettaa main viewin.
	 */
	public void setMain(Main main) {
        this.main = main;    
    }

	
	
	/**
	 * Hakee datan tietokannasta ja täyttää TableViewin fysioterapian simulointituloksilla, kun fysioterapia tab on valittu.
	 * @param e tapahtuma
	 */
	@FXML
	public void fysioValittu (Event e) {
		paivays.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, String>("Paivays"));
		simulointiaika.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("Simulointiaika"));
		palveltutasiakkaat.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("PalveltutAsiakkaat"));
		aktiiviaika.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Aktiiviaika"));
		kayttoaste.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Kayttoaste"));
		suoritusteho.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Suoritusteho"));
		avgpalveluaika.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("AvgPalveluaika"));
		kokonaisoleskeluaika.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("LapimenoAjat"));
		avglapimenoaika.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("AvgLapimenoajat"));
		avgjononpituus.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Avgjononpituus"));
	
		dao = new SuorituskykysuureetAccessObject ();
		if(fysioTab.isSelected()) {
			Suorituskykysuureet [] luetutsuureet = dao.lueSuorituskykysuurreet("fysioterapia");
			fysiodata = FXCollections.observableArrayList();
			for(Suorituskykysuureet s : luetutsuureet) {
				fysiodata.add(s);
			}
			fysio.setItems(fysiodata);
		}
	}
	
	/**
	 * Hakee datan tietokannasta ja täyttää TableViewin hieronnan simulointituloksilla, kun hieronta tab on valittu.
	 * @param e tapahtuma
	 */
	@FXML
	public void hierontaValittu (Event e) {
		paivays2.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, String>("Paivays"));
		simulointiaika2.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("Simulointiaika"));
		palveltutasiakkaat2.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("PalveltutAsiakkaat"));
		aktiiviaika2.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Aktiiviaika"));
		kayttoaste2.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Kayttoaste"));
		suoritusteho2.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Suoritusteho"));
		avgpalveluaika2.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("AvgPalveluaika"));
		kokonaisoleskeluaika2.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("LapimenoAjat"));
		avglapimenoaika2.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("AvgLapimenoajat"));
		avgjononpituus2.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Avgjononpituus"));
	
		dao = new SuorituskykysuureetAccessObject ();
		if(hierontaTab.isSelected()) {
			Suorituskykysuureet [] luetutsuureet = dao.lueSuorituskykysuurreet("hieronta");
			hierontadata = FXCollections.observableArrayList();
			for(Suorituskykysuureet s : luetutsuureet) {
				hierontadata.add(s);
			}
			hierontaTable.setItems(hierontadata);
		}
	}
	
	
	/**
	 * Hakee datan tietokannasta ja täyttää TableViewin juoksumaton simulointituloksilla, kun juoksumatto tab on valittu.
	 * @param e tapahtuma
	 */
	@FXML
	public void juoksuValittu (Event e) {
		paivays3.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, String>("Paivays"));
		simulointiaika3.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("Simulointiaika"));
		palveltutasiakkaat3.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("PalveltutAsiakkaat"));
		aktiiviaika3.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Aktiiviaika"));
		kayttoaste3.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Kayttoaste"));
		suoritusteho3.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Suoritusteho"));
		avgpalveluaika3.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("AvgPalveluaika"));
		
		dao = new SuorituskykysuureetAccessObject ();
		if(juoksuTab.isSelected()) {
			Suorituskykysuureet [] luetutsuureet = dao.lueSuorituskykysuurreet("juoksumatto");
			juoksudata = FXCollections.observableArrayList();
			for(Suorituskykysuureet s : luetutsuureet) {
				juoksudata.add(s);
			}
			juoksuTable.setItems(juoksudata);
		}
	}
	
	/**
	 * Hakee datan tietokannasta ja täyttää TableViewin kuntosalin simulointituloksilla, kun kuntosali tab on valittu.
	 * @param e tapahtuma
	 */
	@FXML
	public void kuntosaliValittu (Event e) {
		paivays4.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, String>("Paivays"));
		simulointiaika4.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("Simulointiaika"));
		palveltutasiakkaat4.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("PalveltutAsiakkaat"));
		aktiiviaika4.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Aktiiviaika"));
		kayttoaste4.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Kayttoaste"));
		suoritusteho4.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Suoritusteho"));
		avgpalveluaika4.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("AvgPalveluaika"));
		
		dao = new SuorituskykysuureetAccessObject ();
		if(kuntosaliTab.isSelected()) {
			Suorituskykysuureet [] luetutsuureet = dao.lueSuorituskykysuurreet("kuntosali");
			kuntosalidata = FXCollections.observableArrayList();
			for(Suorituskykysuureet s : luetutsuureet) {
				kuntosalidata.add(s);
			}
			kuntosaliTable.setItems(kuntosalidata);
		}
	}
	
	/**
	 * Hakee datan tietokannasta ja täyttää TableViewin miesten pukuhuoneen simulointituloksilla, kun miesten pukuhuone tab on valittu.
	 * @param e tapahtuma
	 */
	
	@FXML
	public void miestenPHValittu (Event e) {
		paivays5.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, String>("Paivays"));
		simulointiaika5.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("Simulointiaika"));
		palveltutasiakkaat5.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("PalveltutAsiakkaat"));
		aktiiviaika5.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Aktiiviaika"));
		kayttoaste5.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Kayttoaste"));
		suoritusteho5.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Suoritusteho"));
		avgpalveluaika5.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("AvgPalveluaika"));
		
		dao = new SuorituskykysuureetAccessObject ();
		if(miestenPHTab.isSelected()) {
			Suorituskykysuureet [] luetutsuureet = dao.lueSuorituskykysuurreet("miestenPH");
			miestenPHdata = FXCollections.observableArrayList();
			for(Suorituskykysuureet s : luetutsuureet) {
				miestenPHdata.add(s);
			}
			miestenPHTable.setItems(miestenPHdata);
		}
	}
	
	/**
	 * Hakee datan tietokannasta ja täyttää TableViewin naisten pukuhuoneen simulointituloksilla, kun naisten pukuhuone tab on valittu.
	 * @param e tapahtuma
	 */
	@FXML
	public void naistenPHValittu (Event e) {
		paivays6.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, String>("Paivays"));
		simulointiaika6.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("Simulointiaika"));
		palveltutasiakkaat6.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("PalveltutAsiakkaat"));
		aktiiviaika6.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Aktiiviaika"));
		kayttoaste6.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Kayttoaste"));
		suoritusteho6.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Suoritusteho"));
		avgpalveluaika6.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("AvgPalveluaika"));
		
		dao = new SuorituskykysuureetAccessObject ();
		if(naistenPHTab.isSelected()) {
			Suorituskykysuureet [] luetutsuureet = dao.lueSuorituskykysuurreet("naistenPH");
			naistenPHdata = FXCollections.observableArrayList();
			for(Suorituskykysuureet s : luetutsuureet) {
				naistenPHdata.add(s);
			}
			naistenPHTable.setItems(naistenPHdata);
		}
	}
	
	/**
	 * Hakee datan tietokannasta ja täyttää TableViewin röntgenin simulointituloksilla, kun röntgen tab on valittu.
	 * @param e tapahtuma
	 */
	@FXML
	public void rontgenValittu (Event e) {
		paivays7.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, String>("Paivays"));
		simulointiaika7.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("Simulointiaika"));
		palveltutasiakkaat7.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("PalveltutAsiakkaat"));
		aktiiviaika7.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Aktiiviaika"));
		kayttoaste7.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Kayttoaste"));
		suoritusteho7.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Suoritusteho"));
		avgpalveluaika7.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("AvgPalveluaika"));
		kokonaisoleskeluaika7.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("LapimenoAjat"));
		avglapimenoaika7.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("AvgLapimenoajat"));
		avgjononpituus7.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Avgjononpituus"));
	
		dao = new SuorituskykysuureetAccessObject ();
		if(rontgenTab.isSelected()) {
			Suorituskykysuureet [] luetutsuureet = dao.lueSuorituskykysuurreet("rontgen");
			rontgendata = FXCollections.observableArrayList();
			for(Suorituskykysuureet s : luetutsuureet) {
				rontgendata.add(s);
			}
			rontgenTable.setItems(rontgendata);
		}
	}
	
	/**
	 * Hakee datan tietokannasta ja täyttää TableViewin vastaanoton simulointituloksilla, kun vastaanotto tab on valittu.
	 * @param e tapahtuma
	 */
	@FXML
	public void vastaanottoValittu (Event e) {
		paivays8.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, String>("Paivays"));
		simulointiaika8.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("Simulointiaika"));
		palveltutasiakkaat8.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("PalveltutAsiakkaat"));
		aktiiviaika8.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Aktiiviaika"));
		kayttoaste8.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Kayttoaste"));
		suoritusteho8.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Suoritusteho"));
		avgpalveluaika8.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("AvgPalveluaika"));
		kokonaisoleskeluaika8.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("LapimenoAjat"));
		avglapimenoaika8.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("AvgLapimenoajat"));
		avgjononpituus8.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Avgjononpituus"));
	
		dao = new SuorituskykysuureetAccessObject ();
		if(vastaanottoTab.isSelected()) {
			Suorituskykysuureet [] luetutsuureet = dao.lueSuorituskykysuurreet("vastaanotto");
			vastaanottodata = FXCollections.observableArrayList();
			for(Suorituskykysuureet s : luetutsuureet) {
				vastaanottodata.add(s);
			}
			vastaanottoTable.setItems(vastaanottodata);
		}
	}
	
	/**
	 * Hakee datan tietokannasta ja täyttää TableViewin ryhmäliikunnan simulointituloksilla, kun ryhmäliikunta tab on valittu.
	 * @param e tapahtuma
	 */
	@FXML
	public void ryhmaliikuntaValittu (Event e) {
		paivays9.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, String>("Paivays"));
		simulointiaika9.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("Simulointiaika"));
		palveltutasiakkaat9.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Integer>("PalveltutAsiakkaat"));
		aktiiviaika9.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Aktiiviaika"));
		kayttoaste9.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Kayttoaste"));
		suoritusteho9.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("Suoritusteho"));
		avgpalveluaika9.setCellValueFactory(new PropertyValueFactory<Suorituskykysuureet, Double>("AvgPalveluaika"));
	
		dao = new SuorituskykysuureetAccessObject ();
		if(ryhmaliikuntaTab.isSelected()) {
			Suorituskykysuureet [] luetutsuureet = dao.lueSuorituskykysuurreet("ryhmaliikunta");
			ryhmaliikuntadata = FXCollections.observableArrayList();
			for(Suorituskykysuureet s : luetutsuureet) {
				ryhmaliikuntadata.add(s);
			}
			ryhmaliikuntaTable.setItems(ryhmaliikuntadata);
		}
	}
}