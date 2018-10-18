import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.*;


public class VentanaPrincipal extends JFrame {

	String titulo = "Ventana Principal";
	Dimension dimension = new Dimension(900, 900);
	
	
	public VentanaPrincipal(){
		setTitle(titulo);
		setResizable(false);
		setSize(dimension.width, dimension.height);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		JButton boton1 = new JButton("Reproductor de musica");
		boton1.setBounds(150, 100, 120, 60);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setVisible(true);
		panelPrincipal.add(boton1);
		
		getContentPane().add(panelPrincipal);
	}
	
	
	
	public static void main(String[] args) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
	}
}

