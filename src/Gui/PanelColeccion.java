package Gui;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Domain.*;
import Logic.*;

public class PanelColeccion extends JPanel {

	private JComboBox<String> comboOrden; //Haremos una combobox para ordenar
	private JTable tabla; // Tabla visual que verá el usuario
	private DefaultTableModel modelo; // Modelo que almacena los datos de la tabla
	private ISistema sistema; // Referencia al sistema

	public PanelColeccion() {

		modelo = new DefaultTableModel(); // Creamos un modelo vacío
		
		comboOrden = new JComboBox<>();
		comboOrden.addItem("Nombre");
		comboOrden.addItem("Rareza");
		comboOrden.addItem("Poder");
		add(comboOrden, BorderLayout.NORTH);
		comboOrden.addActionListener(e -> actualizarTabla());

		// Agregamos las columnas de la tabla
		modelo.addColumn("Nombre");
		modelo.addColumn("Rareza");
		modelo.addColumn("Tipo");

		// Creamos la JTable usando el modelo recién creado
		tabla = new JTable(modelo);
		
		tabla.getSelectionModel().addListSelectionListener(e -> { //hacemos un listener si es que apreta una fila

			if(!e.getValueIsAdjusting()) { //si no cambia de fila

				mostrarDetalleCarta(); //llamamos al metodo
			}
		});
		add(new JScrollPane(tabla));
	}
	
	
	private void actualizarTabla() {

		modelo.setRowCount(0);
	}
	
	private void mostrarDetalleCarta() {

		int fila = tabla.getSelectedRow();

		if(fila == -1) { //selected row retorna -1 cuando no hay fila
			return;
		}

		ArrayList<Carta> cartas = sistema.obtenerCartas();

		Carta cartaSeleccionada = cartas.get(fila);

		new VentanaDetalleCarta(cartaSeleccionada);
	}
}
