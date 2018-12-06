import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;


import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class VentanaLoggin extends JFrame{


	public VentanaLoggin() {
					
		setBounds(100, 100, 347, 179);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);

		
		String titulo = "Ventana Login";
		setTitle(titulo);
		setResizable(false);
		setSize(325, 181);
		setLocation(300, 100);
		
		getContentPane().setLayout(null);

		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(29, 13, 94, 30);
		getContentPane().add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setBounds(29, 56, 94, 24);
		getContentPane().add(lblContrasea);
		
		JTextField textNombreUsuario = new JTextField();
		textNombreUsuario.setBounds(156, 18, 116, 22);
		getContentPane().add(textNombreUsuario);
		textNombreUsuario.setColumns(10);
		
		JPasswordField passwordUsuario = new JPasswordField();
		passwordUsuario.setBounds(156, 58, 116, 24);
		getContentPane().add(passwordUsuario);
		

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection connection = BD.initBD("UsuariosBD");
				Statement statement = BD.usarCrearTablasBD(connection);
				
				String nombreUsuario = textNombreUsuario.getText();
				String contraseñaUsuario = new String(passwordUsuario.getPassword());
				
				Usuario usuarioLogin = new Usuario(nombreUsuario, contraseñaUsuario);
				
				
				Usuario usuarioExistente = BD.usuarioSelect(statement, usuarioLogin);
				VentanaPerfil vp = new VentanaPerfil(usuarioExistente);
				
				if(usuarioExistente == null) {
					System.err.println("No existe este usuario.");
				}else{
					vp.setVisible(true);
					dispose();
				}
				BD.cerrarBD(connection, statement);
				
				
				//Usado para ver pantalla perfil sin darle datos
//				setVisible(false);
//				VentanaPerfil vp = new VentanaPerfil();
//				vp.setVisible(true);
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

