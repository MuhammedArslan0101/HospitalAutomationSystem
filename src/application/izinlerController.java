package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import entity.izinler;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class izinlerController extends deiskenler implements Initializable ,izinlerinterface {



	ObservableList<izinler> listizinler = FXCollections.observableArrayList(
			new izinler(1, "muhamed", LocalDate.now(), LocalDate.now(), "acil isi cikti"),
			new izinler(2, "yusuf", LocalDate.now(), LocalDate.now(), "tatile cikti")

	);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		idizinC.setCellValueFactory(new PropertyValueFactory<izinler, Integer>("idizin_gs"));
		izinadC.setCellValueFactory(new PropertyValueFactory<izinler, String>("izinad_gs"));
		bastarihiC.setCellValueFactory(new PropertyValueFactory<izinler, LocalDate>("bas"));
		bitistarihiC.setCellValueFactory(new PropertyValueFactory<izinler, LocalDate>("bitis"));
		aciklamaC.setCellValueFactory(new PropertyValueFactory<izinler, String>("aciklama"));

		izin_tablo.setItems(listizinler);

	}
@Override
	public void izinEkle(ActionEvent e) throws IOException {

		Integer id = Integer.parseInt(izinidT.getText());
		String adsoyad = izinliadiT.getText();

		LocalDate bas = bastarihiT.getValue();
		LocalDate bitis = bitisT.getValue();

		String aciklama = aciklamaT.getText();
		listizinler.add(new izinler(id , adsoyad , bas , bitis , aciklama));
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("izinler.txt"));
		try {
			for (izinler iz  : listizinler) {
				String text = iz.getIdizin_gs() + "," + iz.getIzinad_gs() + "," + iz.getBas() + "," + iz.getBitis() + ","
						+ iz.getAciklama()+  "\n";

				bw.write(text);
			}

			bw.close();

		} catch (IOException eee) {
			eee.printStackTrace();
		}

	}
	int index ;
@Override
	public void getSelected() {

		index = izin_tablo.getSelectionModel().getSelectedIndex();

		if (index <= -1) {
			return;

		}
		izinidT.setText(idizinC.getCellData(index).toString());
		izinliadiT.setText(izinadC.getCellData(index));
		aciklamaT.setText(aciklamaC.getCellData(index));

	}
@Override
	public void izinSil(ActionEvent e)

	{
		if (index <= -1) {
			return;

		}
		izin_tablo.getItems().remove(index);
		index = -1;
		clearFormiz(e);

	}
@Override
	public void izinGuncel(ActionEvent e) {

		listizinler.set(index, getDataiz());

		clearFormiz(e);
	}
@Override
	public izinler getDataiz() {
		Integer id = Integer.parseInt(izinidT.getText());
		String adsoyad = izinliadiT.getText();

		LocalDate bas = bastarihiT.getValue();
		LocalDate bitis = bitisT.getValue();

		String aciklama = aciklamaT.getText();
		
		return new izinler(id , adsoyad , bas , bitis , aciklama);

	}
@Override
	public void clearFormiz(ActionEvent e) {
		izinidT.clear();
		izinliadiT.clear();
		bastarihiT.setValue(null);
		bitisT.setValue(null);
		aciklamaT.clear();

	}
@Override
	public void deleteAlliz(ActionEvent event) {
		if (index <= -1) {
			return;

		}
		izin_tablo.getItems().removeAll(listizinler);
	}
	
	public void search() {
		search.textProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(javafx.beans.Observable arg0) {
				if (search.textProperty().get().isEmpty()) {
					izin_tablo.setItems(listizinler);
					return;
				}
				ObservableList<izinler> items = FXCollections.observableArrayList();
				ObservableList<TableColumn<izinler, ?>> column = izin_tablo.getColumns();

				for (int row = 0; row < listizinler.size(); row++) {
					for (int col = 0; col < column.size(); col++) {
						TableColumn colVar = column.get(col);
						String cellValue = colVar.getCellData(listizinler.get(row)).toString();
						// buyuk yada kuçuk farketmez

						cellValue = cellValue.toLowerCase();
						if (cellValue.contains(search.getText().toLowerCase())
								&& cellValue.startsWith(search.getText().toLowerCase())) {
							items.add(listizinler.get(row));
							break;
						}
					}
				}
				izin_tablo.setItems(items);
			}
		});
	}
@Override
	public void readtext (ActionEvent e) throws IOException
	{
		String filepath="izinler.txt" ;
		try
		{
		FileReader reader = new FileReader (filepath);
		BufferedReader br = new BufferedReader(reader) ;
		String s;
		while((s=br.readLine())!=null)
			{
			izintext.appendText(s + "\n");
			}
		reader.close();
		}
		catch(Exception ae)
		{
		System.out.println(ae);
		}
	}
	@Override
	public void cleatTextArea ()
	{
		izintext.clear();
	}
}
