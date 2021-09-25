package ui;

import prog.DatabaseProduct;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;


public class PanelTableProduct extends JPanel {

   // DatabaseProduct dbase = new DatabaseProduct();
   // JTable tProductos = new JTable();

   // ModelTableProduct tmodel;

    public PanelTableProduct(JTable tProductos, ArrayList productList) {

        // ToolsInterface
        InterfaceTools tools = new InterfaceTools();

        ModelTableProduct tmodel = new ModelTableProduct(productList);
        tProductos.setModel(tmodel);

     ///   PanelTableProduct model = new PanelTableProduct();


        // BaseDatosProducto baseDatos = new BaseDatosProducto();

        // Modificar encabezado
        tProductos.getTableHeader().setReorderingAllowed(false);

        tProductos.getTableHeader().setBackground(tools.getColorThree());
        tProductos.getTableHeader().setForeground(tools.getColorFour());


        tProductos.getTableHeader().setFont(new Font("Arial",Font.PLAIN,14));
     //   tProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tProductos.setSelectionBackground(tools.getColorOne());


       // tProductos.setEnabled(false);
        tProductos.setRowHeight(20);


        // Alinear a la Izquierda columna precios e inventario

        DefaultTableCellRenderer alignRight = new DefaultTableCellRenderer();
        alignRight.setHorizontalAlignment(SwingConstants.RIGHT);
        tProductos.getColumnModel().getColumn(1).setCellRenderer(alignRight);
        tProductos.getColumnModel().getColumn(2).setCellRenderer(alignRight);

        // Edición de celdas

        JScrollPane scrollPane = new JScrollPane(tProductos);

        scrollPane.setPreferredSize(new Dimension(450,363));
        scrollPane.setViewportView(tProductos);


        add(scrollPane);

    }
/*

    public void updateTable(){
        ArrayList productList = new DatabaseProduct().getListDatabaseProduct();
        tmodel = new ModelTableProduct(productList);
        tProductos.setModel(tmodel);

    }

*/


}
