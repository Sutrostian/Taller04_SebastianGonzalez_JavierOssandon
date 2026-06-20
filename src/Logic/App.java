// Sebastian Andres Gonzalez Rossi - 21.186.016-2 - Ingenieria Civil Industrial - Sutrostian
// Javier Ignacio Ossandon Calderon - 21.979.689-2 - Ingenieria Civil Industrial - javierossand/itsvoiiid
package Logic;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import Gui.VentanaPrincipal;

public class App {
	
	public static ISistema sistema = SistemaI.getInstance();
	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		cargarArch();
		new VentanaPrincipal();

	}
	
	
	private static void mostrarCartas() {
		sistema.mostrarCartas();
		
	}


	private static void cargarArch() throws IOException {
		File file = new File("Sobres.txt");
		Scanner sFile = new Scanner(file);
		
		while (sFile.hasNextLine()) {
			String [] partes = sFile.nextLine().split(";");
			sistema.agregarCarta(partes);
		}
		sFile.close();
		
	}

}
