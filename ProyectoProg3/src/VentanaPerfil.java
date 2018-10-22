import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPerfil extends JFrame {
	
		
	public VentanaPerfil() {
		
		setResizable(false);
		setBounds(100, 100, 544, 502);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
