package Factory;

import Domain.Carta;
import Domain.Energy;
import Domain.Item;
import Domain.Pokemon;
import Domain.Supporter;

public class FactoryCartas {

	public static Carta crearCartas(String linea) {
		String p[] = linea.split(";");
		String nombre = p[0];
		int rareza = Integer.parseInt(p[1]);
		String tipo = p[2];
		Carta nueva = null;
		
		if(tipo.equalsIgnoreCase("Pokemon")) {
			int dano = Integer.parseInt(p[3]);
			int cantEnergia = Integer.parseInt(p[4]);
			nueva = new Pokemon(nombre, rareza, tipo, dano, cantEnergia);
			return nueva;
			
		}else if(tipo.equalsIgnoreCase("Item")) {
			int bonificacion = Integer.parseInt(p[3]);
			nueva = new Item(nombre, rareza, tipo, bonificacion);
			return nueva;
	
		}else if(tipo.equalsIgnoreCase("Supporter")) {
			int efectosPorTurno = Integer.parseInt(p[3]);
			nueva = new Supporter(nombre, rareza, tipo, efectosPorTurno);
			return nueva;
			
		}else if(tipo.equalsIgnoreCase("Energy")) {
			String elemento = p[3];
			nueva = new Energy(nombre, rareza, tipo, elemento);
			return nueva;
		}else {
			throw new IllegalArgumentException("No se pudieron crear las cartas");
	}		
}
}
