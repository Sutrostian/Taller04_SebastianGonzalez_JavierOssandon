package Logic;

import java.util.ArrayList;

import Domain.Carta;

public interface ISistema {

	void agregarCarta(String[] partes);

	void mostrarCartas();
	
	ArrayList<Carta> getCartas();

}
