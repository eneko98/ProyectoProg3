
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

import com.mysql.cj.protocol.Resultset;

import java.awt.Font;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Label;



public class VentanaInicio extends JFrame {

	String titulo = "Ventana Principal";
	Dimension dimension = new Dimension(900, 900);
	
	DefaultListModel<String> modeloLista1;
	
	//Inicio de la BD de Canciones para mostrarlas en la ventana
	Connection connection = BD.initBD("CancionesBD");
	Statement statement = BD.usarCrearTablasBD(connection);
	
	ResultSet resultSet = null;
	Cancion cancion;
	Cancion song;
	
	

	
	public VentanaInicio(){
			
		
		setTitle(titulo);
		setResizable(false);
		setSize(dimension.width, dimension.height);
		setLocation(300, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JPanel PanelSuperior = new JPanel();
		PanelSuperior.setBounds(0, 0, 894, 39);
		panelPrincipal.add(PanelSuperior);
		PanelSuperior.setLayout(new BorderLayout(0, 0));
		
		JPanel PanelEntrar = new JPanel();
		PanelEntrar.setBackground(new Color(72, 61, 139));
		PanelEntrar.setForeground(Color.BLACK);
		PanelEntrar.setBorder(new LineBorder(new Color(0, 0, 0)));
		PanelSuperior.add(PanelEntrar);
		PanelEntrar.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 5));
		
		JButton botonEntrar = new JButton("Entrar");
		botonEntrar.setBackground(new Color(255, 255, 255));
		botonEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonEntrar.setSize(40, 60);
		botonEntrar.setFocusPainted(false);
		PanelEntrar.add(botonEntrar);
		
		JButton botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.setBackground(new Color(255, 255, 255));
		botonRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonRegistrarse.setFocusPainted(false);
		PanelEntrar.add(botonRegistrarse);
		
		JPanel panelCanciones = new JPanel();
		panelCanciones.setBorder(null);
		panelCanciones.setBounds(47, 89, 455, 491);
		panelPrincipal.add(panelCanciones);
		panelCanciones.setLayout(null);
		
		JPanel cancionesAlfabetico = new JPanel();
		JPanel cancionesRecientes = new JPanel();
		JPanel cancionesFavoritas = new JPanel();
		
		JTabbedPane pestanyasCanciones = new JTabbedPane(JTabbedPane.TOP);
		pestanyasCanciones.setBounds(0, 0, 455, 491);
		pestanyasCanciones.add("Canciones A-Z", cancionesAlfabetico);
		//Cancion de ejemplo.
		//************************************ PROVISIONAL ****************************************
		//Necesitamos un bucle para que meta en la lista todas las canciones que hay en la BD. Esta cancion es solo para probar
		//Creamos un while() con resulSet de para que saque todos las lineas de la BD.
		
		modeloLista1 = new DefaultListModel<String>();
		try {
			resultSet = statement.executeQuery("select * from cancion");
			while(resultSet.next()) {
				cancion = new Cancion(resultSet.getString(1));
				song = BD.cancionSelect(statement, cancion);
				modeloLista1.addElement(song.getTitulo());
				repaint();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		cancionesAlfabetico.setLayout(new BorderLayout(0, 0));
		
		JList<String> listaCancionesAlfabetico = new JList<String>();
		listaCancionesAlfabetico.setBackground(Color.WHITE);
		listaCancionesAlfabetico.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listaCancionesAlfabetico.setModel(modeloLista1);
		cancionesAlfabetico.add(listaCancionesAlfabetico);
		
		
		
		
		pestanyasCanciones.add("Canciones favoritas", cancionesFavoritas);
		cancionesFavoritas.setLayout(new BorderLayout(0, 0));
		
		JList<String> listaCancionesFavoritas = new JList<String>();
		listaCancionesFavoritas.setBackground(Color.WHITE);
		cancionesFavoritas.add(listaCancionesFavoritas);
		pestanyasCanciones.add("Canciones Recientes", cancionesRecientes);
		cancionesRecientes.setLayout(new BorderLayout(0, 0));
		
		JList<String> listaCancionesRecientes = new JList<String>();
		listaCancionesRecientes.setBackground(Color.WHITE);
		cancionesRecientes.add(listaCancionesRecientes);
		panelCanciones.add(pestanyasCanciones);
		
		JPanel panelBuscador = new JPanel();
		panelBuscador.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBuscador.setBounds(586, 110, 236, 39);
		panelPrincipal.add(panelBuscador);
		
		JLabel JlBuscador = new JLabel("Buscar: ");
		JlBuscador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBuscador.add(JlBuscador);
		
		JTextField TfBuscador = new JTextField();
		panelBuscador.add(TfBuscador);
		TfBuscador.setColumns(10);
		
		JButton botonSubir = new JButton("Subir Cancion");
		botonSubir.setBackground(Color.WHITE);
		botonSubir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonSubir.setBounds(748, 52, 134, 27);
		panelPrincipal.add(botonSubir);
		
		JButton botonReproductor = new JButton("Reproductor");
		botonReproductor.setBackground(Color.WHITE);
		botonReproductor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonReproductor.setBounds(211, 614, 134, 25);
		panelPrincipal.add(botonReproductor);
		
		botonReproductor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean f = new uk.co.caprica.vlcj.discovery.NativeDiscovery().discover();
				System.out.println(f);
				//Elegimos la cancion seleccionada en la lista
				int elegido = listaCancionesAlfabetico.getSelectedIndex();
				String nombreCancion = listaCancionesAlfabetico.getModel().getElementAt(elegido);
				Cancion cancion = new Cancion(nombreCancion);
				Cancion song = BD.cancionSelect(statement, cancion);
				//Y abrimos el reproductor.
				VentanaReproductor vR = new VentanaReproductor(song.getUrl());
				vR.setVisible(true);
				
			}
		});
		
		//Se abre DatosCancion
		botonSubir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DatosCancion dC = new DatosCancion();
				dC.setVisible(true);
				
			}
		});
		
		//Se abre VentanaRegistro
		botonRegistrarse.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				VentanaRegistro vr = new VentanaRegistro();
				vr.setVisible(true);
				
			}
		});
		
		//Se abre VentanaLoggin
		botonEntrar.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaLoggin vl = new VentanaLoggin();
				vl.setVisible(true);
			}
		});
		
	}
		
		
	public static void main(String[] args) {
		VentanaInicio v = new VentanaInicio();
		v.setVisible(true);		
	}
	
}

