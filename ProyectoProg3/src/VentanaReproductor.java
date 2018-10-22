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

	public VentanaReproductor() {
		
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
			
			JPanel panelBotonesReproductor = new JPanel();
			panelBotonesReproductor.setBackground(new Color(255, 255, 255));
			panelBotonesReproductor.setBounds(12, 231, 293, 63);
			getContentPane().add(panelBotonesReproductor);
			panelBotonesReproductor.setLayout(null);
			
			JButton botonIzquierda = new JButton("");
			botonIzquierda.setForeground(new Color(255, 255, 255));
			botonIzquierda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			botonIzquierda.setBackground(Color.WHITE);
			botonIzquierda.setBounds(0, 0, 65, 61);
			botonIzquierda.setIcon(new ImageIcon(VentanaReproductor.class.getResource("/imagenes/Back.png")));
			botonIzquierda.setBorder(null);
			botonIzquierda.setFocusPainted(false);
			panelBotonesReproductor.add(botonIzquierda);
			
			JButton botonDerecha = new JButton("");
			botonDerecha.setForeground(new Color(255, 255, 255));
			botonDerecha.setIcon(new ImageIcon(VentanaReproductor.class.getResource("/imagenes/Next.png")));
			botonDerecha.setBackground(Color.WHITE);
			botonDerecha.setBounds(228, 0, 65, 61);
			botonDerecha.setBorder(null);
			botonDerecha.setFocusPainted(false);
			panelBotonesReproductor.add(botonDerecha);
			
			JButton botonPause = new JButton("");
			botonPause.setForeground(new Color(255, 255, 255));
			botonPause.setIcon(new ImageIcon(VentanaReproductor.class.getResource("/imagenes/Pause.png")));
			botonPause.setBackground(Color.WHITE);
			botonPause.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			botonPause.setBounds(155, 0, 65, 61);
			botonPause.setBorder(null);
			botonPause.setFocusPainted(false);
			panelBotonesReproductor.add(botonPause);
			
			JButton botonPlay = new JButton("");
			botonPlay.setForeground(new Color(255, 255, 255));
			botonPlay.setIcon(new ImageIcon(VentanaReproductor.class.getResource("/imagenes/Play.png")));
			botonPlay.setBackground(Color.WHITE);
			botonPlay.setBounds(77, 0, 66, 61);
			botonPlay.setBorder(null);
			botonPlay.setFocusPainted(false);
			panelBotonesReproductor.add(botonPlay);
			
			JButton botonCancelar = new JButton("Atras");
			botonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			botonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			botonCancelar.setBounds(12, 307, 102, 39);
			botonCancelar.setFocusPainted(false);
			getContentPane().add(botonCancelar);
		}
	
	public static void main(String[] args) {
		VentanaReproductor vr = new VentanaReproductor();
		vr.setVisible(true);
	}
			
}
