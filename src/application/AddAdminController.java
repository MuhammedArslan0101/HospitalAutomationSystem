package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import entity.Admin;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddAdminController extends deiskenler implements Initializable, Admininterfaces {

	int index;
	Admin a = new Admin();

	ObservableList<Admin> list = FXCollections.observableArrayList(
			new Admin (1,"muh" , "123") ,
			new Admin (2,"yus","123")
			

	);
	ArrayList<String> datatextFile = new ArrayList<>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idu.setCellValueFactory(new PropertyValueFactory<Admin, Integer>("idu"));
		uname.setCellValueFactory(new PropertyValueFactory<Admin, String>("username"));
		upassword.setCellValueFactory(new PropertyValueFactory<Admin, String>("password"));

		table.setItems(list);

	}

	@Override
	public void addadmin(ActionEvent event) throws IOException {
		Integer idu = Integer.parseInt(idT.getText());
		String uname = unameT.getText();
		String upassword = upasswordT.getText();
		list.add(new Admin(idu , uname, upassword));
		upasswordT.clear();
		unameT.clear();
		idT.clear();
		BufferedWriter bw = new BufferedWriter(new FileWriter("admin.txt"));
		try {
			for (Admin a : list) {
				String text = a.getIdu() + "," + a.getUsername() + "," + a.getPassword() + "\n";

				bw.write(text);
			}

			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	private Button btn;

	@Override
	public void kaydet(ActionEvent event) {
		Stage secondaryStage = new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("tablu kayedet");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		if (list.isEmpty()) {
			secondaryStage.initOwner(this.btn.getScene().getWindow());
			Alert emptyTableAlert = new Alert(Alert.AlertType.ERROR, "Tablo bos", ButtonType.OK);
			emptyTableAlert.setContentText("tablouda elemenler yoktur");
			emptyTableAlert.initModality(Modality.APPLICATION_MODAL);
			emptyTableAlert.initOwner(this.btn.getScene().getWindow());
			emptyTableAlert.showAndWait();
			if (emptyTableAlert.getResult() == ButtonType.OK) {
				emptyTableAlert.close();
			}
		} else {
			File file = fileChooser.showSaveDialog(secondaryStage);
			if (file != null) {
				dosyakaydetme(table.getItems(), file);
			}
		}
	}

	@Override
	public void readtext(ActionEvent e) throws IOException {
		String filepath = "admin.txt";
		try {
			FileReader reader = new FileReader(filepath);
			BufferedReader br = new BufferedReader(reader);
			String s;
			while ((s = br.readLine()) != null) {
				textarea.appendText(s + "\n");
			}
			reader.close();
		} catch (Exception ae) {
			System.out.println(ae);
		}
	}

	@Override
	public void dosyakaydetme(ObservableList<Admin> observableAdminList, File file) {
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

	@Override
	public void getSelected() {

		index = table.getSelectionModel().getSelectedIndex();

		if (index <= -1) {
			return;

		}
		idT.setText(idu.getCellData(index).toString());
		unameT.setText(uname.getCellData(index));
		upasswordT.setText(upassword.getCellData(index));

	}

	@Override
	public void guncelle(ActionEvent e) {

		list.set(index, getData());
		unameT.clear();
		upasswordT.clear();
		idT.clear();

	}

	@Override
	public Admin getData() {
		Integer idu = Integer.parseInt(idT.getText());
		String uname = unameT.getText();
		String upassword = upasswordT.getText();
		return new Admin(idu , uname, upassword);

	}

	@Override
	public void delete() throws IOException {
		if (index <= -1) {
			return;

		}
		Admin tmp = null;
		String currentLine;
		for (int i = 0; i < list.size(); i++) {
			if (index == i) {
				tmp = list.get(i);
			}
		}

		BufferedReader reader = new BufferedReader(new FileReader("admin.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("admin.txt"));

		while ((currentLine = reader.readLine()) != null) {
			// trim newline when comparing with lineToRemove
			String trimmedLine = currentLine.trim();
			if (trimmedLine.equals(tmp))
				continue;
			writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close();
		reader.close();

		

		// nullexception için
		index = -1;
		idT.clear();
		unameT.clear();
		upasswordT.clear();

	}

	@Override
	public void deletealltable() {
		if (index <= -1) {
			return;

		}
		table.getItems().removeAll(list);

		// nullexception için
		
		idT.clear();
		unameT.clear();
		upasswordT.clear();

	}

	@Override
	public void cleaForm() throws IOException {
		idT.clear();
		unameT.clear();
		upasswordT.clear();
		textarea.clear();

	}

	@Override
	public void search() {
		search.textProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(javafx.beans.Observable arg0) {
				if (search.textProperty().get().isEmpty()) {
					table.setItems(list);
					return;
				}
				ObservableList<Admin> items = FXCollections.observableArrayList();
				ObservableList<TableColumn<Admin, ?>> column = table.getColumns();

				for (int row = 0; row < list.size(); row++) {
					for (int col = 0; col < column.size(); col++) {
						TableColumn colVar = column.get(col);
						String cellValue = colVar.getCellData(list.get(row)).toString();
						// buyuk yada kuçuk farketmez

						cellValue = cellValue.toLowerCase();
						if (cellValue.contains(search.getText().toLowerCase())
								&& cellValue.startsWith(search.getText().toLowerCase())) {
							items.add(list.get(row));
							break;
						}
					}
				}
				table.setItems(items);
			}
		});
	}

	public void importData() throws IOException {

		Collection<Admin> listf = Files.readAllLines(new File("admin.txt").toPath()).stream().map(line -> {
			String[] details = line.split(",");
			Admin cd = new Admin();
			cd.setIdu(Integer.parseInt(details[0]));
			cd.setUsername(details[1]);
			cd.setPassword(details[2]);

			return cd;
		}).collect(Collectors.toList());

		ObservableList<Admin> details = FXCollections.observableArrayList(listf);

		table.setItems(details);
	}
	
	public void importtotable ()
	{
			String id =null ;
			String username = null;
			String password = null;
		
			;
			String bool = "true";
			String satir;
			try {
				FileReader fr = new FileReader("admin.txt");
				BufferedReader br = new BufferedReader(fr);
				while ((satir = br.readLine()) != null) {
					System.out.println(satir + "dene");

					char[] satirchar_at = satir.toCharArray();
					char gecici[] = new char[255];
					int ndx = 0;
					int j = 0;
					for (int i = 0; i < satir.length(); i++) {
						System.out.println("STRC: " + satirchar_at[i]);
						if (satirchar_at[i] != ',') {
							gecici[j] = satirchar_at[i];
							System.out.println("TMP: " + gecici[j]);
							j = j + 1;
						}
						if (satirchar_at[i] == ',') {
							char[] tmp1 = new char[j];
							for (int k = 0; k < j; k++)
								tmp1[k] = gecici[k];
							switch (ndx) {
							case 0:
							id = new String(tmp1);
								break;
							case 1:
								username = new String(tmp1);
								break;
							case 2:
								password = new String(tmp1);
								break;
							
							default:
								System.out.println("Hata.");
								break;
							}
							gecici = new char[255];
							tmp1 = new char[255];
							ndx = ndx + 1;
							j = 0;
						}
					}
					Admin lst = new Admin(null, null, null);
					lst.setIdu(Integer.parseInt(id));
					lst.setUsername(username);
					lst.setPassword(password);
					
					list.add(lst);
				}
				table.setItems(list);

				br.close();
			} catch (IOException e) {
				System.out.println("Dosya Hatasý!!");
			}
		}
	}


