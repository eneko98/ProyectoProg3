import java.awt.Image;

public class Cancion {
	
	private String titulo;
	private String autor;
	private String fechaSubida;
	private Image caratula;
	private String lirica;
	private String url;
	
	
	public Cancion(String titulo, String autor, String fechaSubida, Image caratula, String url) {
		this.titulo = titulo;
		this.autor = autor;
		this.fechaSubida = fechaSubida;
		this.caratula = caratula;
		this.url = url;
	}
	
	public Cancion(String titulo) {
		this.titulo = titulo;
	}
	
	public Cancion() {
		this.titulo = "";
		this.autor = "";
		this.fechaSubida = "";
		this.caratula = caratula;
		this.url = "";
	}
	
	public Cancion(String titulo, String autor, String fechaSubida, String lirica, String url) {
		this.titulo = titulo;
		this.autor = autor;
		this.fechaSubida = fechaSubida;
		this.lirica = lirica;
		this.url = url;
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
	
	public String getLirica() {
		return lirica;
	}
	
	public void setLirica(String lirica) {
		this.lirica = lirica;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", autor=" + autor + ", fechaSubida=" + fechaSubida + ", caratula="
				+ caratula + ", lirica=" + lirica + ", url=" + url + "]";
	}

}
