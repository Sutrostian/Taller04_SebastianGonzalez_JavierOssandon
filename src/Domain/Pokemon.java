package Domain;

public class Pokemon extends Carta {
	
	private int dano;
	private int cantEnergia;
	
	public Pokemon(String nombreCarta, int rareza, String tipo, int dano, int cantEnergia) {
		super(nombreCarta, rareza, tipo);
		this.dano = dano;
		this.cantEnergia = cantEnergia;
	}

	public int getDano() {
		return dano;
	}

	public int getCantEnergia() {
		return cantEnergia;
	}

	@Override
	public String toString() {
		return "Pokemon [dano=" + dano + ", cantEnergia=" + cantEnergia + "]";
	}
	
	

	

	
	
	
	
	

}
