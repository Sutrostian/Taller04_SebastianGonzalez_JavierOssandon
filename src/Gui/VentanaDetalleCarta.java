package Gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

import Domain.Carta;
import Domain.Pokemon;
import Domain.Item;
import Domain.Supporter;
import Domain.Energy;
import Visitor.IVisitor;
import Visitor.VisitorCalcularPoder;

public class VentanaDetalleCarta extends JFrame {

	public VentanaDetalleCarta(Carta carta) {

		setTitle(carta.getNombre());

		setSize(420, 420);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setLayout(new BorderLayout());

		ImageIcon icono = Imagen.cargarImagen(carta.getNombre(), 200, 200);
		JLabel lblImagen = new JLabel();
		if (icono != null) {
			lblImagen.setIcon(icono);
		} else {
			lblImagen.setText("Sin imagen disponible");
		}
		add(lblImagen, BorderLayout.NORTH);

		IVisitor visitor = new VisitorCalcularPoder();
		int poder = carta.accept(visitor);

		JPanel panelDatos = new JPanel(new GridLayout(0, 1));
		panelDatos.add(new JLabel("Nombre: " + carta.getNombre()));
		panelDatos.add(new JLabel("Rareza: " + carta.getRareza()));
		panelDatos.add(new JLabel("Tipo: " + carta.getTipo()));
		panelDatos.add(new JLabel(obtenerAtributosAdicionales(carta)));
		panelDatos.add(new JLabel("Poder calculado: " + poder));

		add(panelDatos, BorderLayout.CENTER);

		setVisible(true);

	}

	private String obtenerAtributosAdicionales(Carta carta) {

		if (carta instanceof Pokemon) {
			Pokemon p = (Pokemon) carta;
			return "Dano: " + p.getDano() + " | Cant. Energia: " + p.getCantEnergia();
		} else if (carta instanceof Item) {
			Item i = (Item) carta;
			return "Bonificacion: " + i.getBonificacion();
		} else if (carta instanceof Supporter) {
			Supporter s = (Supporter) carta;
			return "Efectos por turno: " + s.getEfectosPorTurno();
		} else if (carta instanceof Energy) {
			Energy en = (Energy) carta;
			return "Elemento: " + en.getElemento();
		}
		return "";
	}
}