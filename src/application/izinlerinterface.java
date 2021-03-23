package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entity.izinler;
import javafx.event.ActionEvent;

interface izinlerinterface {
	 
	 public void initialize(URL location, ResourceBundle resources);
	 public void izinEkle(ActionEvent e) throws IOException;
	 public void getSelected();
	 public void izinSil(ActionEvent e);
	 public void izinGuncel(ActionEvent e);
	 public izinler getDataiz();
	 public void clearFormiz(ActionEvent e);
	 public void deleteAlliz(ActionEvent event);
	 public void cleatTextArea ();
	 public void readtext (ActionEvent e) throws IOException;
	 

}
