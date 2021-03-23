package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import entity.hastadurumbelgesi;

interface hastaduruminterface {
	
	public void initialize(URL location, ResourceBundle resources) ;
	public void jhasEkle(ActionEvent e);
	public void getSelected();
	public void Sil(ActionEvent e);
	public void Guncel(ActionEvent e);
	public hastadurumbelgesi getData();
	public void clearForm(ActionEvent e);
	public void deleteAll(ActionEvent event);
	public void search();
	
	
	

}
