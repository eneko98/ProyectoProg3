import java.awt.Color;

import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class VentanaPerfil extends JFrame {


	String titulo = "Ventana Perfil";
	Dimension dimension = new Dimension(900, 900);


	public VentanaPerfil() {
		

		setResizable(false);
		setBounds(100, 100, 544, 502);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle(titulo);
		setResizable(false);
		setSize(489, 490);
		setLocation(300, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

		getContentPane().setLayout(null);
		
		JPanel panelImagen = new JPanel();
		panelImagen.setBackground(Color.WHITE);
		panelImagen.setBounds(12, 13, 223, 218);
		getContentPane().add(panelImagen);
		panelImagen.setLayout(null);
		
		JButton botonImagen = new JButton("Añadir Imagen");
		botonImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonImagen.setBackground(Color.WHITE);
		botonImagen.setForeground(new Color(0, 0, 0));
		botonImagen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonImagen.setBounds(12, 58, 199, 95);
		botonImagen.setBorder(null);
		botonImagen.setFocusPainted(false);
		panelImagen.add(botonImagen);
		
		JPanel panelNombre = new JPanel();
		panelNombre.setBackground(new Color(72, 61, 139));
		panelNombre.setForeground(new Color(0, 0, 0));
		panelNombre.setBounds(247, 13, 217, 29);
		getContentPane().add(panelNombre);
		
		JLabel jlNombre = new JLabel("Nombre :");
		jlNombre.setForeground(new Color(255, 255, 255));
		panelNombre.add(jlNombre);
		jlNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel jlNombreUsuario = new JLabel("Nombre Usuario");
		jlNombreUsuario.setForeground(new Color(255, 255, 255));
		jlNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelNombre.add(jlNombreUsuario);
		
		JPanel panelEmail = new JPanel();
		panelEmail.setForeground(new Color(255, 255, 255));
		panelEmail.setBackground(new Color(72, 61, 139));
		panelEmail.setBounds(247, 55, 217, 29);
		getContentPane().add(panelEmail);
		
		JLabel jlEmail = new JLabel("Email :");
		jlEmail.setForeground(new Color(255, 255, 255));
		jlEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelEmail.add(jlEmail);
		
		JLabel jlEmailUsuario = new JLabel("Email Usuario");
		jlEmailUsuario.setForeground(new Color(255, 255, 255));
		jlEmailUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelEmail.add(jlEmailUsuario);
		
		JButton btnEditarPerfil = new JButton("Editar Perfil");
		btnEditarPerfil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEditarPerfil.setForeground(new Color(255, 255, 255));
		btnEditarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarPerfil.setFocusPainted(false);
		btnEditarPerfil.setBackground(new Color(72, 61, 139));
		btnEditarPerfil.setBounds(64, 244, 128, 25);
		getContentPane().add(btnEditarPerfil);
		
		botonImagen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
			}
			
			
		});

	}

	public void buscarCaratula() {
		File caratula = null;
		JFileChooser f = new JFileChooser();
		if(caratula != null) 
			f.setCurrentDirectory(caratula);
		 f.setFileSelectionMode(JFileChooser.FILES_ONLY);
		 int cod = f.showOpenDialog(this);
		 if(cod == JFileChooser.APPROVE_OPTION) {
			 File dir = f.getSelectedFile();
			 
		 }
	}
	
	

	public static void main(String[] args) {
		VentanaPerfil vp = new VentanaPerfil();
		vp.setVisible(true);

	}
}
