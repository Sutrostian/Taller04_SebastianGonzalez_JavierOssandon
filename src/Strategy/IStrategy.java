package Strategy;

import java.util.ArrayList;

import Domain.Carta;

public interface IStrategy {
	
	ArrayList<Carta> ordenar(ArrayList<Carta> cartas);

}
