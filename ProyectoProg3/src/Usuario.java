
public class Usuario {
	
	public String nombre;
	public String contrasenya;
	public String correo;
	
	
	public Usuario(String nombre, String contrasenya, String correo) {
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.correo = correo;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	public String getcorreo() {
		return correo;
	}

	public void setcorreo(String correo) {
		this.correo = correo;
	}
	
	

	@Override
	public String toString() {
		return "Usuario [Nombre: " + nombre + ", Contraseña: " + contrasenya + "Correo: " + correo + "Codigo Usuario: " + "]";
	}
	

}
