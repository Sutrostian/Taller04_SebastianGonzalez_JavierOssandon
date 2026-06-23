package Gui;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Domain.*;
import Logic.*;
import Strategy.*;
import Visitor.*;

public class PanelColeccion extends JPanel {

	private JComboBox<String> comboOrden; //Haremos una combobox para ordenar
	private JTable tabla; // Tabla visual que verá el usuario
	private DefaultTableModel modelo; // Modelo que almacena los datos de la tabla
	private ISistema sistema; // Referencia al sistema

	public PanelColeccion() {

		sistema = SistemaI.getInstancia();
		setLayout(new BorderLayout());

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
		modelo.addColumn("Poder");

		// Creamos la JTable usando el modelo recién creado
		tabla = new JTable(modelo);

		tabla.getSelectionModel().addListSelectionListener(e -> { //hacemos un listener si es que apreta una fila

			if(!e.getValueIsAdjusting()) { //si no cambia de fila

				mostrarDetalleCarta(); //llamamos al metodo
			}
		});
		add(new JScrollPane(tabla), BorderLayout.CENTER);

		actualizarTabla();
	}

	// Se llama cuando se vuelve a esta pestaña, para reflejar cambios hechos en Administracion
	public void refrescar() {
		actualizarTabla();
	}

	private void actualizarTabla() {

		modelo.setRowCount(0);

		ArrayList<Carta> cartas = new ArrayList<>(sistema.obtenerCartas());

		String orden = (String) comboOrden.getSelectedItem();
		IStrategy strategy;

		if ("Rareza".equals(orden)) {
			strategy = new StrategyOrdenarPorRareza();
		} else if ("Poder".equals(orden)) {
			strategy = new StrategyOrdenarPorPoder();
		} else {
			strategy = new StrategyOrdenarPorNombre();
		}

		cartas = strategy.ordenar(cartas);

		IVisitor visitor = new VisitorCalcularPoder();

		for (Carta c : cartas) {
			int poder = c.accept(visitor);
			modelo.addRow(new Object[] { c.getNombre(), c.getRareza(), c.getTipo(), poder });
		}
	}

	private void mostrarDetalleCarta() {

		int fila = tabla.getSelectedRow();

		if(fila == -1) { //selected row retorna -1 cuando no hay fila
			return;
		}

		String nombreSeleccionado = (String) modelo.getValueAt(fila, 0);

		for (Carta c : sistema.obtenerCartas()) {
			if (c.getNombre().equalsIgnoreCase(nombreSeleccionado)) {
				new VentanaDetalleCarta(c);
				break;
			}
		}
	}
}
