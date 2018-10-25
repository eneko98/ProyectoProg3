import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.media.Manager;
import javax.media.Player;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class VentanaReproductor extends JFrame {
	
	String titulo = "Ventana Reproductor";
	Dimension dimension = new Dimension(900, 900);
	
	URL urlArchivoMusica;
	Player reproductor;
	
	
	public VentanaReproductor() {
		try {
			urlArchivoMusica = new URL("file:/C:/Users/Diazl//Desktop/EminemTheRinger.mp3");
			reproductor = Manager.createRealizedPlayer(urlArchivoMusica);
			Component controles = reproductor.getControlPanelComponent();
			
			if(controles != null) {
				getContentPane().add(controles);
				controles.setLocation(12,191);
				controles.setSize(283,25);
			}
		} catch (Exception e) {
			System.out.println("Se ha encontrado un error al trata de reproducir el archivo");
		}
	
			setTitle(titulo);
			setResizable(false);
			setBounds(100, 100, 652, 406);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			
			JPanel panelImagenCaratula = new JPanel();
			panelImagenCaratula.setBackground(Color.WHITE);
			panelImagenCaratula.setBounds(12, 13, 283, 191);
			getContentPane().add(panelImagenCaratula);
			
			JTextPane textoLirica = new JTextPane();
			textoLirica.setEditable(false);
			textoLirica.setBounds(337, 75, 266, 244);
			getContentPane().add(textoLirica);
			
			JPanel panelBotonesLirica = new JPanel();
			panelBotonesLirica.setBackground(new Color(72, 61, 139));
			panelBotonesLirica.setBounds(307, 13, 315, 35);
			getContentPane().add(panelBotonesLirica);
			
			JButton botonAñadirLirica = new JButton("Añadir Lirica");
			botonAñadirLirica.setFocusPainted(false);
			panelBotonesLirica.add(botonAñadirLirica);
			
			JButton botonEditarLirica = new JButton("Editar Lirica");
			botonEditarLirica.setFocusPainted(false);
			panelBotonesLirica.add(botonEditarLirica);
			
			JButton botonCancelar = new JButton("Atras");
			botonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			botonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			botonCancelar.setBounds(12, 278, 102, 39);
			botonCancelar.setFocusPainted(false);
			getContentPane().add(botonCancelar);
		}
	
	public static void main(String[] args) {
		VentanaReproductor vr = new VentanaReproductor();
		vr.setVisible(true);
	}
			
}
