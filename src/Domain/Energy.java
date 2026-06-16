package Domain;

public class Energy extends Carta {
	
	private String elemento;

	public Energy(String nombreCarta, int rareza, String tipo, String elemento) {
		super(nombreCarta, rareza, tipo);
		this.elemento = elemento;
	}

	public String getElemento() {
		return elemento;
	}

	@Override
	public String toString() {
		return "Energy [elemento=" + elemento + "]";
	}

	
	
	

}
