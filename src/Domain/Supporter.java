package Domain;

public class Supporter extends Carta {
	
	private int efectosPorTurno;

	public Supporter(String nombreCarta, int rareza, String tipo, int efectosPorTurno) {
		super(nombreCarta, rareza, tipo);
		this.efectosPorTurno = efectosPorTurno;
	}

	public int getEfectosPorTurno() {
		return efectosPorTurno;
	}

	@Override
	public String toString() {
		return "Supporter [efectosPorTurno=" + efectosPorTurno + "]";
	}

	
	
	

}
