// Sebastian Andres Gonzalez Rossi - 21.186.016-2 - Ingenieria Civil Industrial - Sutrostian
// Javier Ignacio Ossandon Calderon - 21.979.689-2 - Ingenieria Civil Industrial - javierossand/itsvoiiid
package Logic;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;

import Factory.FactoryCartas;
import Gui.*;

public class App {
	
	public static ISistema sistema = SistemaI.getInstancia();
	private static Scanner s = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		cargarCartas();
		new VentanaPrincipal();
		
	}
	
	public static void cargarCartas() {
		try {
		File f = new File("Sobres.txt");
		Scanner s = new Scanner(f);
		while(s.hasNextLine()) {
			String linea = s.nextLine();
			sistema.cargarCartas(linea);
		}
		s.close();
		}catch (Exception e){
			System.out.println("Error al cargar cartas");
		}
	}

	private static void cargarMenu() {
		String opcion;
		do {
			System.out.println("Bienvenidos al menu, seleccione una opcion");
			System.out.println("1. Mostrar Todas Las Cartas");
			System.out.println("2. Agregar Carta");
			System.out.println("3. Modificar Carta");
			System.out.println("4. Eliminar Carta");
			System.out.println("5. Ordenar Cartas");
			System.out.println("6. Salir");
			System.out.print("> ");
			
			opcion = s.nextLine();
			
			switch(opcion) {
			
			case "1":
				sistema.mostrarCartas();
			break;
				
			case "2":
			
			break;
			
			case "3":
			
			break;
				
			case "4":
				System.out.println("Que carta desea eliminar");
				sistema.mostrarCartas();
				System.out.print("> ");
				String nombre = s.nextLine();
				sistema.eliminarCarta(nombre);	
			break;
			
			case "5":
			menuOrdenar();		
			break;
			
			case "6":
			System.out.println("Saliste con exito");
			break;
			default:
			System.out.println("Ingrese una opcion nuevamente");
			break;
			}
			
		}while(!opcion.equals("6"));
		
	}

	private static void menuOrdenar() {
		String opcion;
		do {
			System.out.println("MENU ORDENAR - Seleccione una opcion");
			System.out.println("1. Ordenar por Rareza");
			System.out.println("2. Ordenar por Poder");
			System.out.println("3. Ordenar por Nombre");
			System.out.println("4. Volver");
			System.out.print("> ");
			
			opcion = s.nextLine();
			
			switch(opcion) {
			
			case "1":
			sistema.getStrategyRareza();	
			
			break;
				
			case "2":
			sistema.getStrategyPoder();
			break;
			
			case "3":
			sistema.getStrategyNombre();
			break;
				
			case "4":
			System.out.println("");	
			break;
			
			default:
			System.out.println("Ingrese una opcion nuevamente");
			break;
			}
			
		}while(!opcion.equals("4"));
		
	}

}
