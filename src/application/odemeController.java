package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import entity.odeme;

public class odemeController extends hesap_islemleri implements Initializable , odemeinterrface {
	
	hesap_islemleri h = new hesap_islemleri();
hesaplama hesap = new hesaplama ();

	ObservableList<odeme> listodeme = FXCollections.observableArrayList(
			new odeme(1 , "muh" , "24" , "21" , "e"),
			new odeme(2 , "yusuf" , "54" , "11" , " 21")

	);
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		isimC.setCellValueFactory(new PropertyValueFactory<odeme, String>("isim_gs"));
		idodemeC.setCellValueFactory(new PropertyValueFactory<odeme, Integer>("idodeme"));
		ucretC.setCellValueFactory(new PropertyValueFactory<odeme, String>("ucret"));
		taksitsekiz.setCellValueFactory(new PropertyValueFactory<odeme, String>("taks"));
		taksitalti.setCellValueFactory(new PropertyValueFactory<odeme, String>("taka"));
		
		odeme_table.setItems(listodeme);
		
		visi.setVisible(true);
	}
	@Override
	public void hesapartie ()
	{
		if (sayi2T.getText().equals(""))
		{
			souncT.setText(sayi1T.getText());
		}
		else {
		double x = hesap.add(Double.parseDouble(sayi1T.getText()) ,Double.parseDouble(sayi2T.getText()));
		souncT.setText(String.valueOf(x)) ;
		
		
		}
	
	}
	
@Override
	public void arti3 ()
	{
		double y = hesap.add(Double.parseDouble(sayi1T.getText()), Double.parseDouble(sayi2T.getText()), Double.parseDouble(sayi3T.getText())) ;
		souncT.setText(String.valueOf(y));
	}
	@Override
	public void carp ()
	{
	double z =	hesap.multiply(Double.parseDouble(visi.getText()), Double.parseDouble(gunucreti.getText())) ;
		kucreti.setText(String.valueOf(z));
		
	}
	@Override
	public void toplam ()
	{
		if (kucreti.getText().equals(""))
		{
			double t = hesap.add(Double.parseDouble(souncT.getText()), 0) ;
			toplamm.setText(String.valueOf(t));
		}else
		{
		double t = hesap.add(Double.parseDouble(souncT.getText()), Double.parseDouble(kucreti.getText())) ;
		toplamm.setText(String.valueOf(t));}
	}
	@Override
	public void taksit ()
	{
		double t6 = hesap.divply(Double.parseDouble(toplamm.getText()), 6) ;
		double t8 = hesap.divply(Double.parseDouble(toplamm.getText()), 8) ;
		ayT.setText(String.valueOf(t6));
		ayTT.setText(String.valueOf(t8));
	}
	@Override
	public void odemeEkle(ActionEvent e) throws IOException {

		Integer id = Integer.parseInt(idodemeT.getText());
		String isim = isimT.getText();
		String ucret = toplamm.getText();
		String t6 = ayT.getText();
		String t8 = ayTT.getText();
		
	

		listodeme.add(new odeme(id ,isim , ucret , t6 , t8));
		
		BufferedWriter bw =new BufferedWriter (new FileWriter ("odemler.txt"));
		try 
		{			
			for (odeme a : listodeme) {
				 String text = a.getIdodeme() + "," + a.getIsim_gs()  +"," + a.getUcret()  + "," + a.getTaka() +"," + a.getTaks()  +"\n";
				 
				 bw.write(text);
			}
			
			bw.close ();
			
		} catch (IOException e1) {
			e1.printStackTrace ();
		}

	}
	
	public void clearFormoperaur(ActionEvent e) {
		ayT.clear();
		ayTT.clear();
		toplamm.clear();
		kucreti.clear();
		souncT.clear();
		sayi1T.clear();
		sayi2T.clear();
		sayi3T.clear();
		visi.clear();
		gunucreti.clear();

	}
	int index ;
	
	@Override
	public void getSelectedodeme() {

		index = odeme_table.getSelectionModel().getSelectedIndex();

		if (index <= -1) {
			return;

		}
		idodemeT.setText(idodemeC.getCellData(index).toString());
		isimT.setText(isimC.getCellData(index));
		


	}
@Override
	public void odemeSil(ActionEvent e)

	{
		if (index <= -1) {
			return;

		}
		odeme_table.getItems().remove(index);
	
		index = -1;
		clearForm(e);

	}
@Override
	public void odemeGuncel(ActionEvent e) {

		listodeme.set(index, getDataodeme());

		clearForm(e);
	}

	public odeme getDataodeme() {
		Integer id = Integer.parseInt(idodemeT.getText());
		String isim = isimT.getText();
		String ucret = souncT.getText();
		String t6 = ayT.getText();
		String t8 = ayTT.getText();

		 return new odeme(id , isim , ucret , t6 , t8 );
		
	}

	
	
	public void clearForm(ActionEvent e) {
		isimT.clear();
		idodemeT.clear();
		

	}
@Override
	public void deleteAllodeme(ActionEvent event) {
		if (index <= -1) {
			return;

		}
		odeme_table.getItems().removeAll(listodeme);
	}
	
	public void search() {
		search.textProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(javafx.beans.Observable arg0) {
				if (search.textProperty().get().isEmpty()) {
					 odeme_table.setItems(listodeme);
					return;
				}
				ObservableList<odeme> items = FXCollections.observableArrayList();
				ObservableList<TableColumn<odeme, ?>> column = odeme_table.getColumns();

				for (int row = 0; row < listodeme.size(); row++) {
					for (int col = 0; col < column.size(); col++) {
						TableColumn colVar = column.get(col);
						String cellValue = colVar.getCellData(listodeme.get(row)).toString();
						// buyuk yada kuçuk farketmez

						cellValue = cellValue.toLowerCase();
						if (cellValue.contains(search.getText().toLowerCase())
								&& cellValue.startsWith(search.getText().toLowerCase())) {
							items.add(listodeme.get(row));
							break;
						}
					}
				}
				odeme_table.setItems(items);
			}
		});}
}
