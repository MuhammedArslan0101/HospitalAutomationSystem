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
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javax.swing.JFileChooser;

import entity.Admin;
import entity.yemek;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class yemekController extends deiskenler implements Initializable  , yemekinterface{
	
	
		
	
	
int index;
	
	ObservableList<yemek> listyemek = FXCollections.observableArrayList(
			new yemek (1, "muhamed",  55 ,"sabah yemegi", "verildi"),

			new yemek( 2, "yusuf", 66 , "aksam yemegi" , "verilmedi")

	);

	ObservableList<String> yemektur_comboxData = FXCollections.observableArrayList();
	ObservableList<String> yemekdurum_comboxData = FXCollections.observableArrayList();
	@Override
	public void addyemek(ActionEvent e) throws IOException {
		
		if (isValidInput(e)) {
			
		

		Integer id = Integer.parseInt(idyemekT.getText());
		String ad = adyemekhastaT.getText(); 
		Integer oda = Integer.parseInt(odanoyemekT.getText());
		String yemektur = turyemek_Combox.getValue();

		String durum = durumyemek_combox.getValue();
	

		listyemek.add(new yemek (id, ad,oda , yemektur, durum) );
		
		BufferedWriter bw =new BufferedWriter (new FileWriter ("yemek.txt"));
		try 
		{			
			for (yemek y : listyemek) {
				 String text = y.getIdyemek_gs() + "," + y.getAdy_gs() + "," + y.getOdano() + "," + y.getYemektur_gs() + "," + y.getDurumtur_gs() + "\n";
				 
				 bw.write(text);
			}
			
			bw.close ();
			
		} catch (IOException e3) {
			e3.printStackTrace ();
		}
		}else
			{Alert emptyCom = new Alert(Alert.AlertType.WARNING, "HATA", ButtonType.OK);
        Window owner = ((Node) e.getTarget()).getScene().getWindow();
        emptyCom.setContentText("Lutfen Formu Doldurun ");
        emptyCom.initModality(Modality.APPLICATION_MODAL);
        emptyCom.initOwner(owner);
        emptyCom.showAndWait();
        if (emptyCom.getResult() == ButtonType.OK) {
        	emptyCom.close();}
			}
		
	}
	@Override
	public void getSelected() {

		index = yemek_tablo.getSelectionModel().getSelectedIndex();

		if (index <= -1) {
			return;

		}
		idyemekT.setText(idyemekC.getCellData(index).toString());
		adyemekhastaT.setText(adyemekC.getCellData(index));
		odanoyemekT.setText(odanoC.getCellData(index).toString());

		durumyemek_combox.setValue(durumyemekC.getCellData(index));
		turyemek_Combox.setValue(yemekturC.getCellData(index));
	

		

	}
	@Override
	public void yemekSil(ActionEvent e)

	{
		if (index <= -1) {
			return;

		}
		yemek_tablo.getItems().remove(index);
		// nullexception için
		index = -1;
		clearForm(e);

	}
	@Override

	public void YemekGuncel(ActionEvent e) {

		listyemek.set(index, getData());
		
		clearForm(e);
	}
@Override
	public yemek getData() {

		Integer id = Integer.parseInt(idyemekT.getText());
		String ad = adyemekhastaT.getText();
		Integer oda = Integer.parseInt(odanoyemekT.getText());
		String yemektur = turyemek_Combox.getValue();

		String durum = durumyemek_combox.getValue();
		

		return  new yemek (id, ad,oda , yemektur, durum) ;

	}
@Override
	public void clearForm(ActionEvent e) {
		idyemekT.clear();
		adyemekhastaT.clear();
		odanoyemekT.clear();

		turyemek_Combox.setValue("YemekTuru seçin");
		durumyemek_combox.setValue("Durumu seçin");
		
		textareayemek.clear();
		

		

	}
@Override
	public void deleteAll(ActionEvent event) {
		if (index <= -1) {
			return;

		}
		yemek_tablo.getItems().removeAll(listyemek);
	}
	
	
	public void search() {
		search.textProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(javafx.beans.Observable arg0) {
				if (search.textProperty().get().isEmpty()) {
					yemek_tablo.setItems(listyemek);
					return;
				}
				ObservableList<yemek> items = FXCollections.observableArrayList();
				ObservableList<TableColumn<yemek, ?>> column = yemek_tablo.getColumns();

				for (int row = 0; row < listyemek.size(); row++) {
					for (int col = 0; col < column.size(); col++) {
						TableColumn colVar = column.get(col);
						String cellValue = colVar.getCellData(listyemek.get(row)).toString();
						// buyuk yada kuçuk farketmez

						cellValue = cellValue.toLowerCase();
						if (cellValue.contains(search.getText().toLowerCase())
								&& cellValue.startsWith(search.getText().toLowerCase())) {
							items.add(listyemek.get(row));
							break;
						}
					}
				}
				yemek_tablo.setItems(items);
			}
		});
	}


@Override
	public void kaydet(ActionEvent event) {
		Stage secondaryStage = new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("tablu kayedet");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		if (listyemek.isEmpty()) {
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
				dosyakaydetme(yemek_tablo.getItems(), file);
			}
		}
	}
	
	public void dosyakaydetme(ObservableList<yemek> observableyemekList, File file) {
		try {
			BufferedWriter outWriter = new BufferedWriter(new FileWriter(file));

			for (yemek yemekler : observableyemekList) {
				outWriter.write(yemekler.toString());
				outWriter.newLine();
			}
			 
			System.out.println(observableyemekList.toString());
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
	
	public void showFile (ActionEvent e) throws IOException
	{
		JFileChooser open = new JFileChooser();
		open.showOpenDialog(null) ;
		File f =  open.getSelectedFile();
		String filename = f.getAbsolutePath();
		
		try
		{
		FileReader reader = new FileReader (filename);
		BufferedReader br = new BufferedReader(reader) ;
		String s;
		while((s=br.readLine())!=null)
			{
			textareayemek.appendText(s + "\n");
			}
		
		reader.close();
		}
		catch(Exception ae)
		{
		System.out.println(ae);
		}
		
	}
	public void readtext (ActionEvent e) throws IOException
	{
		String filepath="yemek.txt" ;
		try 
		{
		FileReader reader = new FileReader (filepath);
		BufferedReader br = new BufferedReader(reader) ;
		String s;
		while((s=br.readLine())!=null)
			{
			textareayemek.appendText(s + "\n");
			}
		reader.close();
		}
		catch(Exception ae)
		{
		System.out.println(ae);
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		idyemekC.setCellValueFactory(new PropertyValueFactory<yemek, Integer>("idyemek_gs"));
		adyemekC.setCellValueFactory(new PropertyValueFactory<yemek, String>("ady_gs"));
		odanoC.setCellValueFactory(new PropertyValueFactory<yemek, Integer>("odano"));
		yemekturC.setCellValueFactory(new PropertyValueFactory<yemek, String>("yemektur_gs"));
		durumyemekC.setCellValueFactory(new PropertyValueFactory<yemek, String>("durumtur_gs"));
	

		yemek_tablo.setItems(listyemek);

		yemektur_comboxData.add(new String("sabah yemegi"));
		yemektur_comboxData.add(new String("ogle yemegi"));
		yemektur_comboxData.add(new String("aksam yemegi"));
		

		turyemek_Combox.setItems(yemektur_comboxData);
		
		yemekdurum_comboxData.add(new String("verldi"));
		yemekdurum_comboxData.add(new String("verilmedi"));
	
		

		durumyemek_combox.setItems(yemekdurum_comboxData);

		
		
	}

	public void importData() throws IOException {

		Collection<yemek> listf = Files.readAllLines(new File("yemek.txt").toPath()).stream().map(line -> {
			String[] details = line.split(",");
			yemek cd = new yemek();
			cd.setIdyemek_gs(Integer.parseInt(details[0]));
			cd.setAdy_gs(details[1]);
			cd.setOdano(Integer.parseInt(details[2]));
			cd.setYemektur_gs(details[3]);
			cd.setDurumtur_gs(details[4]);
			
			

			return cd;
		}).collect(Collectors.toList());

		ObservableList<yemek> details = FXCollections.observableArrayList(listf);

		yemek_tablo.setItems(details);
	}
	
    private boolean isValidInput(ActionEvent event) {

        Boolean validInput = true;

        if(idyemekT == null || idyemekT.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptyid = new Alert(Alert.AlertType.WARNING, "Hata", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyid.setContentText("id Bos ");
            emptyid.initModality(Modality.APPLICATION_MODAL);
            emptyid.initOwner(owner);
            emptyid.showAndWait();
            if(emptyid.getResult() == ButtonType.OK) {
            	emptyid.close();
            	idyemekT.requestFocus();
            }
        }
        if(adyemekhastaT == null || adyemekhastaT.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptyad= new Alert(Alert.AlertType.WARNING, "Hata", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyad.setContentText("Adi Bostur");
            emptyad.initModality(Modality.APPLICATION_MODAL);
            emptyad.initOwner(owner);
            emptyad.showAndWait();
            if (emptyad.getResult() == ButtonType.OK) {
            	emptyad.close();
            	adyemekhastaT.requestFocus();
            }
        }
        if(odanoyemekT == null || odanoyemekT.getText().trim().isEmpty()) {
            validInput = false;
            Alert emptyoda= new Alert(Alert.AlertType.WARNING, "hata", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyoda.setContentText("Oda Bostur");
            emptyoda.initModality(Modality.APPLICATION_MODAL);
            emptyoda.initOwner(owner);
            emptyoda.showAndWait();
            if (emptyoda.getResult() == ButtonType.OK) {
            	emptyoda.close();
            	odanoyemekT.requestFocus();
            }
        }
       /* if(turyemek_Combox == null || turyemek_Combox.getValue().trim().isEmpty()) {
            validInput = false;
            Alert emptytur = new Alert(Alert.AlertType.WARNING, "Hata", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptytur.setContentText("yemek Tur Combo box u  bostur");
            emptytur.initModality(Modality.APPLICATION_MODAL);
            emptytur.initOwner(owner);
            emptytur.showAndWait();
            if (emptytur.getResult() == ButtonType.OK) {
            	emptytur.close();
                turyemek_Combox.requestFocus();
            }
        }
        if(durumyemek_combox == null || durumyemek_combox.getValue().trim().isEmpty()) {
            validInput = false;
            Alert emptyCom = new Alert(Alert.AlertType.WARNING, "HATA", ButtonType.OK);
            Window owner = ((Node) event.getTarget()).getScene().getWindow();
            emptyCom.setContentText("durum Combobox u bostur");
            emptyCom.initModality(Modality.APPLICATION_MODAL);
            emptyCom.initOwner(owner);
            emptyCom.showAndWait();
            if (emptyCom.getResult() == ButtonType.OK) {
            	emptyCom.close();
                durumyemek_combox.requestFocus();
            }
        }*/
      
        
        return validInput;
    }
   
    }

