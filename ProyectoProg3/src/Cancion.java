
public class Cancion {
	
	String titulo;
	String autor;
	String fechaSubida;
	Usuario creador;
	
	public Cancion(String titulo, String autor, String fechaSubida, Usuario creador) {
		this.titulo = titulo;
		this.autor = autor;
		this.fechaSubida = fechaSubida;
		this.creador = creador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFechaSubida() {
		return fechaSubida;
	}

	public void setFechaSubida(String fechaSubida) {
		this.fechaSubida = fechaSubida;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", autor=" + autor + ", fechaSubida=" + fechaSubida + ", creador="
				+ creador + "]";
	}
	
	public void reproducir() {
		
	}
	
	public void pausar() {
		
	}
	
	public void detener() {
		
	}
	
	
	
	
	

}
