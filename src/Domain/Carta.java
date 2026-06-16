package Domain;

public abstract class Carta {
	
	private String nombreCarta;
	private int rareza;
	private String tipo;
	
	public Carta(String nombreCarta, int rareza, String tipo) {
		super();
		this.nombreCarta = nombreCarta;
		this.rareza = rareza;
		this.tipo = tipo;
	}

	public String getNombreCarta() {
		return nombreCarta;
	}

	public int getRareza() {
		return rareza;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Carta [nombreCarta=" + nombreCarta + ", rareza=" + rareza + ", tipo=" + tipo + "]";
	}
	
	
	
	

}
