package Factory;

import Domain.Carta;
import Domain.Energy;
import Domain.Item;
import Domain.Pokemon;
import Domain.Supporter;

public class FactoryCarta {
	
public static Carta crearCarta(String[] partes) {
		
		String tipo = partes[2];
		Carta nuevo = null;
		
		if (tipo.equalsIgnoreCase("Pokemon")) {
			
			 nuevo = new Pokemon(partes[0], Integer.parseInt(partes[1]), partes[2], Integer.parseInt(partes[3]), Integer.parseInt(partes[4]));
			 return nuevo;
		}else if (tipo.contentEquals("Item")) {
			
			 nuevo = new Item(partes[0], Integer.parseInt(partes[1]), partes[2], Integer.parseInt(partes[3]));
			 return nuevo;
			 
		}else if (tipo.contentEquals("Supporter")) {
			
			 nuevo = new Supporter(partes[0], Integer.parseInt(partes[1]), partes[2], Integer.parseInt(partes[3]));
			 return nuevo;
			 
		}else if (tipo.contentEquals("Energy")) {
			
			 nuevo = new Energy(partes[0], Integer.parseInt(partes[1]), partes[2], partes[3]);
			 return nuevo;	 
			 
		}else {
			throw new IllegalArgumentException("No se pudo crear el objeto");
		}
		
	}

}
