package Logic;

import java.util.ArrayList;

import Domain.Carta;

public interface ISistema {

	void mostrarCartas();
	void getStrategyRareza();
	void getStrategyPoder();
	void getStrategyNombre();
	void eliminarCarta(String nombre);
	ArrayList<Carta> obtenerCartas();
	void cargarCartas(String linea);

}
