package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entity.odalar;
import javafx.event.ActionEvent;

interface Odalarinterface {
	
	public void initialize(URL location, ResourceBundle resources) ;
	public void clear(ActionEvent event);
	public void ekle(ActionEvent event) throws IOException;
	public void getSelected() ;
	public void guncelle(ActionEvent event) ;
	public odalar getData();
	void readFile(ActionEvent event);
	public void sil(ActionEvent event) ;
	

}
