package application;

import java.net.URL;
import java.util.ResourceBundle;

import entity.poliknikler;
import javafx.event.ActionEvent;

interface poliklinkinterface {
	
	public void initialize(URL location, ResourceBundle resources) ;
	public void polEkle(ActionEvent e);
	public void getSelectedpol() ;
	public void polGuncel(ActionEvent event);
	public poliknikler getDatapol();
	public void polSil(ActionEvent event);
	public void clearForm(ActionEvent event);
	

}
