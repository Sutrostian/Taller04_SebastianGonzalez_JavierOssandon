package Domain;

import Visitor.IVisitor;

public class Energy extends Carta {
	
	private String elemento;

	public Energy(String nombre, int rareza, String tipo, String elemento) {
		super(nombre, rareza, tipo);
		this.elemento = elemento;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	@Override
	public String toString() {
		return super.toString() +"[elemento:" + elemento + "]";
	}

	@Override
	public int accept(IVisitor visitor) {
		return visitor.visit(this);
		
	}

	
	
	

}
