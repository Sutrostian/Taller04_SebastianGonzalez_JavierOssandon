package Gui;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Domain.*;
import Logic.*;

public class PanelColeccion extends JPanel {

	
	private JTable tabla; // Tabla visual que verá el usuario
	private DefaultTableModel modelo; // Modelo que almacena los datos de la tabla
	private ISistema sistema = App.sistema; // Referencia al Singleton del sistema

	public PanelColeccion() {

		modelo = new DefaultTableModel(); // Creamos un modelo vacío

		// Agregamos las columnas de la tabla
		modelo.addColumn("Nombre");
		modelo.addColumn("Rareza");
		modelo.addColumn("Tipo");

		// Creamos la JTable usando el modelo recién creado
		tabla = new JTable(modelo);

		// Cargamos las cartas del sistema dentro de la tabla
		cargarCartas();

		// Agregamos la tabla dentro de un JScrollPane
		// Esto permite usar barra de desplazamiento si hay muchas cartas
		add(new JScrollPane(tabla));
	}
	
	private void cargarCartas() {
		
		ArrayList<Carta> cartas = sistema.getCartas(); // Obtenemos el ArrayList de cartas desde el sistema

		for(Carta c : cartas) {
			modelo.addRow(new Object[] {c.getNombreCarta(),c.getRareza(),c.getTipo()});

		}
	}
}
