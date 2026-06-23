package Strategy;

import java.util.ArrayList;

import Domain.Carta;

public class StrategyOrdenarPorNombre implements IStrategy {

	@Override
	public ArrayList<Carta> ordenar(ArrayList<Carta> cartas) {
		for (int i = 0; i < cartas.size() - 1; i++) {
			for (int j = i + 1; j < cartas.size(); j++) {
				if (cartas.get(i).getNombre().compareToIgnoreCase(cartas.get(j).getNombre()) > 0) {
					Carta aux = cartas.get(i);
					cartas.set(i, cartas.get(j));
					cartas.set(j, aux);
				}
			}
		}
		return cartas;
	}

}
