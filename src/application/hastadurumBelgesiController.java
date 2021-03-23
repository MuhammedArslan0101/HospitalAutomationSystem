package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import entity.hasta;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import entity.hastadurumbelgesi;

public class hastadurumBelgesiController extends deiskenler implements Initializable, hastaduruminterface {

	int index;

	ObservableList<hastadurumbelgesi> listhd = FXCollections.observableArrayList(
			new hastadurumbelgesi(1, "muhamed", "98759", "Romatizim", "ahmet", "yogun bakimi ", "şfa"),
			new hastadurumbelgesi(2, "yusuf", "7474", "bas", "ahmet", "acil ", "yok")

	);
	ObservableList<String> drh_comboxData = FXCollections.observableArrayList();

	ObservableList<String> kisim_comboxData = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		drh_comboxData.add(new String("muhammed"));
		drh_comboxData.add(new String("ahmed"));
		drh_comboxData.add(new String("Yilmaz"));
		drh_comboxData.add(new String("Murat"));
		drh_comboxData.add(new String("Orhan"));

		drComboboxT.setItems(drh_comboxData);

		kisim_comboxData.add(new String("Yogun bakim"));
		kisim_comboxData.add(new String("Acil"));
		kisim_comboxData.add(new String("kadin"));
		kisim_comboxData.add(new String("Çocuk"));

		kisimComboboxT.setItems(kisim_comboxData);

		idhC.setCellValueFactory(new PropertyValueFactory<hastadurumbelgesi, Integer>("idh_gs"));
		adihC.setCellValueFactory(new PropertyValueFactory<hastadurumbelgesi, String>("adsoyad_gs"));
		tchC.setCellValueFactory(new PropertyValueFactory<hastadurumbelgesi, String>("tc"));
		hsthC.setCellValueFactory(new PropertyValueFactory<hastadurumbelgesi, String>("hastalik_gs"));
		drhC.setCellValueFactory(new PropertyValueFactory<hastadurumbelgesi, String>("drh_gs"));
		kisimC.setCellValueFactory(new PropertyValueFactory<hastadurumbelgesi, String>("kisim_gs"));
		nothC.setCellValueFactory(new PropertyValueFactory<hastadurumbelgesi, String>("not_gs"));
		hd_table.setItems(listhd);

	}

	@Override
	public void jhasEkle(ActionEvent e) {
		Integer id = Integer.parseInt(idhT.getText());
		String ad = adhT.getText();
		String tcc = tchT.getText();
		String hastalik = hastalikT.getText();

		String drr = drComboboxT.getValue();
		String kisim = kisimComboboxT.getValue();

		String not = notT.getText();

		listhd.add(new hastadurumbelgesi(id, ad, tcc, hastalik, drr, kisim, not));

	}

	@Override

	public void getSelected() {

		index = hd_table.getSelectionModel().getSelectedIndex();

		if (index <= -1) {
			return;

		}
		idhT.setText(idhC.getCellData(index).toString());
		adhT.setText(adihC.getCellData(index));
		tchT.setText(tchC.getCellData(index));
		drComboboxT.setValue(drhC.getCellData(index));
		kisimComboboxT.setValue(kisimC.getCellData(index));
		hastalikT.setText(hsthC.getCellData(index));

		notT.setText(nothC.getCellData(index));

	}

	@Override
	public void Sil(ActionEvent e)

	{
		if (index <= -1) {
			return;

		}
		hd_table.getItems().remove(index);

		index = -1;
		clearForm(e);

	}

	@Override
	public void Guncel(ActionEvent e) {

		listhd.set(index, getData());

		clearForm(e);
	}

	@Override
	public hastadurumbelgesi getData() {
		Integer id = Integer.parseInt(idhT.getText());
		String ad = adhT.getText();
		String tcc = tchT.getText();
		String hastalik = hastalikT.getText();

		String drr = drComboboxT.getValue();
		String kisim = kisimComboboxT.getValue();

		String not = notT.getText();

		return new hastadurumbelgesi(id, ad, tcc, hastalik, drr, kisim, not);

	}

	@Override
	public void clearForm(ActionEvent e) {
		idhT.clear();
		adhT.clear();
		tchT.clear();
		hastalikT.clear();

		drComboboxT.setValue(" Seçin lütfen");
		kisimComboboxT.setValue("Kisimi seçin ");
		notT.clear();

	}

	@Override
	public void deleteAll(ActionEvent event) {
		if (index <= -1) {
			return;

		}
		hd_table.getItems().removeAll(listhd);
	}

	@Override
	public void search() {
		search.textProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(javafx.beans.Observable arg0) {
				if (search.textProperty().get().isEmpty()) {
					hd_table.setItems(listhd);
					return;
				}
				ObservableList<hastadurumbelgesi> items = FXCollections.observableArrayList();
				ObservableList<TableColumn<hastadurumbelgesi, ?>> column = hd_table.getColumns();

				for (int row = 0; row < listhd.size(); row++) {
					for (int col = 0; col < column.size(); col++) {
						TableColumn colVar = column.get(col);
						String cellValue = colVar.getCellData(listhd.get(row)).toString();

						cellValue = cellValue.toLowerCase();
						if (cellValue.contains(search.getText().toLowerCase())
								&& cellValue.startsWith(search.getText().toLowerCase())) {
							items.add(listhd.get(row));
							break;
						}
					}
				}
				hd_table.setItems(items);
			}
		});
	}

	@FXML
	private Button btnn;

	
	public void kaydet12(ActionEvent event) {
		Stage secondaryStage = new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("tablu kayedet");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		if (listhd.isEmpty()) {
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
				dosyakaydetme12(hd_table.getItems(), file);
			}
		}
	}

	
	public void dosyakaydetme12(ObservableList<hastadurumbelgesi> observablehastaList, File file) {
		try {
			BufferedWriter outWriter = new BufferedWriter(new FileWriter(file));

			for (hastadurumbelgesi hastalard : observablehastaList) {
				outWriter.write(hastalard.toString());
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

}
