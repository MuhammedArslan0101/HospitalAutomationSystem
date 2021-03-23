package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import entity.Admin;
import entity.personel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FileController  {

	public TextArea textarea;
	
	public void readtext1 (ActionEvent e) throws IOException
	{
		String filepath="admin.txt" ;
		try
		{
		FileReader reader = new FileReader (filepath);
		BufferedReader br = new BufferedReader(reader) ;
		String s;
		while((s=br.readLine())!=null)
			{
				textarea.appendText(s + "\n");
			}
		reader.close();
		}
		catch(Exception ae)
		{
		System.out.println(ae);
		}
	}

	
	public void dosyakaydetme2(ObservableList<Admin> observableAdminList, File file) {
		try {
			BufferedWriter outWriter = new BufferedWriter(new FileWriter(file));

			for (Admin admins : observableAdminList) {
				outWriter.write(admins.toString());
				outWriter.newLine();
			}
			 
			System.out.println(observableAdminList.toString());
			outWriter.close();
		} catch (IOException e) {
			Alert ioAlert = new Alert(Alert.AlertType.ERROR, "Sonsuz", ButtonType.OK);
			ioAlert.setContentText("Hata.");
			ioAlert.showAndWait();
			if (ioAlert.getResult() == ButtonType.OK) {
				ioAlert.close();
			}
		}
	}
	
	
	public void readtext12 (ActionEvent e) throws IOException
	{
		String filepath="izinler.txt" ;
		try
		{
		FileReader reader = new FileReader (filepath);
		BufferedReader br = new BufferedReader(reader) ;
		String s;
		while((s=br.readLine())!=null)
			{
			textarea.appendText(s + "\n");
			}
		reader.close();
		}
		catch(Exception ae)
		{
		System.out.println(ae);
		}
	}
	ObservableList<personel> listpersonel = FXCollections.observableArrayList(
			new personel(1, "muhamed", "Arslan","mudur" , "418987589", 536955558, 2500, "Acil", LocalDate.now()),
			new personel(2, "yusuf", "Arslan", "mudur" ,"89756973" , 537589689, 2500, "YogunBakim", LocalDate.now())

	);
	public TableView<personel> per_table;
	public Button btnn;
	public void kaydet444(ActionEvent event) {
		Stage secondaryStage = new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("tablu kayedet");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		if (listpersonel.isEmpty()) {
			secondaryStage.initOwner(this.btnn.getScene().getWindow());
			Alert emptyTableAlert = new Alert(Alert.AlertType.ERROR, "Tablo bos", ButtonType.OK);
			emptyTableAlert.setContentText("tablouda elemenler yoktur");
			emptyTableAlert.initModality(Modality.APPLICATION_MODAL);
			emptyTableAlert.initOwner(this.btnn.getScene().getWindow());
			emptyTableAlert.showAndWait();
			if (emptyTableAlert.getResult() == ButtonType.OK) {
				emptyTableAlert.close();
			}
		} else {
			File file = fileChooser.showSaveDialog(secondaryStage);
			if (file != null) {
				dosyakaydetme33(per_table.getItems(), file);
			}
		}
	}
	public void dosyakaydetme33(ObservableList<personel> observablePersonelList, File file) {
		try {
			BufferedWriter outWriter = new BufferedWriter(new FileWriter(file));

			for (personel personeler : observablePersonelList) {
				outWriter.write(personeler.toString());
				outWriter.newLine();
			}
			 
			System.out.println(observablePersonelList.toString());
			outWriter.close();
		} catch (IOException e) {
			Alert ioAlert = new Alert(Alert.AlertType.ERROR, "Sonsuz", ButtonType.OK);
			ioAlert.setContentText("Hata.");
			ioAlert.showAndWait();
			if (ioAlert.getResult() == ButtonType.OK) {
				ioAlert.close();
			}
		}
	}
	
	
}
