package Domain;

import Visitor.IVisitor;

public class Item extends Carta {
	
	private int bonificacion;

	public Item(String nombre, int rareza, String tipo, int bonificacion) {
		super(nombre, rareza, tipo);
		this.bonificacion = bonificacion;
	}

	public int getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

	@Override
	public String toString() {
		return super.toString() + "[bonificacion:" + bonificacion + "]";
	}

	@Override
	public int accept(IVisitor visitor) {
		return visitor.visit(this);
		
	}
	
	

}
