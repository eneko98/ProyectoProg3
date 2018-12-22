
import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JFileChooser;

public class BDArchivos {
	static JFileChooser fc;
	
	
	public static void escogerArchivo() {
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		int estado = fc.showOpenDialog(null);
		
		if(estado==JFileChooser.APPROVE_OPTION) {
			Connection connection = BD.initBD("FicherosBD");
			Statement statement = BD.usarCrearTablasBD(connection);
			File fichero = fc.getSelectedFile();
			BD.usarCrearTablasBD(connection);
			
		}else {
			escogerArchivo();
		}
	}


}

