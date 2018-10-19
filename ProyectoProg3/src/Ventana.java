import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;




public class Ventana extends JFrame {

	String titulo = "Ventana Principal";
	Dimension dimension = new Dimension(900, 900);
	
	
	public Ventana(){
		setTitle(titulo);
		setResizable(true);
		setSize(dimension.width, dimension.height);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel PanelSuperior = new JPanel();
		panelPrincipal.add(PanelSuperior, BorderLayout.NORTH);
		PanelSuperior.setLayout(new BorderLayout(0, 0));
		
		JPanel PanelEntrar = new JPanel();
		PanelEntrar.setBorder(new LineBorder(new Color(0, 0, 0)));
		PanelSuperior.add(PanelEntrar);
		PanelEntrar.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 5));
		
		JButton botonEntrar = new JButton("Entrar");
		botonEntrar.setSize(40, 60);
		PanelEntrar.add(botonEntrar);
		
		JButton botonRegistrarse = new JButton("Registrarse");
		PanelEntrar.add(botonRegistrarse);
		
		JPanel panelCanciones = new JPanel();
		panelPrincipal.add(panelCanciones, BorderLayout.WEST);
		panelCanciones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel LabelCanciones = new JLabel("Canciones: ");
		panelCanciones.add(LabelCanciones);
	}
		
		
		
	
	
	public static void main(String[] args) {
		Ventana v = new Ventana();
		v.setVisible(true);
	}
}

