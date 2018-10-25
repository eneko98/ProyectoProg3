import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.*;

import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;

public class VentanaRegistro extends JFrame {
	private JTextField TFUsuario;
	private JTextField textField_1;
	private JPasswordField passwordField;
	String titulo = "Ventana Registro";
	
	public VentanaRegistro(){
		
		setTitle(titulo);
		setResizable(false);
		setLocation(300, 200);
		setSize(493, 558);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSuperior.setBackground(new Color(72, 61, 139));
		getContentPane().add(panelSuperior, BorderLayout.NORTH);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.setBackground(new Color(255, 255, 255));
		botonAtras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonAtras.setFocusPainted(false);
		panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		panelSuperior.add(botonAtras);
		
		JButton botonSiguiente = new JButton("Siguiente");
		botonSiguiente.setBackground(new Color(255, 255, 255));
		botonSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonSiguiente.setFocusPainted(false);
		panelSuperior.add(botonSiguiente);
		
		JPanel panelCentral = new JPanel();
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		
		JPanel panelRegistro = new JPanel();
		panelRegistro.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRegistro.setBounds(27, 40, 217, 408);
		panelCentral.add(panelRegistro);
		panelRegistro.setLayout(null);
		
		JLabel intDatos = new JLabel("Introduce aqui tus datos: ");
		intDatos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		intDatos.setBounds(12, 13, 193, 16);
		panelRegistro.add(intDatos);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(12, 42, 56, 16);
		panelRegistro.add(lblUsuario);
		
		TFUsuario = new JTextField();
		TFUsuario.setBounds(12, 63, 100, 22);
		panelRegistro.add(TFUsuario);
		TFUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña: ");
		lblContrasea.setBounds(12, 98, 84, 16);
		panelRegistro.add(lblContrasea);
		
		JLabel lblCorreoElectronico = new JLabel("Correo Electronico: ");
		lblCorreoElectronico.setBounds(12, 155, 131, 16);
		panelRegistro.add(lblCorreoElectronico);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 176, 131, 22);
		panelRegistro.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(12, 120, 100, 22);
		panelRegistro.add(passwordField);
		
		botonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			VentanaInicio v = new VentanaInicio();
			v.setVisible(true);
				
			}
		});
		
		botonSiguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				VentanaInicio v = new VentanaInicio();
				v.setVisible(true);
				VentanaPerfil vp = new VentanaPerfil();
				vp.setVisible(true);
				
			}
		});
		
	}
	
	public static void main(String[] args) {
		VentanaRegistro vr = new VentanaRegistro();
		vr.setVisible(true);
	}
}
