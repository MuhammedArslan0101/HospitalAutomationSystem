package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

interface odemeinterrface {
	
	public void initialize(URL location, ResourceBundle resources);
	public void hesapartie ();
	public void arti3 ();
	public void carp ();
	public void toplam ();
	public void taksit ();
	public void odemeEkle(ActionEvent e) throws IOException ;
	public void getSelectedodeme();
	public void odemeSil(ActionEvent e);
	public void odemeGuncel(ActionEvent e) ;
	public void deleteAllodeme(ActionEvent event);
	
;
	

}
