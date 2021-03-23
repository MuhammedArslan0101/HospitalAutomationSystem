
package application;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class firstPage extends deiskenler {
	private static  Scanner x;
	
	

	public void about(ActionEvent e) throws IOException, SQLException {
	
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/about.fxml"));

		Scene scene = new Scene(root, 477, 306);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void colseApp(ActionEvent e) {
		Platform.exit();
		System.exit(0);
	}

	/*
	 * public void LLLL(ActionEvent e) throws IOException {
	 * 
	 * if (username.getText().equals("admin") && password.getText().equals("admin"))
	 * { status.setText("success");
	 * 
	 * Stage primaryStage = new Stage(); Parent root =
	 * FXMLLoader.load(getClass().getResource("admin_islemleri.fxml"));
	 * 
	 * Scene scene = new Scene(root, 450, 450);
	 * scene.getStylesheets().add(getClass().getResource("application.css").
	 * toExternalForm());
	 * 
	 * primaryStage.setScene(scene); primaryStage.show();
	 * ((Node)e.getSource()).getScene().getWindow().hide();
	 * 
	 * } else if (username.getText().equals("personel") &&
	 * (password.getText().equals("123"))) { status.setText("success");
	 * 
	 * Stage primaryStage = new Stage(); Parent root =
	 * FXMLLoader.load(getClass().getResource("per_islemleri.fxml"));
	 * 
	 * Scene scene = new Scene(root, 450, 450);
	 * scene.getStylesheets().add(getClass().getResource("application.css").
	 * toExternalForm());
	 * 
	 * primaryStage.setScene(scene); primaryStage.show();
	 * 
	 * ((Node)e.getSource()).getScene().getWindow().hide(); }
	 * 
	 * else status.setText("faild"); username.clear(); password.clear();
	 * 
	 * }
	 */

	public void loginn(ActionEvent e) throws IOException {
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("admin_islemleri.fxml"));

		Scene scene = new Scene(root, 450, 450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.show();
		((Node) e.getSource()).getScene().getWindow().hide();

		

	}
	/*
	 * List<Admin> list = Map<String,String> map = new HashMap<String,String>();
	 * 
	 * for (Admin a:list) { map.put(a.getUsername(), a.getPassword());
	 * 
	 * } if(map.containsKey(username.getText())) { String
	 * val2=map.get(username.getText()); if(val2.equals(password.getText())) {
	 * check.setText("Success");
	 * 
	 * 
	 * Stage primaryStage = new Stage (); Parent root =
	 * FXMLLoader.load(getClass().getResource(".fxml"));
	 * 
	 * Scene scene = new Scene(root,700,500);
	 * scene.getStylesheets().add(getClass().getResource("application.css").
	 * toExternalForm()) ;
	 * 
	 * primaryStage.setScene(scene); primaryStage.show();
	 * 
	 * } else { check.setText("Faild"); }
	 * 
	 * } else { check.setText("Faild"); }
	 * 
	 * }
	 */

	public void forgotpassword(ActionEvent e) throws IOException {

		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/forgotpassword.fxml"));

		Scene scene = new Scene(root, 450, 450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void pressforpasssword(ActionEvent e) {
		/*if (usernameforpassword.getText().equals("admin")) {
			faildusername.setText("");
			yourpassword.setText("admin");
		} else {
			yourpassword.setText("");
			faildusername.setText("user name is fault");
		}*/
		boolean bulundu = false;
		String tmp_id = "" ;
		
		String tmp_un = "";
		String tmp_up = "";
		String filepath = "C:\\Users\\Muhammed ARSLAN\\eclipse-workspace\\NesneProjesi\\admin.txt" ;
		

		try {
			x = new Scanner (new File(filepath));
			x.useDelimiter("[,\n]");
		
			while (x.hasNext() && !bulundu) {
				tmp_id = x.next();
				tmp_un = x.next() ;
				tmp_up = x.next();
				if (tmp_un.trim().equals(usernameforpassword.getText())) {
					
					System.out.println("bulundu");
					yourpassword.setText(tmp_up.trim());
					
			

				}//else
					//yourpassword.setText("hatadir");
				
			}
			
	

		} catch (Exception ee) {
			
		}
	}

	/*
	 * @Override public void showTime() {
	 * 
	 * Date d = new Date (); SimpleDateFormat s=new SimpleDateFormat("yyyy-mm-dd");
	 * date.setText(s.format(d));
	 * 
	 * }
	 * 
	 * @Override public void showDate() { new Timer(0,new ActionListener() { public
	 * void actionPerformed (ActionEvent e) { Date d = new Date(); SimpleDateFormat
	 * s = new SimpleDateFormat("hh:mm:ss a"); saat.setText(s.format(d)); throw new
	 * UnsupportedOperationException("desteklemez");
	 * 
	 * }
	 * 
	 * 
	 * }).start();
	 */

}
