
public class Usuario {
	
	String nombre;
	String contrasenya;
	
	public Usuario(String nombre, String contrasenya) {
		this.nombre = nombre;
		this.contrasenya = contrasenya;
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

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrasenya=" + contrasenya + "]";
	}
	
	public void subirCancion() {
		
	}
	
	public void bajarCancion() {
		
	}
	
	public void borrarCancion() {
		
	}
	
	

}
