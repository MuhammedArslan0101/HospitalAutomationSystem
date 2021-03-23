package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import entity.odalar;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class odalarController extends deiskenler implements Initializable ,Odalarinterface {
	int index;

	ObservableList<odalar> listodalar = FXCollections.observableArrayList(
			
			new odalar("yusuf", 1, 2, "doulu"),
			new odalar("muh", 1, 2, "bos")

	);
	ObservableList<String> oda_comboxData = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		oda_comboxData.add(new String("dolu"));
		oda_comboxData.add(new String("bos"));
		oda_comboxData.add(new String("musait yer var"));
		durumT.setItems(oda_comboxData);

		adiC.setCellValueFactory(new PropertyValueFactory<odalar, String>("ad_gs"));
		odaC.setCellValueFactory(new PropertyValueFactory<odalar, Integer>("odano_gs"));
		kisiC.setCellValueFactory(new PropertyValueFactory<odalar, Integer>("kisisayisi_gs"));
		durumuC.setCellValueFactory(new PropertyValueFactory<odalar, String>("durumoda_gs"));
	
		table_oda.setItems(listodalar);
	}

	@FXML
	@Override
	public void clear(ActionEvent event) {
		  adT.clear();
		   kisisT.clear();
		   odanoT.clear();
		    durumT.setValue("durum seçin");;
	}

	@FXML
	@Override
	public void ekle(ActionEvent event) throws IOException {
		String ad = adT.getText();
		Integer odano = Integer.parseInt(odanoT.getText());
		Integer kisisayi = Integer.parseInt(kisisT.getText());
		String durum = durumT.getValue();

		listodalar.add(new odalar(ad, odano, kisisayi, durum));

		BufferedWriter bw = new BufferedWriter(new FileWriter("odalar.txt"));
		try {
			for (odalar a : listodalar) {
				String text = a.getAd_gs() + "," + a.getOdano_gs() + "," + a.getKisisayisi_gs() + ","
						+ a.getDurumoda_gs() + "\n";

				bw.write(text);
			}

			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
@Override
	public void getSelected() {

		index = table_oda.getSelectionModel().getSelectedIndex();

		if (index <= -1) {
			return;

		}
		odanoT.setText(odaC.getCellData(index).toString());
		adT.setText(adiC.getCellData(index));

		durumT.setValue(durumuC.getCellData(index));
		kisisT.setText(kisiC.getCellData(index).toString());

	}

	@FXML
	@Override
	public void guncelle(ActionEvent event) {
		listodalar.set(index, getData());
		
	}
@Override
	public odalar getData() {
		String ad = adT.getText();
		Integer odano = Integer.parseInt(odanoT.getText());
		Integer kisisa = Integer.parseInt(kisisT.getText());
		String durum = durumT.getValue();
		

		return new odalar( ad, odano ,kisisa , durum);

	}
	@FXML
	 @Override
	public void readFile(ActionEvent event) {
		
		String filepath="odalar.txt" ;
		try
		{
		FileReader reader = new FileReader (filepath);
		BufferedReader br = new BufferedReader(reader) ;
		String s;
		while((s=br.readLine())!=null)
			{
			textAreaT.appendText(s + "\n");
			}
		reader.close();
		}
		catch(Exception ae)
		{
		System.out.println(ae);
		}

	}

	@FXML
	@Override
	public void sil(ActionEvent event) {
		if (index <= -1) {
			return;

		}
		table_oda.getItems().remove(index);
		// nullexception için
		index = -1;

	}
	
	public void search() {
		search.textProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(javafx.beans.Observable arg0) {
				if (search.textProperty().get().isEmpty()) {
					table_oda.setItems(listodalar);
					return;
				}
				ObservableList<odalar> items = FXCollections.observableArrayList();
				ObservableList<TableColumn<odalar, ?>> column = table_oda.getColumns();

				for (int row = 0; row < listodalar.size(); row++) {
					for (int col = 0; col < column.size(); col++) {
						TableColumn colVar = column.get(col);
						String cellValue = colVar.getCellData(listodalar.get(row)).toString();
						// buyuk yada kuçuk farketmez

						cellValue = cellValue.toLowerCase();
						if (cellValue.contains(search.getText().toLowerCase())
								&& cellValue.startsWith(search.getText().toLowerCase())) {
							items.add(listodalar.get(row));
							break;
						}
					}
				}
				table_oda.setItems(items);
			}
		});
	}

}
