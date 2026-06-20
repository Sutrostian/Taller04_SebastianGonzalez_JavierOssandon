package Gui;
import javax.swing.*;
public class VentanaPrincipal extends JFrame{
	
	public VentanaPrincipal () {
		
		setTitle("LAS CARTAS DE MATEITO");
		setSize(900, 600);
		setLocationRelativeTo(null); // Hace que la ventana aparezca centrada en la pantalla
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Esto hace que al cerrar la ventana se termina el programa.
		
        JTabbedPane pestañas = new JTabbedPane(); // Creamos un objeto tipo JTabbedPane que contendrá las pestañas
		
        
        pestañas.add("Administración", new PanelAdministracion()); // Agregamos la pestaña "Administración"

        pestañas.add("Colección", new PanelColeccion()); // Agregamos la pestaña "Colección"
        
        add(pestañas); // Agregamos las pestañas a la ventana
        setVisible(true); // Hace visible la ventana

	}
}
