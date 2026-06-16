package Logic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
	
	public static ISistema sistema = SistemaI.getInstance();
	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		cargarArch();
		mostrarCartas();

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
