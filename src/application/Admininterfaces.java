package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entity.Admin;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

interface  Admininterfaces {
	
	
	public void initialize(URL arg0, ResourceBundle arg1) ;
	public void readtext (ActionEvent e) throws IOException ;
	public void search () ;
	public void cleaForm() throws IOException;
	public void deletealltable ();
	public void delete () throws IOException ;
	public Admin getData() ;
	public void guncelle (ActionEvent e) ;
	public void getSelected();
	public void dosyakaydetme(ObservableList<Admin> observableAdminList, File file);
	public void kaydet(ActionEvent event);
	public void addadmin(ActionEvent event) throws IOException ;

}
