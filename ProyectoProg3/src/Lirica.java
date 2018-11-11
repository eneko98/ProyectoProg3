import java.awt.Image;

public class Lirica extends Cancion {


	String letra;
	

	public Lirica(String titulo, String autor, String fechaSubida, Image caratula, Usuario creador, String letra) {
		super(titulo, autor, fechaSubida, caratula, creador);
		this.letra = letra;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	@Override
	public String toString() {
		return "Lirica [letra=" + letra + "]";
	}
	

	
}
