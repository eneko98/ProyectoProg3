
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
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
			String nuevaURL = "src/Media/" + fichero.getName();
			File newFile = new File(nuevaURL);
			try {
				copyFile(fichero, newFile );
			} catch (IOException e) {
				e.printStackTrace();
			}
			BD.usarCrearTablasBD(connection);
//			BD.cancionInsert(statement, cancion)
			
		
			
		}
	}

	public static void copyFile(File sourceFile, File destFile) throws IOException {
	    if(!destFile.exists()) {
	        destFile.createNewFile();
	    }
	 
	    FileChannel origen = null;
	    FileChannel destino = null;
	    try {
	        origen = new FileInputStream(sourceFile).getChannel();
	        destino = new FileOutputStream(destFile).getChannel();
	 
	        long count = 0;
	        long size = origen.size();              
	        while((count += destino.transferFrom(origen, count, size-count))<size);
	    }
	    finally {
	        if(origen != null) {
	            origen.close();
	        }
	        if(destino != null) {
	            destino.close();
	        }
	    }
	}
}

