package Domain;

import Visitor.IVisitor;

public class Pokemon extends Carta {
	
	private int dano;
	private int cantEnergia;
	
	public Pokemon(String nombre, int rareza, String tipo, int dano, int cantEnergia) {
		super(nombre, rareza, tipo);
		this.dano = dano;
		this.cantEnergia = cantEnergia;
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getCantEnergia() {
		return cantEnergia;
	}

	public void setCantEnergia(int cantEnergia) {
		this.cantEnergia = cantEnergia;
	}

	@Override
	public String toString() {
		return super.toString() + "[dano:" + dano + ", cantEnergia:" + cantEnergia + "]";
	}

	@Override
	public int accept(IVisitor visitor) {
		return visitor.visit(this);	
	}

	
	
	

}
