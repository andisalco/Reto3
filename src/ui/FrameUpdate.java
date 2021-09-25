package ui;

import prog.DatabaseProduct;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class FrameUpdate extends JDialog {

    public FrameUpdate(int codeUpdate, DatabaseProduct dbase, JTable tProductos){

        // Caracteristicas para JFrame
        JDialog FrameUpdate = new JDialog();
        FrameUpdate.setModal(true);
        FrameUpdate.setSize(350,300);
        FrameUpdate.setMinimumSize(new Dimension(350,300));

        FrameUpdate.setLocationRelativeTo(null);
        FrameUpdate.setTitle("Actualizar Producto");
        FrameUpdate.setResizable(false);


        // Icono Aplicación

        // Clase Toolkit utizada para incluir imagen para el ícono de la aplicación.
        Toolkit interfaceApp = Toolkit.getDefaultToolkit();
        URL ruta_imagen = PanelMain.class.getResource("iconApp.png");
        Image iconApp = interfaceApp.getImage(ruta_imagen);
        FrameUpdate.setIconImage(iconApp);

        // Finaliza la aplicación cuando se cierra la ventana.
        FrameUpdate.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // Creamos el panel Principal y lo agregamos al frame.
        FrameUpdate.add(new PanelFields(codeUpdate,dbase,tProductos));

        // Visibilidad del frame
        FrameUpdate.setVisible(true);
    }
}
