package application;
import util.util;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class admin_islemler {
	@FXML
	private void getFacebook(ActionEvent e)
	{
		util.goLink("https://www.facebook.com/muhammedarslan");
	}
	@FXML
	private void getTwitter (ActionEvent e)
	{
		util.goLink("https://twitter.com/login");
	}
	@FXML
	private void getinstagram (ActionEvent e)
	{
		util.goLink("https://www.instagram.com/?hl=en/yusufkaragoz");
	}
	
	public void adminEkle (ActionEvent e ) throws IOException
	{
		Stage primaryStage = new Stage ();
		Parent root = FXMLLoader.load(getClass().getResource("/view/AdminEkle.fxml"));
		
		Scene scene = new Scene(root,450,450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()) ;
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public void logout(ActionEvent e) throws IOException
	{
		
		((Node)e.getSource()).getScene().getWindow().hide();
		
		Stage primaryStage = new Stage ();
		Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
		
		Scene scene = new Scene(root,450,450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()) ;
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void HastaEkle (ActionEvent e ) throws IOException
	{
		Stage primaryStage = new Stage ();
		Parent root = FXMLLoader.load(getClass().getResource("/view/HastaEkle.fxml"));
		
		Scene scene = new Scene(root,500,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()) ;
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void PersonelEkle (ActionEvent e ) throws IOException
	{
		Stage primaryStage = new Stage ();
		Parent root = FXMLLoader.load(getClass().getResource("/view/personelEkle.fxml"));
		
		Scene scene = new Scene(root,500,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()) ;
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void servisler (ActionEvent e ) throws IOException
	{
		Stage primaryStage = new Stage ();
		Parent root = FXMLLoader.load(getClass().getResource("servisler.fxml"));
		
		Scene scene = new Scene(root,450,450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()) ;
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void poliklinik (ActionEvent e ) throws IOException
	{
		Stage primaryStage = new Stage ();
		Parent root = FXMLLoader.load(getClass().getResource("/view/poliklinik.fxml"));
		
		Scene scene = new Scene(root,500,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()) ;
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void izinler (ActionEvent e ) throws IOException
	{
		Stage primaryStage = new Stage ();
		Parent root = FXMLLoader.load(getClass().getResource("/view/izinler.fxml"));
		
		Scene scene = new Scene(root,450,450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()) ;
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void yemek (ActionEvent e ) throws IOException
	{
		Stage primaryStage = new Stage ();
		Parent root = FXMLLoader.load(getClass().getResource("/view/yemek.fxml"));
		
		Scene scene = new Scene(root,450,450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()) ;
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void odalar (ActionEvent e ) throws IOException
	{
		Stage primaryStage = new Stage ();
		Parent root = FXMLLoader.load(getClass().getResource("/view/odalar.fxml"));
		
		Scene scene = new Scene(root,450,450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()) ;
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	public void odeme (ActionEvent e ) throws IOException
	{
		Stage primaryStage = new Stage ();
		Parent root = FXMLLoader.load(getClass().getResource("/view/odeme.fxml"));
		
		Scene scene = new Scene(root,450,450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()) ;
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	

	public void nobetci (ActionEvent e ) throws IOException
	{
		Stage primaryStage = new Stage ();
		Parent root = FXMLLoader.load(getClass().getResource("/view/hasta_durum_belgesi.fxml"));
		
		Scene scene = new Scene(root,450,450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()) ;
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	

	
}


