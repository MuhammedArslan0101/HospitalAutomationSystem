package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import entity.Admin;
import entity.insan;
import entity.personel;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class personel_ekle extends insan implements Initializable, personelinterface {

	int index;

	ObservableList<personel> listpersonel = FXCollections.observableArrayList(
			new personel(1, "muhamed", "Arslan", "418987589", "mudur", 536955558, 2500, "Acil", LocalDate.now()),
			new personel(2, "yusuf", "Arslan", "89756973", "mudur yrd", 537589689, 2500, "YogunBakim", LocalDate.now())

	);

	ObservableList<String> polikper_comboxData = FXCollections.observableArrayList();

	ObservableList<String> personeltur_comboxData = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		polikper_comboxData.add(new String("idari"));
		polikper_comboxData.add(new String("Acil"));
		polikper_comboxData.add(new String("Yogun Bakim"));
		polikper_comboxData.add(new String("Cocuk"));
		polikper_comboxData.add(new String("Cerrah"));

		polikper_combox.setItems(polikper_comboxData);

		personeltur_comboxData.add(new String("Mudur"));
		personeltur_comboxData.add(new String("Mudur Yrd"));
		personeltur_comboxData.add(new String("Doktor"));
		personeltur_comboxData.add(new String("Nurse"));

		personeltur_combox.setItems(personeltur_comboxData);

		idC.setCellValueFactory(new PropertyValueFactory<personel, Integer>("idper_gs"));
		adC.setCellValueFactory(new PropertyValueFactory<personel, String>("adper_gs"));
		soyadC.setCellValueFactory(new PropertyValueFactory<personel, String>("soyper_gs"));
		kimlikC.setCellValueFactory(new PropertyValueFactory<personel, String>("tcper_gs"));
		personelturC.setCellValueFactory(new PropertyValueFactory<personel, String>("personeltur_gs"));
		teleC.setCellValueFactory(new PropertyValueFactory<personel, Long>("teleper_gs"));
		polikC.setCellValueFactory(new PropertyValueFactory<personel, String>("polikper_gs"));
		maasC.setCellValueFactory(new PropertyValueFactory<personel, Integer>("massper_gs"));
		tarihC.setCellValueFactory(new PropertyValueFactory<personel, LocalDate>("tarihper_gs"));
		per_table.setItems(listpersonel);

	}

	@Override
	public void perEkle(ActionEvent e) throws IOException {

		Integer id = Integer.parseInt(idperT.getText());
		String ad = adperT.getText();
		String soyad = soyperT.getText();
		String tc = tcperT.getText();
		Long tele = Long.parseLong(teleperT.getText());
		Integer maas = Integer.parseInt(maasperT.getText());
		String polik = polikper_combox.getValue();
		String tur = personeltur_combox.getValue();
		LocalDate tarih = tarihperT.getValue();

		listpersonel.add(new personel(id, ad, soyad, tc, tur, tele, maas, polik, tarih));

		BufferedWriter bw = new BufferedWriter(new FileWriter("personel.txt"));
		try {
			for (personel a : listpersonel) {
				String text = a.getIdper_gs() + "," + a.getAdper_gs() + "," + a.getSoyper_gs() + ","
						+ a.getTcper_gs() + "," + a.getPersoneltur_gs() + "," + a.getTeleper_gs() + ","
						+ a.getMassper_gs() + "," + a.getPolikper_gs() + "," + a.getTarihper_gs() + "\n";

				bw.write(text);
			}

			bw.close();

		} catch (IOException ee) {
			ee.printStackTrace();
		}

	}

	@Override
	public void getSelected() {

		index = per_table.getSelectionModel().getSelectedIndex();

		if (index <= -1) {
			return;

		}
		idperT.setText(idC.getCellData(index).toString());
		adperT.setText(adC.getCellData(index));
		soyperT.setText(soyadC.getCellData(index));
		personeltur_combox.setValue(personelturC.getCellData(index));
		tcperT.setText(kimlikC.getCellData(index));
		teleperT.setText(teleC.getCellData(index).toString());
		maasperT.setText(maasC.getCellData(index).toString());

		polikper_combox.setValue(polikC.getCellData(index));

		tarihperT.setValue(tarihC.getCellData(index));

	}

	@Override
	public void personelSil(ActionEvent e)

	{
		if (index <= -1) {
			return;

		}
		per_table.getItems().remove(index);
		// nullexception için
		index = -1;
		clearForm(e);

	}

	@Override
	public void personelGuncel(ActionEvent e) {

		listpersonel.set(index, getData());

		clearForm(e);
	}

	@Override
	public personel getData() {
		Integer id = Integer.parseInt(idperT.getText());
		String ad = adperT.getText();
		String soyad = soyperT.getText();
		String tc = tcperT.getText();
		Long tele = Long.parseLong(teleperT.getText());
		Integer maas = Integer.parseInt(maasperT.getText());
		String polik = polikper_combox.getValue();
		LocalDate tarih = tarihperT.getValue();
		String tur = personeltur_combox.getValue();

		return new personel(id, ad, soyad, tc, tur, tele, maas, polik, tarih);

	}

	@Override
	public void clearForm(ActionEvent e) {
		idperT.clear();
		adperT.clear();
		soyperT.clear();
		teleperT.clear();
		maasperT.clear();
		tcperT.clear();
		polikper_combox.setValue(" Seçin lütfen");
		personeltur_combox.setValue("turu seçin ");
		search.clear();
		tarihperT.setValue(null);

	}

	@Override
	public void deleteAll(ActionEvent event) {
		if (index <= -1) {
			return;

		}
		per_table.getItems().removeAll(listpersonel);
	}

	@Override
	public void search() {
		search.textProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(javafx.beans.Observable arg0) {
				if (search.textProperty().get().isEmpty()) {
					per_table.setItems(listpersonel);
					return;
				}
				ObservableList<personel> items = FXCollections.observableArrayList();
				ObservableList<TableColumn<personel, ?>> column = per_table.getColumns();

				for (int row = 0; row < listpersonel.size(); row++) {
					for (int col = 0; col < column.size(); col++) {
						TableColumn colVar = column.get(col);
						String cellValue = colVar.getCellData(listpersonel.get(row)).toString();
						// buyuk yada kuçuk farketmez

						cellValue = cellValue.toLowerCase();
						if (cellValue.contains(search.getText().toLowerCase())
								&& cellValue.startsWith(search.getText().toLowerCase())) {
							items.add(listpersonel.get(row));
							break;
						}
					}
				}
				per_table.setItems(items);
			}
		});
	}

	@Override
	public void kaydet(ActionEvent event) {
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
				dosyakaydetme(per_table.getItems(), file);
			}
		}
	}

	@Override
	public void dosyakaydetme(ObservableList<personel> observablePersonelList, File file) {
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

	public void importData() throws IOException {

		Collection<personel> listf = Files.readAllLines(new File("personel.txt").toPath()).stream().map(line -> {
			String[] details = line.split(",");
			personel cd = new personel();
			cd.setIdper_gs(Integer.parseInt(details[0]));
			cd.setAdper_gs(details[1]);
			cd.setSoyper_gs(details[2]);
			cd.setPersoneltur_gs(details[3]);

			cd.setTcper_gs(details[4]);
			cd.setTeleper_gs(Long.parseLong(details[5]));

			cd.setMassper_gs(Integer.parseInt(details[6]));
			cd.setPolikper_gs(details[7]);

			cd.setTarihper_gs(LocalDate.parse(details[8]));

			return cd;
		}).collect(Collectors.toList());

		ObservableList<personel> details = FXCollections.observableArrayList(listf);

		per_table.setItems(details);
	}
}
