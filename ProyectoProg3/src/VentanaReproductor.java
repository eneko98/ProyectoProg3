import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.glass.utils.NativeLibLoader;
import com.sun.jna.*;



public class VentanaReproductor extends JFrame {
	
	String titulo = "Ventana Reproductor";
	Dimension dimension = new Dimension(900, 900);
	URL miUrl=null;
	AudioClip cancionElegida;
	Canvas c;
	
	
	public VentanaReproductor(String cancion) {		
		
		setTitle(titulo);
			setResizable(false);
			setBounds(100, 100, 652, 406);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			
			c = new Canvas();
			c.setBackground(Color.BLACK);
			
			JPanel panelVideo = new JPanel();
			panelVideo.setLayout(new BorderLayout());
			panelVideo.setBounds(12, 13, 283, 191);
			panelVideo.add(c);
		
			getContentPane().add(panelVideo);
					
			
			JTextPane textoLirica = new JTextPane();
			textoLirica.setEditable(false);
			textoLirica.setBounds(337, 75, 266, 244);
			getContentPane().add(textoLirica);
			
			JPanel panelBotonesLirica = new JPanel();
			panelBotonesLirica.setBackground(new Color(72, 61, 139));
			panelBotonesLirica.setBounds(307, 13, 315, 35);
			getContentPane().add(panelBotonesLirica);
			
			JButton botonAñadirLirica = new JButton("Añadir Lirica");
			botonAñadirLirica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			botonAñadirLirica.setFocusPainted(false);
			panelBotonesLirica.add(botonAñadirLirica);
			
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
			botonPause.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					cancionElegida.stop();
				}
			});
			panel.add(botonPause);
			
			JButton botonPlay = new JButton("");
			botonPlay.setBackground(Color.WHITE);
			botonPlay.setIcon(new ImageIcon(VentanaReproductor.class.getResource("/imagenes/Play.png")));
			botonPlay.setBounds(62, 0, 63, 56);
			botonPlay.setFocusPainted(false);
			botonPlay.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent a) {
					//cancionElegida = Applet.newAudioClip(this.getClass().getResource(cancion));
					//cancionElegida.play();
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
			
			EmbeddedMediaPlayerComponent Eemp = new EmbeddedMediaPlayerComponent();
			EmbeddedMediaPlayer emp = Eemp.getMediaPlayer();
			emp.setEnableMouseInputHandling(false);
			emp.setEnableKeyInputHandling(false);
			
			JFrame f = new JFrame();
			f.setJMenuBar(null);
			f.add(Eemp);
			f.setVisible(true);
			emp.prepareMedia(cancion);
			emp.play();
		}

	public static void main(String[] args) {
		boolean f = new uk.co.caprica.vlcj.discovery.NativeDiscovery().discover();
		System.out.println(f);
		String cancion = "src/cancion/EminemTheRinger.wav";
		VentanaReproductor vr = new VentanaReproductor(cancion);
		vr.setVisible(true);
		
	}
}
