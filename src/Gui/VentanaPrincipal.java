package Gui;
import javax.swing.*;
public class VentanaPrincipal extends JFrame{

	private PanelColeccion panelColeccion;

	public VentanaPrincipal () {
		
		setTitle("LAS CARTAS DE MATEITO");
		setSize(900, 600);
		setLocationRelativeTo(null); // Hace que la ventana aparezca centrada en la pantalla
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Esto hace que al cerrar la ventana se termina el programa.
		
        JTabbedPane pestanas = new JTabbedPane(); // Creamos un objeto tipo JTabbedPane que contendrá las pestañas

        panelColeccion = new PanelColeccion();

        pestanas.add("Administrador", new PanelAdministracion());
        pestanas.add("Coleccion", panelColeccion);

        // Al volver a la pestaña Coleccion, refrescamos para ver cambios hechos en Administracion
        pestanas.addChangeListener(e -> {
            if (pestanas.getSelectedComponent() == panelColeccion) {
                panelColeccion.refrescar();
            }
        });

        add(pestanas); // Agregamos las pestañas al panel
        setVisible(true); // Hace visible el panel

	}
}