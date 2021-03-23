package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class personel_islemleri {

	public void hastadurumBelgesi (ActionEvent e ) throws IOException
	{
		Stage primaryStage = new Stage ();
		Parent root = FXMLLoader.load(getClass().getResource("hasta_durum_belgesi.fxml"));
		
		Scene scene = new Scene(root,400,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()) ;
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void hcik (ActionEvent e ) throws IOException
	{
		Stage primaryStage = new Stage ();
		Parent root = FXMLLoader.load(getClass().getResource("hastacikisi.fxml"));
		
		Scene scene = new Scene(root,550,450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()) ;
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void listeleme (ActionEvent e ) throws IOException
	{
		Stage primaryStage = new Stage ();
		Parent root = FXMLLoader.load(getClass().getResource("hastalisteleme.fxml"));
		
		Scene scene = new Scene(root,450,450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()) ;
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void logout(ActionEvent e) throws IOException
	{
		
		((Node)e.getSource()).getScene().getWindow().hide();
		
		Stage primaryStage = new Stage ();
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		
		Scene scene = new Scene(root,500,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()) ;
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
