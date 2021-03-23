package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.JFileChooser;

import entity.Admin;
import entity.hasta;
import entity.insan;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HastaEkleController extends insan implements Initializable, hastaEkle {

	int index;
	hasta h = new hasta(); 
	
	private static Scanner x;
	ObservableList<hasta> listhasta = FXCollections.observableArrayList(
			new hasta(1, "muhamed", "789547", "A+", "Acil", "Ahmet", LocalDate.now()),

			new hasta(2, "yusuf", "789547", "A+", "Acil", "Ahmet", LocalDate.now())

	);

	ObservableList<String> kan_comboxData = FXCollections.observableArrayList();
	ObservableList<String> dr_comboxData = FXCollections.observableArrayList();
	ObservableList<String> polik_comboxData = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		id_hasta.setCellValueFactory(new PropertyValueFactory<hasta, Integer>("hastaid"));
		adisoyadi.setCellValueFactory(new PropertyValueFactory<hasta, String>("id_ad"));
		tckimlik.setCellValueFactory(new PropertyValueFactory<hasta, String>("tcid"));
		kan.setCellValueFactory(new PropertyValueFactory<hasta, String>("kan_id"));
		polik.setCellValueFactory(new PropertyValueFactory<hasta, String>("polik_id"));
		dr.setCellValueFactory(new PropertyValueFactory<hasta, String>("doktor_id"));
		tarih.setCellValueFactory(new PropertyValueFactory<hasta, String>("tarih_id"));

		hasta_tablo.setItems(listhasta);

		kan_comboxData.add(new String("A+"));
		kan_comboxData.add(new String("AB+"));
		kan_comboxData.add(new String("O+"));
		kan_comboxData.add(new String("O-"));

		kan_combox.setItems(kan_comboxData);

		dr_comboxData.add(new String("Muhammed"));
		dr_comboxData.add(new String("ahmet"));
		dr_comboxData.add(new String("ridvan"));
		dr_comboxData.add(new String("Orhan"));

		dr_combox.setItems(dr_comboxData);

		polik_comboxData.add(new String("Acil"));
		polik_comboxData.add(new String("Yogun Bakim"));
		polik_comboxData.add(new String("Cocuk"));
		polik_comboxData.add(new String("Cerrah"));

		polik_combox.setItems(polik_comboxData);

	}

	@Override
	public void Eklehasta(ActionEvent e) throws IOException {

		Integer id = Integer.parseInt(hastaidT.getText());
		String ad = id_adT.getText();
		String tc = tcidT.getText();
		String kan = kan_combox.getValue();

		String polik = polik_combox.getValue();
		String dr = dr_combox.getValue();
		LocalDate tarih = tarih_idT.getValue();

		listhasta.add(new hasta(id, ad, tc, kan, polik, dr, tarih));
		
	
		BufferedWriter bw = new BufferedWriter(new FileWriter("hasta.txt"));
		try {
			for (hasta h : listhasta) {
				String text = h.getHastaid() + "," + h.getId_ad() + "," + h.getTcid() + "," + h.getKan_id() + ","
						+ h.getPolik_id() + "," + h.getDoktor_id() + "," + h.getTarih_id() + "\n";

				bw.write(text);
			}

			bw.close();

		} catch (IOException eee) {
			eee.printStackTrace();
		}
	}

	@Override
	public void getSelected() {

		index = hasta_tablo.getSelectionModel().getSelectedIndex();

		if (index <= -1) {
			return;

		}
		hastaidT.setText(id_hasta.getCellData(index).toString());
		id_adT.setText(adisoyadi.getCellData(index));
		tcidT.setText(tckimlik.getCellData(index));

		kan_combox.setValue(kan.getCellData(index));
		polik_combox.setValue(polik.getCellData(index));
		dr_combox.setValue(dr.getCellData(index));
		// tarih_idT.setText(tarih.getCellData(index));

		// tarih_idT.setStyle(tarih.getCellData(index));

	}

	@Override
	public void hastaSil(ActionEvent e) {
		if (index <= -1) {
			return;

		}
		hasta_tablo.getItems().remove(index);
		// nullexception için
		index = -1;
		clearForm(e);

	}

	@Override
	public void hastaGuncel(ActionEvent e) {

		listhasta.set(index, getData());
		/*
		 * hastaidT.clear(); id_adT.clear(); tcidT.clear();
		 * 
		 * kan_combox.setValue("KanGrubu seçin"); ;
		 * polik_combox.setValue("polik Seçin"); dr_combox.setValue("dr Seçin");
		 * tarih_idT.setValue(null);
		 */
		clearForm(e);
	}

	@Override
	public hasta getData() {
		Integer id = Integer.parseInt(hastaidT.getText());
		String ad = id_adT.getText();
		String tc = tcidT.getText();
		String kan = kan_combox.getValue();

		String polik = polik_combox.getValue();
		String dr = dr_combox.getValue();
		LocalDate tarih = tarih_idT.getValue();

		return new hasta(id, ad, tc, kan, polik, dr, tarih);

	}

	@Override
	public void clearForm(ActionEvent e) {
		hastaidT.clear();
		id_adT.clear();
		tcidT.clear();

		kan_combox.setValue("KanGrubu seçin");

		polik_combox.setValue("polik Seçin");
		dr_combox.setValue("dr Seçin");
		tarih_idT.setValue(null);

		search.clear();

	}

	@Override
	public void deleteAll(ActionEvent event) {
		if (index <= -1) {
			return;

		}
		hasta_tablo.getItems().removeAll(listhasta);
	}

	@Override
	public void search() {
		search.textProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(javafx.beans.Observable arg0) {
				if (search.textProperty().get().isEmpty()) {
					hasta_tablo.setItems(listhasta);
					return;
				}
				ObservableList<hasta> items = FXCollections.observableArrayList();
				ObservableList<TableColumn<hasta, ?>> column = hasta_tablo.getColumns();

				for (int row = 0; row < listhasta.size(); row++) {
					for (int col = 0; col < column.size(); col++) {
						TableColumn colVar = column.get(col);
						String cellValue = colVar.getCellData(listhasta.get(row)).toString();
						// buyuk yada kuçuk farketmez

						cellValue = cellValue.toLowerCase();
						if (cellValue.contains(search.getText().toLowerCase())
								&& cellValue.startsWith(search.getText().toLowerCase())) {
							items.add(listhasta.get(row));
							break;
						}
					}
				}
				hasta_tablo.setItems(items);
			}
		});
	}

	@FXML
	private Button btnn;

	@Override
	public void kaydet1(ActionEvent event) {
		Stage secondaryStage = new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("tablu kayedet");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		if (listhasta.isEmpty()) {
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
				dosyakaydetme1(hasta_tablo.getItems(), file);
			}
		}
	}

	@Override
	public void dosyakaydetme1(ObservableList<hasta> observablehastaList, File file) {
		try {
			BufferedWriter outWriter = new BufferedWriter(new FileWriter(file));

			for (hasta hastalar : observablehastaList) {
				outWriter.write(hastalar.toString());
				outWriter.newLine();
			}

			System.out.println(observablehastaList.toString());
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
	public void showFile(ActionEvent e) throws IOException {
		JFileChooser open = new JFileChooser();
		open.showOpenDialog(null);
		File f = open.getSelectedFile();
		String filename = f.getAbsolutePath();

		try {
			FileReader reader = new FileReader(filename);
			BufferedReader br = new BufferedReader(reader);
			String s;
			while ((s = br.readLine()) != null) {
				textareahasta.appendText(s + "\n");
			}

			reader.close();
		} catch (Exception ae) {
			System.out.println(ae);
		}

	}

	@Override
	public void colseApp(ActionEvent e) {
		Platform.exit();
		System.exit(0);
	}

	@Override
	public void cleartextarea() {
		textareahasta.clear();
	}



	@Override
	public void importDataHasta() throws IOException {

		Collection<hasta> listfile = Files.readAllLines(new File("hasta.txt").toPath()).stream().map(line -> {
			String[] details = line.split(",");
			hasta cd = new hasta();
			cd.setHastaid(Integer.parseInt(details[0]));
			cd.setId_ad(details[1]);
			cd.setTcid(details[2]);
			cd.setKan_id(details[3]);
			cd.setPolik_id(details[4]);
			cd.setDoktor_id(details[5]);
			cd.setTarih_id(LocalDate.parse(details[6]));

			return cd;
		}).collect(Collectors.toList());

		ObservableList<hasta> details = FXCollections.observableArrayList(listfile);

		hasta_tablo.setItems(details);
	}

}
