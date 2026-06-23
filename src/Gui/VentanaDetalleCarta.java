package Gui;

import javax.swing.*;

import Domain.Carta;

public class VentanaDetalleCarta extends JFrame {

	public VentanaDetalleCarta(Carta carta) {

		setTitle(carta.getNombre());

		setSize(400,300);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		add(new JLabel(carta.toString()));

		setVisible(true);

	}
}