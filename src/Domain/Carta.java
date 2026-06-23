package Domain;

import Visitor.IVisitor;

public abstract class Carta {

	protected String nombre;
	protected int rareza;
	protected String tipo;
	
	public Carta(String nombre, int rareza, String tipo) {
		super();
		this.nombre = nombre;
		this.rareza = rareza;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRareza() {
		return rareza;
	}

	public void setRareza(int rareza) {
		this.rareza = rareza;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public abstract int accept (IVisitor visitor);

	@Override
	public String toString() {
		return "Carta [nombre:" + nombre + ", rareza:" + rareza + ", tipo:" + tipo + "]";
	}
	
	
	
	
}
