package ui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class FrameApp extends JFrame {

    public FrameApp(){
        init();
    }

    public void init(){

        // Caracteristicas para JFrame
        JFrame frameMain = new JFrame();
        frameMain.setSize(650,950);
        frameMain.setMinimumSize(new Dimension(650,950));
        frameMain.setLocationRelativeTo(null);
        frameMain.setTitle("Inventario App");

        // Icono Aplicación

        // Clase Toolkit utizada para incluir imagen para el ícono de la aplicación.
        Toolkit interfaceApp = Toolkit.getDefaultToolkit();

        URL ruta_imagen = FrameApp.class.getResource("iconApp.png");
        Image iconApp = interfaceApp.getImage(ruta_imagen);
        frameMain.setIconImage(iconApp);

        // Finaliza la aplicación cuando se cierra la ventana.
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creamos el panel Principal y lo agregamos al frame.
        frameMain.add(new PanelMain());

        // Visibilidad del frame
        frameMain.setVisible(true);
    }
}
