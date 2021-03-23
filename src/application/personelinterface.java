package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entity.personel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

interface personelinterface {
	public void initialize(URL location, ResourceBundle resources);
	public void perEkle(ActionEvent e) throws IOException;
	public void getSelected();
	public void personelSil(ActionEvent e);
	public void personelGuncel(ActionEvent e);
	public personel getData();
	public void clearForm(ActionEvent e);
	public void deleteAll(ActionEvent event);
	public void search();
	public void kaydet(ActionEvent event);
	public void dosyakaydetme(ObservableList<personel> observablePersonelList, File file);
	

}
