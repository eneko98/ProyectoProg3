import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Label;




public class VentanaInicio extends JFrame {

	String titulo = "Ventana Principal";
	Dimension dimension = new Dimension(900, 900);

	
	
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
		pestanyasCanciones.add("Canciones favoritas", cancionesFavoritas);
		pestanyasCanciones.add("Canciones Recientes", cancionesRecientes);
		panelCanciones.add(pestanyasCanciones);
		
		JPanel panelBuscador = new JPanel();
		panelBuscador.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBuscador.setBounds(586, 89, 236, 39);
		panelPrincipal.add(panelBuscador);
		
		JLabel JlBuscador = new JLabel("Buscar: ");
		JlBuscador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBuscador.add(JlBuscador);
		
		JTextField TfBuscador = new JTextField();
		panelBuscador.add(TfBuscador);
		TfBuscador.setColumns(10);
		
		botonRegistrarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				VentanaRegistro vr = new VentanaRegistro();
				vr.setVisible(true);
				
			}
		});
		

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

