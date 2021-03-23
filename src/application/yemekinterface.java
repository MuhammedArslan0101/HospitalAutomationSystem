package application;

import java.io.IOException;

import entity.yemek;
import javafx.event.ActionEvent;

interface yemekinterface {
	
	public void addyemek(ActionEvent e) throws IOException;
	public void getSelected();
	public void yemekSil(ActionEvent e);
	public void YemekGuncel(ActionEvent e) ;
	public yemek getData() ;
	public void clearForm(ActionEvent e);
	public void deleteAll(ActionEvent event);
	public void kaydet(ActionEvent event);
	

}
