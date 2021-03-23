package util;

import java.awt.Desktop;
import java.net.URI;



public class  util {

public static void goLink (String link)
{
	try
	{
		Desktop.getDesktop().browse(new URI(link));
	}catch (Exception ex)
	{
		ex.printStackTrace();
	}
}



}
