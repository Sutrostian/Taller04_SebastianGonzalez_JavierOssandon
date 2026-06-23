package Gui;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;


public class Imagen {

	private static final String CARPETA_IMAGENES = "imagenes/";
	private static final String IMAGEN_DEFAULT = CARPETA_IMAGENES + "default.png";

	public static ImageIcon cargarImagen(String nombreCarta, int ancho, int alto) {

		File archivo = new File(CARPETA_IMAGENES + nombreCarta + ".png");

		if (!archivo.exists()) {
			archivo = new File(IMAGEN_DEFAULT);
		}

		if (!archivo.exists()) {
			return null;
		}

		ImageIcon icono = new ImageIcon(archivo.getPath());
		Image escalada = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		return new ImageIcon(escalada);
	}
}