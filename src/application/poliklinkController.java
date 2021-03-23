package application;

import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import entity.poliknikler;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class poliklinkController extends deiskenler implements Initializable ,poliklinkinterface {

	ObservableList<poliknikler> listpoliklink = FXCollections.observableArrayList(
			new poliknikler(1, "acil", "dr muhammed", "3:30 , 4:23"),

			new poliknikler(1, "yugunbakim", "dr yusuf", "12:30 , 4:23")

	);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		idpolC.setCellValueFactory(new PropertyValueFactory<poliknikler, Integer>("polikid_gs"));
		polisimC.setCellValueFactory(new PropertyValueFactory<poliknikler, String>("polikisim_gs"));
		nobetC.setCellValueFactory(new PropertyValueFactory<poliknikler, String>("nobetci_gs"));
		saatpolC.setCellValueFactory(new PropertyValueFactory<poliknikler, String>("calismasaat_gs"));
		pol_tablo.setItems(listpoliklink);
	}

	@FXML
	@Override
	public void polEkle(ActionEvent e) {
		Integer id = Integer.parseInt(idpolT.getText());
		String isim = polisimT.getText();
		String nobetci = polnobetT.getText();
		String saat = claismaT.getText();

		listpoliklink.add(new poliknikler(id, isim, nobetci, saat));
		clearForm(e);
	}

	int index;
@Override
	public void getSelectedpol() {

		index = pol_tablo.getSelectionModel().getSelectedIndex();

		if (index <= -1) {
			return;

		}
		idpolT.setText(idpolC.getCellData(index).toString());
		polisimT.setText(polisimC.getCellData(index));
		polnobetT.setText(nobetC.getCellData(index));
		claismaT.setText(saatpolC.getCellData(index));

	}

	@FXML
	@Override
	public void polGuncel(ActionEvent event) {
		listpoliklink.set(index, getDatapol());

		clearForm(event);
	}
@Override
	public poliknikler getDatapol() {

		Integer id = Integer.parseInt(idpolT.getText());
		String isim = polisimT.getText();
		String nobetci = polnobetT.getText();
		String saat = claismaT.getText();

		return new poliknikler(id, isim, nobetci, saat);

	}

	@FXML
	@Override
	public void polSil(ActionEvent event) {
		if (index <= -1) {
			return;

		}
		pol_tablo.getItems().remove(index);

		index = -1;
		clearForm(event);
	}
@Override
	public void clearForm(ActionEvent event) {
		idpolT.clear();
		polisimT.clear();
		polnobetT.clear();
		claismaT.clear();

	}
	
	public void search() {
		search.textProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(javafx.beans.Observable arg0) {
				if (search.textProperty().get().isEmpty()) {
					pol_tablo.setItems(listpoliklink);
					return;
				}
				ObservableList<poliknikler> items = FXCollections.observableArrayList();
				ObservableList<TableColumn<poliknikler, ?>> column = pol_tablo.getColumns();

				for (int row = 0; row < listpoliklink.size(); row++) {
					for (int col = 0; col < column.size(); col++) {
						TableColumn colVar = column.get(col);
						String cellValue = colVar.getCellData(listpoliklink.get(row)).toString();
						// buyuk yada kuçuk farketmez

						cellValue = cellValue.toLowerCase();
						if (cellValue.contains(search.getText().toLowerCase())
								&& cellValue.startsWith(search.getText().toLowerCase())) {
							items.add(listpoliklink.get(row));
							break;
						}
					}
				}
				pol_tablo.setItems(items);
			}
		});
	}

}
