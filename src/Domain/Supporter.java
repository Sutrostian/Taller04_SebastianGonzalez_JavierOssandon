package Domain;

import Visitor.IVisitor;

public class Supporter extends Carta {
	
	private int efectosPorTurno;

	public Supporter(String nombre, int rareza, String tipo, int efectosPorTurno) {
		super(nombre, rareza, tipo);
		this.efectosPorTurno = efectosPorTurno;
	}

	public int getEfectosPorTurno() {
		return efectosPorTurno;
	}

	public void setEfectosPorTurno(int efectosPorTurno) {
		this.efectosPorTurno = efectosPorTurno;
	}

	@Override
	public String toString() {
		return super.toString() + "[efectosPorTurno:" + efectosPorTurno + "]";
	}

	@Override
	public int accept(IVisitor visitor) {
		return visitor.visit(this);
		
	}
	
	

}
