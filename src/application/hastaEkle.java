package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entity.hasta;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

interface hastaEkle {
	public void colseApp(ActionEvent e);
	public void cleartextarea ();
	public void showFile (ActionEvent e) throws IOException;
	public void dosyakaydetme1(ObservableList<hasta> observablehastaList, File file);
	public void kaydet1(ActionEvent event);
	public void search();
	public void deleteAll(ActionEvent event);
	public void clearForm(ActionEvent e);
	public hasta getData();
	public void hastaGuncel(ActionEvent e);
	public void hastaSil(ActionEvent e);
	public void getSelected();
	public void Eklehasta(ActionEvent e) throws IOException;
	public void initialize(URL arg0, ResourceBundle arg1);

	public void importDataHasta () throws IOException ;
}
