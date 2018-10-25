import java.awt.Color;

import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPerfil extends JFrame {


	String titulo = "Ventana Perfil";
	Dimension dimension = new Dimension(900, 900);


	public VentanaPerfil() {
		

		setResizable(false);
		setBounds(100, 100, 544, 502);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle(titulo);
		setResizable(false);
		setSize(dimension.width, dimension.height);
		setLocation(300, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 13, 223, 218);
		getContentPane().add(panel);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(255, 13, 72, 26);
		getContentPane().add(lblNombre);

	}

	

	public static void main(String[] args) {
		VentanaPerfil vp = new VentanaPerfil();
		vp.setVisible(true);

	}
	
}
