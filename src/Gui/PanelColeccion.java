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
	private ISistema sistema = App.sistema; // Referencia al Singleton del sistema

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

		// Cargamos las cartas del sistema dentro de la tabla
		cargarCartas();

		// Agregamos la tabla dentro de un JScrollPane
		// Esto permite usar barra de desplazamiento si hay muchas cartas
		add(new JScrollPane(tabla));
	}
	
	private void cargarCartas() {

		ArrayList<Carta> cartas = sistema.getCartas();// Obtenemos la lista de cartas del sistema

		String opcion = comboOrden.getSelectedItem().toString();// Obtenemos la opción seleccionada en el ComboBox

		if(opcion.equals("Nombre")) { // Ordenar por nombre (A-Z)

			cartas.sort(
				(c1, c2) ->
				c1.getNombreCarta().compareToIgnoreCase(c2.getNombreCarta())
			);

		}

		// Ordenar por rareza (Mayor a menor)
		else if(opcion.equals("Rareza")) {cartas.sort((c1, c2) ->Integer.compare(c2.getRareza(), c1.getRareza()));

		}

		else if(opcion.equals("Poder")) {// Aquí haremos el Visitor más adelante

		}

		for(Carta c : cartas) {

			modelo.addRow(new Object[] {c.getNombreCarta(),c.getRareza(),c.getTipo()});
		}
	}
	
	private void actualizarTabla() {

		modelo.setRowCount(0);

		cargarCartas();
	}
	
	private void mostrarDetalleCarta() {

		int fila = tabla.getSelectedRow();

		if(fila == -1) { //selected row retorna -1 cuando no hay fila
			return;
		}

		ArrayList<Carta> cartas = sistema.getCartas();

		Carta cartaSeleccionada = cartas.get(fila);

		new VentanaDetalleCarta(cartaSeleccionada);
	}
}
