package ui;

import prog.DatabaseProduct;
import prog.EventProduct;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;


public class PanelMain extends JPanel{

    DatabaseProduct dbase = new DatabaseProduct();
    JTable tProductos = new JTable();

    PanelTableProduct panelTable;

    public PanelMain() {
        ArrayList productList = new DatabaseProduct().getListDatabaseProduct();

        setLayout(new BorderLayout());
        JPanel panelTitle = new JPanel();
        //JLabel labelTitle = new JLabel();

        URL ruta_imagen = PanelMain.class.getResource("imageSup3.png");

       // ImageIcon imageSupApp = new ImageIcon("src/images/imageSup3.png");
        ImageIcon imageSupApp = new ImageIcon(ruta_imagen);
        JLabel labelTitle = new JLabel(imageSupApp, SwingConstants.CENTER);
        labelTitle.setIcon(imageSupApp);

        panelTitle.add(labelTitle);
        add(panelTitle, BorderLayout.NORTH);

        // Panel Agregar Campos
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));

        panelCenter.add(Box.createRigidArea(new Dimension(0, 20)));
        PanelFields productFields = new PanelFields();
        panelCenter.add(productFields);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 20)));

        // Creacion jtable

        panelTable = new PanelTableProduct(tProductos, productList);
        panelCenter.add(panelTable);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 15)));

        PanelButtons productButtons = new PanelButtons();
        panelCenter.add(productButtons);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 15)));


        add(panelCenter, BorderLayout.CENTER);

        // Créditos de la aplicación
        JPanel panelDeveloper = new JPanel();
        JLabel labelDeveloper = new JLabel("Desarrollado por:  Andrea Salazar");
        labelDeveloper.setForeground(new InterfaceTools().getColorTwo());

        panelDeveloper.setAlignmentX(CENTER_ALIGNMENT);
        panelDeveloper.setBackground(new InterfaceTools().getColorThree());
        panelDeveloper.add(labelDeveloper);

        add(panelDeveloper, BorderLayout.SOUTH);


        // Evento botón Agregar Producto
        productFields.getButtonAddProduct().addActionListener(new EventProduct(productFields,dbase,tProductos));
        productButtons.getbDelete().addActionListener(new EventProduct(productFields,dbase,tProductos));
        productButtons.getbUpdate().addActionListener(new EventProduct(productFields,dbase,tProductos));
        productButtons.getbReports().addActionListener(new EventProduct(productFields,dbase,tProductos));


    }

}