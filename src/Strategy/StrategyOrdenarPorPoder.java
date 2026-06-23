package Strategy;

import java.util.ArrayList;

import Domain.Carta;
import Visitor.VisitorCalcularPoder;

public class StrategyOrdenarPorPoder implements IStrategy {

	@Override
	public ArrayList<Carta> ordenar(ArrayList<Carta> cartas) {


		VisitorCalcularPoder visitor = new VisitorCalcularPoder();
		
		for(int i=0; i<cartas.size()-1; i++) {
			for(int j=i+1; j<cartas.size(); j++) {
				
				int poder1 = cartas.get(i).accept(visitor);
				int poder2 = cartas.get(j).accept(visitor);
				
				if(poder1 < poder2) {
					
					Carta aux = cartas.get(i);
					cartas.set(i,cartas.get(j));
					cartas.set(j, aux);
				}
			}
		}
		return cartas;
	}

}
