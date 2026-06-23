package Gui;
import javax.swing.*;
public class VentanaPrincipal extends JFrame{
	
	public VentanaPrincipal () {
		
		setTitle("LAS CARTAS DE MATEITO");
		setSize(900, 600);
		setLocationRelativeTo(null); // Hace que la ventana aparezca centrada en la pantalla
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Esto hace que al cerrar la ventana se termina el programa.
		
        JTabbedPane pestanas = new JTabbedPane(); // Creamos un objeto tipo JTabbedPane que contendrá las pestañas
		
        pestanas.add("Administrador", new PanelAdministracion());
        pestanas.add("Coleccion", new PanelColeccion());
        
        
        add(pestanas); // Agregamos las pestañas al panel
        setVisible(true); // Hace visible el panel

	}
}
