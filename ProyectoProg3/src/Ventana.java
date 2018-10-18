import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;




public class Ventana extends JFrame {

	String titulo = "Ventana Principal";
	Dimension dimension = new Dimension(900, 900);
	
	
	public Ventana(){
		setTitle(titulo);
		setResizable(false);
		setSize(dimension.width, dimension.height);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0,0));
		
		JPanel panelSuperior = new JPanel();
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		
		JComboBox<String> tipoUsuario = new JComboBox<>();
		tipoUsuario.addItem("Usuario");
		tipoUsuario.addItem("Administrador");
		
		panelSuperior.add(tipoUsuario);
		
		getContentPane().add(panelPrincipal);
	}
		
		
		
	
	
	public static void main(String[] args) {
		Ventana v = new Ventana();
		v.setVisible(true);
	}
}

