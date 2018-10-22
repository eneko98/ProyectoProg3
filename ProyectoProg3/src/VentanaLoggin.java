import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLoggin extends JFrame{

	public VentanaLoggin() {
	
		setBounds(100, 100, 347, 179);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(29, 13, 94, 30);
		getContentPane().add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setBounds(29, 56, 94, 24);
		getContentPane().add(lblContrasea);
		
		JTextField textField = new JTextField();
		textField.setBounds(156, 18, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(156, 58, 116, 24);
		getContentPane().add(passwordField);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAceptar.setBounds(106, 93, 97, 25);
		btnAceptar.setFocusPainted(false);
		getContentPane().add(btnAceptar);
	}
	public static void main(String[] args) {
		VentanaLoggin vl = new VentanaLoggin();
		vl.setVisible(true);
	}
}

