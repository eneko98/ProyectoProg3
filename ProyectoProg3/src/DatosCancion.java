import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class datosCancion extends JFrame {
	private JTextField escTitulo;
	private JTextField escAutor;
	private JTextField escFS;
	String titulo = "Datos";
	Dimension dimension = new Dimension(344, 432);
	public datosCancion() {
		setTitle(titulo);
		setResizable(false);
		setSize(dimension.width, dimension.height);
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
		
		JLabel selecArchivo = new JLabel("Selecciona el archivo");
		selecArchivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		selecArchivo.setBounds(12, 308, 153, 16);
		getContentPane().add(selecArchivo);
		
		JButton botonExaminar = new JButton("Examinar");
		botonExaminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonExaminar.setBackground(Color.WHITE);
		botonExaminar.setBounds(12, 337, 97, 25);
		getContentPane().add(botonExaminar);
		
		
		botonExaminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BDArchivos.escogerArchivo();
				
			}
		});
		
		
		
		
		
	}
}
