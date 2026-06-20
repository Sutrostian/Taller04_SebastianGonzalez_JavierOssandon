package Logic;

import java.util.ArrayList;

import Domain.Carta;
import Factory.FactoryCarta;

public class SistemaI implements ISistema {
	
private static ISistema instance; //atributo privado de si mismo
private static ArrayList<Carta> cartas = new ArrayList<Carta>();
	
	private SistemaI() { //constructor privado
		
	}
	
	public static ISistema getInstance() { //getInstance para crear una sola vez.
		
		if(instance == null) {
			instance = new SistemaI();
		}
		return instance;
		
	}

	@Override
	public void agregarCarta(String[] partes) {
		cartas.add(FactoryCarta.crearCarta(partes));//en mi arraylist de cartas llamo a el crear carta de factory
		
	}

	@Override
	public void mostrarCartas() {
		for (Carta c : cartas) {
			System.out.println(c);		
		}
		
	}
	
	@Override
	public ArrayList<Carta> getCartas() {
		return cartas;
	}

}
