import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class DatosCancion extends JFrame {
	
	private JTextField escTitulo;
	private JTextField escAutor;
	private JTextField escFS;
	String titulo = "Datos";
	Dimension dimension = new Dimension(344, 432);
	
	
	public DatosCancion() {
		
		setTitle(titulo);
		setResizable(false);
		setSize(430, 467);
		setLocation(300, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		JLabel IntDatos = new JLabel("Introduce los datos de la cancion: ");
		IntDatos.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		IntDatos.setBounds(12, 50, 259, 19);
		getContentPane().add(IntDatos);
		
		JLabel intTitulo = new JLabel("Titulo");
		intTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		intTitulo.setBounds(12, 82, 56, 25);
		getContentPane().add(intTitulo);
		
		escTitulo = new JTextField();
		escTitulo.setBounds(12, 120, 97, 22);
		getContentPane().add(escTitulo);
		escTitulo.setColumns(10);
		
		JLabel intAutor = new JLabel("Autor");
		intAutor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		intAutor.setBounds(12, 155, 56, 25);
		getContentPane().add(intAutor);
		
		escAutor = new JTextField();
		escAutor.setBounds(12, 193, 97, 22);
		getContentPane().add(escAutor);
		escAutor.setColumns(10);
		
		JLabel intFS = new JLabel("Fecha de subida");
		intFS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		intFS.setBounds(12, 228, 116, 25);
		getContentPane().add(intFS);
		
		escFS = new JTextField();
		escFS.setBounds(12, 266, 116, 22);
		getContentPane().add(escFS);
		escFS.setColumns(10);
		
		JLabel selecArchivo = new JLabel("Selecciona el archivo:");
		selecArchivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		selecArchivo.setBounds(12, 308, 153, 16);
		getContentPane().add(selecArchivo);
		
		JButton botonExaminar = new JButton("Examinar");
		botonExaminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonExaminar.setBackground(Color.WHITE);
		botonExaminar.setBounds(12, 337, 97, 25);
		getContentPane().add(botonExaminar);
		
		JLabel labelURL = new JLabel("");
		labelURL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelURL.setBounds(132, 337, 259, 25);
		getContentPane().add(labelURL);
		
		//Guarda la cancion en la BD
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBackground(Color.WHITE);
		botonAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Inicio BD
				Connection connection = BD.initBD("CancionesBD");
				Statement statement = BD.usarCrearTablasBD(connection);
				
				//Guardamos la informacion de los JText
				String cancionTitulo = escTitulo.getText();
				String cancionAutor = escAutor.getText();
				String cancionFecha = escFS.getText();
				String cancionUrl = labelURL.getText();
				
				Cancion song = new Cancion(cancionTitulo, cancionAutor, cancionFecha, "", cancionUrl);
				
				//Comprobamos que no exista ninguna cancion con el mismo titulo
				Cancion cancionExistente = BD.cancionSelect(statement, song);
				if(cancionExistente != null) {
					JOptionPane.showMessageDialog(null, "Error, la cancion ya existe en la BD");
					BDArchivos.escogerArchivo();
				}else{
					BD.cancionInsert(statement, song);
					System.out.println("La cancion ha sido subida a la BD correctamente");
					dispose();
					BD.cerrarBD(connection, statement);
				}
				
			}
		});
		botonAceptar.setBounds(315, 394, 97, 25);
		getContentPane().add(botonAceptar);
		
		JLabel labelNombreCancion = new JLabel("");
		labelNombreCancion.setBounds(164, 309, 172, 16);
		getContentPane().add(labelNombreCancion);
			
		botonExaminar.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				String url = BDArchivos.escogerArchivo();
				//Fallo a la hora de sacar solo el nombre en la ventana
//				int i = 0;
//				String nombre;
//				for(i = url.length() ; i < url.length(); i--) {
//					if(url.charAt(i) == '/') {
//						nombre = url.substring(i, url.length());
//						
//						break;
//					} 
//				}
//				labelNombreCancion.setText(nombre);
				labelURL.setText(url);
			}
		});
		
		
		
		
		
	}
}
