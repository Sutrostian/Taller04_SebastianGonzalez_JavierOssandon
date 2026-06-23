package Gui;
import javax.swing.*;
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

	public PanelAdministracion() {
		
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

		//Atributo 1
		add(new JLabel("Atributo 1"));
		txtAtributo1 = new JTextField(20);
		add(txtAtributo1);

		//Atributo 2
		add(new JLabel("Atributo 2"));
		txtAtributo2 = new JTextField(20);
		add(txtAtributo2);

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

	}

	private void modificarCarta() {
		
	}

	private void eliminarCarta() {
		
	
	}

	private void agregarCarta() {
	   
	}

}