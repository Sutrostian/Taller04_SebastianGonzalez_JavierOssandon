package Gui;
import javax.swing.*;

import Domain.*;
import Logic.*;

public class PanelAdministracion extends JPanel {

	private JTextField txtNombre;// Caja donde el usuario escribirá el nombre de la carta
	private JTextField txtRareza;// Caja donde el usuario escribirá la rareza
	private JTextField txtAtributo1;// Caja para el primer atributo adicional
	private JTextField txtAtributo2;// Caja para el segundo atributo adicional
	private JComboBox<String> comboTipo;// Menú desplegable para elegir el tipo de carta
	private JButton btnAgregar; 	// Boton Agregar
	private JButton btnEliminar;	// Boton Eliminar 
	private JButton btnModificar;	// Boton Modificar

	private JLabel lblAtributo1;
	private JLabel lblAtributo2;
	private JLabel lblImagenPreview;

	private ISistema sistema;

	public PanelAdministracion() {

		sistema = SistemaI.getInstancia();

		//Nombre
		add(new JLabel("Nombre")); // Agregamos un texto que diga "Nombre"
		txtNombre = new JTextField(20); // Creamos una caja de texto con espacio 20
		add(txtNombre);// Agregamos la caja al panel

		//Rareza
		add(new JLabel("Rareza")); //es el texto
		txtRareza = new JTextField(20);
		add(txtRareza);

		//Tipo
		add(new JLabel("Tipo"));
		comboTipo = new JComboBox<>();// Creamos el menú desplegable

		// Agregamos las opciones
		comboTipo.addItem("Pokemon");
		comboTipo.addItem("Item");
		comboTipo.addItem("Supporter");
		comboTipo.addItem("Energy");
		add(comboTipo); //Agregamos el menu desplegable al panel

		comboTipo.addItemListener(e -> actualizarEtiquetasAtributos());

		//Atributo 1
		lblAtributo1 = new JLabel("Dano");
		add(lblAtributo1);
		txtAtributo1 = new JTextField(20);
		add(txtAtributo1);

		//Atributo 2
		lblAtributo2 = new JLabel("Cant. Energia");
		add(lblAtributo2);
		txtAtributo2 = new JTextField(20);
		add(txtAtributo2);

		//Vista previa de imagen (según ruta {nombreCarta})
		lblImagenPreview = new JLabel("Sin imagen");
		add(lblImagenPreview);
		txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				actualizarPreviewImagen();
			}
		});

		// Botones

		btnAgregar = new JButton("Agregar"); //Agregar
		add(btnAgregar);
		btnAgregar.addActionListener(e -> agregarCarta()); //si apreta agregar llama a este metodo agregar carta

		btnEliminar = new JButton("Eliminar"); //Eliminar
		add(btnEliminar);
		btnEliminar.addActionListener(e -> eliminarCarta());

		btnModificar = new JButton("Modificar"); //Modificar	
		add(btnModificar);
		btnModificar.addActionListener(e -> modificarCarta());

		actualizarEtiquetasAtributos();
	}

	// Cambia las etiquetas de Atributo1/Atributo2 segun el tipo elegido
	private void actualizarEtiquetasAtributos() {

		String tipo = (String) comboTipo.getSelectedItem();
		if (tipo == null) {
			return;
		}

		switch (tipo) {
		case "Pokemon":
			lblAtributo1.setText("Dano");
			lblAtributo2.setText("Cant. Energia");
			txtAtributo2.setEnabled(true);
			break;
		case "Item":
			lblAtributo1.setText("Bonificacion");
			lblAtributo2.setText("(No aplica)");
			txtAtributo2.setEnabled(false);
			break;
		case "Supporter":
			lblAtributo1.setText("Efectos por Turno");
			lblAtributo2.setText("(No aplica)");
			txtAtributo2.setEnabled(false);
			break;
		case "Energy":
			lblAtributo1.setText("Elemento");
			lblAtributo2.setText("(No aplica)");
			txtAtributo2.setEnabled(false);
			break;
		}
	}

	private void actualizarPreviewImagen() {

		String nombre = txtNombre.getText().trim();

		if (nombre.isEmpty()) {
			lblImagenPreview.setIcon(null);
			lblImagenPreview.setText("Sin imagen");
			return;
		}

		ImageIcon icono = Imagen.cargarImagen(nombre, 80, 80);

		if (icono != null) {
			lblImagenPreview.setIcon(icono);
			lblImagenPreview.setText("");
		} else {
			lblImagenPreview.setIcon(null);
			lblImagenPreview.setText("Sin imagen");
		}
	}

	private void modificarCarta() {

		try {
			String nombre = txtNombre.getText().trim();

			if (nombre.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Ingrese el nombre de la carta a modificar.");
				return;
			}

			String atributo1 = txtAtributo1.getText().trim();
			String atributo2 = txtAtributo2.getText().trim();

			boolean modificada = sistema.modificarCarta(nombre, atributo1, atributo2);

			if (modificada) {
				JOptionPane.showMessageDialog(this, "Carta modificada correctamente.");
				limpiarCampos();
			} else {
				JOptionPane.showMessageDialog(this, "No se encontro una carta con ese nombre.");
			}

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Los atributos numericos deben ser numeros validos.");
		}
	}

	private void eliminarCarta() {

		String nombre = txtNombre.getText().trim();

		if (nombre.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese el nombre de la carta a eliminar.");
			return;
		}

		sistema.eliminarCarta(nombre);
		JOptionPane.showMessageDialog(this, "Si la carta existia, fue eliminada (la imagen no se elimina).");
		limpiarCampos();
	}

	private void agregarCarta() {

		try {
			String nombre = txtNombre.getText().trim();

			if (nombre.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Debe ingresar un nombre para la carta.");
				return;
			}

			int rareza = Integer.parseInt(txtRareza.getText().trim());
			String tipo = (String) comboTipo.getSelectedItem();

			Carta nueva;

			switch (tipo) {
			case "Pokemon":
				int dano = Integer.parseInt(txtAtributo1.getText().trim());
				int cantEnergia = Integer.parseInt(txtAtributo2.getText().trim());
				nueva = new Pokemon(nombre, rareza, tipo, dano, cantEnergia);
				break;
			case "Item":
				int bonificacion = Integer.parseInt(txtAtributo1.getText().trim());
				nueva = new Item(nombre, rareza, tipo, bonificacion);
				break;
			case "Supporter":
				int efectosPorTurno = Integer.parseInt(txtAtributo1.getText().trim());
				nueva = new Supporter(nombre, rareza, tipo, efectosPorTurno);
				break;
			case "Energy":
				String elemento = txtAtributo1.getText().trim();
				nueva = new Energy(nombre, rareza, tipo, elemento);
				break;
			default:
				JOptionPane.showMessageDialog(this, "Tipo de carta no valido.");
				return;
			}

			sistema.agregarCarta(nueva);
			JOptionPane.showMessageDialog(this, "Carta agregada. Ruta de imagen asociada: imagenes/" + nombre + ".png");
			limpiarCampos();

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Los atributos numericos deben ser numeros validos.");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al agregar la carta: " + ex.getMessage());
		}
	}

	private void limpiarCampos() {
		txtNombre.setText("");
		txtRareza.setText("");
		txtAtributo1.setText("");
		txtAtributo2.setText("");
		lblImagenPreview.setIcon(null);
		lblImagenPreview.setText("Sin imagen");
	}

}