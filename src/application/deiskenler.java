package application;

import java.time.LocalDate;

import entity.Admin;
import entity.hasta;
import entity.izinler;
import entity.odalar;
import entity.personel;
import entity.poliknikler;
import entity.yemek;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import entity.hastadurumbelgesi;
import entity.odeme;

public class deiskenler extends FileController  {

	@FXML
	public Button btnn;
	public TextArea textareagenel;
	/* add Admin */
	public TableView<Admin> table;
	public TableColumn<Admin, Integer> idu;
	public TableColumn<Admin, String> uname;
	public TableColumn<Admin, String> upassword;
	public TextField unameT;
	public TextField upasswordT;
	public TextField idT;
	public TextField search;
	public TextArea textarea;
	/************************/
	/* hasta deigskenleri */
	public TextField hastaidT;
	public TextField id_adT;
	public TextField tcidT;
	public DatePicker tarih_idT;
	public TableView<hasta> hasta_tablo;
	public ComboBox<String> kan_combox;
	public ComboBox<String> polik_combox;
	public ComboBox<String> dr_combox;
	public TableColumn<hasta, Integer> id_hasta;
	public TableColumn<hasta, String> adisoyadi;
	public TableColumn<hasta, String> tckimlik;
	public TableColumn<hasta, String> polik;
	public TableColumn<hasta, String> dr;
	public TableColumn<hasta, String> tarih;
	public TableColumn<hasta, String> kan;
	public TextArea textareahasta;
	/* first page deiskenleri */
	public TextField username;
	public PasswordField password;
	public Label status;
	public TextField usernameforpassword;
	public Label yourpassword;
	public Label faildusername;
	public Label saat;
	/*********************************/
	/* hasta durum belegsi */
	public TextField h_id;
	public TextArea aciklama;
	public TextField adsoyad;
	public TextField tc;
	public ListView<?> hbliste;
	public ListView<?> perislemi;
	/* personel Ekle */
	public TextField idperT;
	public TextField adperT;

	public TextField soyperT;
	public TextField tcperT;
	public TextField teleperT;
	public TextField maasperT;
	public ComboBox<String> polikper_combox;
	public DatePicker tarihperT;
	
    public ComboBox<String> personeltur_combox;
    
    public TableColumn<personel, String> personelturC;
	public TableView<personel> per_table;
	public TableColumn<personel, Integer> idC;
	public TableColumn<personel, String> adC;
	public TableColumn<personel, String> soyadC;
	public TableColumn<personel, String> kimlikC;
	public TableColumn<personel, String> polikC;
	public TableColumn<personel, Integer> maasC;
	public TableColumn<personel, Long> teleC;
	public TableColumn<personel, LocalDate> tarihC;

	/* yemek deisknler */

	public TextField idyemekT;
	public TextField adyemekhastaT;
	public TextField odanoyemekT;
	public ComboBox<String> durumyemek_combox;
	public ComboBox<String> turyemek_Combox;

	public TextArea textareayemek;

	public TableView<yemek> yemek_tablo;
	public TableColumn<yemek, Integer> idyemekC;
	public TableColumn<yemek, String> adyemekC;
	public TableColumn<yemek, Integer> odanoC;
	public TableColumn<yemek, String> yemekturC;
	public TableColumn<yemek, String> durumyemekC;

	/* izin deisenler */

	public TextField izinidT;
	public TextField izinliadiT;
	public TextArea aciklamaT;
	public DatePicker bastarihiT;
	public DatePicker bitisT;
    
    public TextArea izintext;
	public TableView<izinler> izin_tablo;

	public TableColumn<izinler, Integer> idizinC;
	public TableColumn<izinler, String> izinadC;
	public TableColumn<izinler, LocalDate> bastarihiC;
	public TableColumn<izinler, LocalDate> bitistarihiC;
	public TableColumn<izinler, String> aciklamaC;

	/* polklink */

	public TextField polisimT;
	public TextField idpolT;
	public TextField polnobetT;
	public TextField claismaT;

	public TableView<poliknikler> pol_tablo;
	public TableColumn<poliknikler, Integer> idpolC;
	public TableColumn<poliknikler, String> polisimC;
	public TableColumn<poliknikler, String> nobetC;
	public TableColumn<poliknikler, String> saatpolC;
	
	/*odeme*/

	    public TextField idodemeT;
	    public TextField isimT;

	    public TableView<odeme> odeme_table;
	    public TableColumn<odeme, String> isimC;
	    public TableColumn<odeme, Integer> idodemeC;
	    public TextField sayi1T;
	    public TextField sayi2T;
	    public TextField sayi3T;
	    public TextField souncT;
	    public TableColumn<odeme, String> ucretC ;
	    public TextField visi;

	    public TextField gunucreti;
	
	    public TextField ayT;

	
	    public TextField ayTT;
	    
	    public TableColumn<odeme, String> taksitsekiz ;

	    
	    public TableColumn<odeme, String> taksitalti;

	   
	    public TextField kucreti;
	    
	    public TextField toplamm;
	 
	    public RadioButton evet;

	    public ToggleGroup evethayir;

	    public RadioButton hayir;
	    
	    ///////////////////////////////////////////////
	    
	    @FXML
	    public TableView<odalar> table_oda ;
	    
	    public TableColumn<odalar, String> adiC;
	    public TableColumn<odalar, Integer> odaC;
	    public TableColumn<odalar, Integer> kisiC;
	    public TableColumn<odalar, String> durumuC;
	    public TextField adT;
	    public TextField kisisT;
	    public TextField odanoT;
	    public ComboBox<String> durumT;
	    public TextArea textAreaT;
	    
	    ///////////////////////////////

	    /*hasta durum belgesi */
	    public TableView<hastadurumbelgesi> hd_table;
	    public TableColumn<hastadurumbelgesi, Integer> idhC;
	    public TableColumn<hastadurumbelgesi, String> adihC;
	    public TableColumn<hastadurumbelgesi, String> tchC;
	    public TableColumn<hastadurumbelgesi, String> hsthC;
	    public TableColumn<hastadurumbelgesi, String> drhC;
	    public TableColumn<hastadurumbelgesi, String> kisimC;
	    public TableColumn<hastadurumbelgesi, String> nothC;
	    public TextArea textht;
	    
	    
	    public TextField adhT;
	    public TextField tchT;
	    public TextField hastalikT;
	    public ComboBox<String> drComboboxT;
	    public ComboBox<String> kisimComboboxT;
	    public TextField idhT;
	    public TextField notT;



}
