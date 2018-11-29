import java.awt.Image;

public class Cancion {
	
	private String titulo;
	private String autor;
	private String fechaSubida;
	private Image caratula;
	private Usuario creador;
	private String lirica;
	
	
	public Cancion(String titulo, String autor, String fechaSubida, Image caratula, Usuario creador) {
		this.titulo = titulo;
		this.autor = autor;
		this.fechaSubida = fechaSubida;
		this.caratula = caratula;
		this.creador = creador;
	}
	public Cancion() {
		this.titulo = "";
		this.autor = "";
		this.fechaSubida = "";
		this.caratula = caratula;
		this.creador = creador;
	}
	
	public Cancion(String titulo, String autor, String fechaSubida, Usuario creador, String lirica) {
		this.titulo = titulo;
		this.autor = autor;
		this.fechaSubida = fechaSubida;
		this.creador = creador;
		this.lirica = lirica;
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
	
	public Image getCaratula() {
		return caratula;
	}

	public void setCaratula(Image caratula) {
		this.caratula = caratula;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}
	
	public String getLirica() {
		return lirica;
	}
	
	public void setLirica(String lirica) {
		this.lirica = lirica;
	}

	
	
	@Override
	public String toString() {
		return "Cancion [titulo= " + titulo + ", autor= " + autor + ", fechaSubida= " + fechaSubida + ", caratula= "
				+ caratula + ", creador= " + creador + "]";
	}

	

}
