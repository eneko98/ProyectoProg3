import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;



public class VentanaReproductor extends JFrame {
	
	String titulo = "Ventana Reproductor";
	Dimension dimension = new Dimension(900, 900);
	
	
	public VentanaReproductor(String cancion) {		
		
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
			
			JButton botonA�adirLirica = new JButton("A�adir Lirica");
			botonA�adirLirica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			botonA�adirLirica.setFocusPainted(false);
			panelBotonesLirica.add(botonA�adirLirica);
			
			JButton botonEditarLirica = new JButton("Editar Lirica");
			botonEditarLirica.setFocusPainted(false);
			panelBotonesLirica.add(botonEditarLirica);
			
			JButton botonCancelar = new JButton("Atras");
			botonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaInicio vi = new VentanaInicio();
					vi.setVisible(true);
				}
			});
			botonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			botonCancelar.setBounds(12, 297, 102, 39);
			botonCancelar.setFocusPainted(false);
			getContentPane().add(botonCancelar);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(22, 228, 249, 56);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JButton botonSiguiente = new JButton("");
			botonSiguiente.setBackground(Color.WHITE);
			botonSiguiente.setIcon(new ImageIcon(VentanaReproductor.class.getResource("/imagenes/Next.png")));
			botonSiguiente.setBounds(186, 0, 63, 56);
			botonSiguiente.setFocusPainted(false);
			botonSiguiente.addActionListener( new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					
				}
			});
			panel.add(botonSiguiente);
			
			JButton botonPause = new JButton("");
			botonPause.setBackground(Color.WHITE);
			botonPause.setIcon(new ImageIcon(VentanaReproductor.class.getResource("/imagenes/Pause.png")));
			botonPause.setBounds(0, 0, 63, 56);
			botonPause.setFocusPainted(false);
			panel.add(botonPause);
			
			JButton botonPlay = new JButton("");
			botonPlay.setBackground(Color.WHITE);
			botonPlay.setIcon(new ImageIcon(VentanaReproductor.class.getResource("/imagenes/Play.png")));
			botonPlay.setBounds(62, 0, 63, 56);
			botonPlay.setFocusPainted(false);
			botonPlay.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
				}
			});
			panel.add(botonPlay);
			
			JButton botonAnterior = new JButton("");
			botonAnterior.setBackground(Color.WHITE);
			botonAnterior.setIcon(new ImageIcon(VentanaReproductor.class.getResource("/imagenes/Back.png")));
			botonAnterior.setBounds(124, 0, 63, 56);
			botonAnterior.setFocusPainted(false);
			panel.add(botonAnterior);
			
			JPanel barraReproductor = new JPanel();
			barraReproductor.setBounds(12, 208, 283, 14);
			getContentPane().add(barraReproductor);
		}

	public static void main(String[] args) {
		String cancion = "C:/Users/Diazl/Desktop/Dani/Universidad de Deusto/3�-Simestre 1/Programacion/Proyecto Prog3/EminemTheRinger.mp3";
		VentanaReproductor vr = new VentanaReproductor(cancion);
		vr.setVisible(true);
		
	}
}
