package prog;

import ui.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class EventProduct implements ActionListener {

    private PanelFields panelFieldsEvent;
    private DatabaseProduct dbase;
    private JTable tProductos;

    // Constructor
    public EventProduct(PanelFields panelFieldsEvent, DatabaseProduct dbase, JTable tProductos ){
        this.panelFieldsEvent = panelFieldsEvent;
        this.dbase = dbase;
        this.tProductos = tProductos;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        URL ruta_imagen = PanelMain.class.getResource("flaticon.png");
        ImageIcon iconFlat = new ImageIcon(ruta_imagen);

        if (e.getActionCommand().equals("Agregar Producto")){

            // Validar productos obligatorios
            if ((panelFieldsEvent.getTextFieldNameProduct().getText().isEmpty()) ||
                    (panelFieldsEvent.getTextFieldPriceProduct().getText().isEmpty()) ||
                    (panelFieldsEvent.getTextFieldStockProduct().getText().isEmpty())) {
                JOptionPane.showMessageDialog(panelFieldsEvent, "Todos los campos son oblitatorios",
                        "Error!", JOptionPane.WARNING_MESSAGE);

                // Agregar productos
            } else{
                int codAdd = dbase.getIndexProduct()+1;
                // Se eliminan espacios en blanco en los extremos del String
                String nameAdd = panelFieldsEvent.getTextFieldNameProduct().getText().trim();
                //double priceAdd = Double.parseDouble(panelFieldsEvent.getTextFieldPriceProduct().getText());
                double priceAdd = Math.round(Double.parseDouble(panelFieldsEvent.getTextFieldPriceProduct().getText()) * 10);
                priceAdd /=10;

                int stockAdd =  Integer.parseInt(panelFieldsEvent.getTextFieldStockProduct().getText());

                dbase.agregarProducto(codAdd,nameAdd,priceAdd,stockAdd);
                String nameAddProd = dbase.returnProduct(codAdd).getNombre();// Nombre del producto
                tProductos.setModel(new ModelTableProduct(dbase.getListDatabaseProduct()));

                panelFieldsEvent.getTextFieldNameProduct().setText("");
                panelFieldsEvent.getTextFieldPriceProduct().setText("");
                panelFieldsEvent.getTextFieldStockProduct().setText("");

                JOptionPane.showMessageDialog(panelFieldsEvent, "Producto \""+nameAddProd+"\" fue agregado exitosamente","Información",JOptionPane.INFORMATION_MESSAGE,iconFlat);

            }
        }

        // Modelo con los objetos de la tabla
        ModelTableProduct modelProduct;
        if (e.getActionCommand().equals("Borrar")){

            // Valida si no fue seleccionado el producto a borrar
            if (tProductos.getSelectedRows().length < 1 ) {
                JOptionPane.showMessageDialog(panelFieldsEvent, "Seleccione el producto a eliminar.",
                        "Error!", JOptionPane.WARNING_MESSAGE);

            // Valida si existen múltiples productos a borrar
            } else if (tProductos.getSelectedRows().length > 1 ){
                JOptionPane.showMessageDialog(panelFieldsEvent, "Seleccione solamente un producto.",
                        "Error!", JOptionPane.WARNING_MESSAGE);
            }
            // Procede a borrar si se selecciona un solo producto.
            else {

                int codRow = tProductos.getSelectedRow(); // fila seleccionada
                modelProduct = (ModelTableProduct) tProductos.getModel(); // Modelo del Jtable
                // Código del producto seleccionado
                int codeDel = modelProduct.getValueCodAt(codRow);
                String nameDel = dbase.returnProduct(codeDel).getNombre();
                dbase.eliminarProducto(codeDel);

                // Actualizar modelo
                tProductos.setModel(new ModelTableProduct(dbase.getListDatabaseProduct()));
                JOptionPane.showMessageDialog(panelFieldsEvent, "El producto \""+nameDel+"\" fue eliminado exitosamente.","Información",JOptionPane.INFORMATION_MESSAGE,iconFlat);

            }
        }

        if (e.getActionCommand().equals("Actualizar")){

            // Valida si no fue seleccionado el producto a borrar
            if (tProductos.getSelectedRows().length < 1 ) {
                JOptionPane.showMessageDialog(panelFieldsEvent, "Seleccione el producto a actualizar.",
                        "Error!", JOptionPane.WARNING_MESSAGE);

                // Valida si existen múltiples productos a borrar
            } else if (tProductos.getSelectedRows().length > 1 ){
                JOptionPane.showMessageDialog(panelFieldsEvent, "Seleccione solamente un producto.",
                        "Error!", JOptionPane.WARNING_MESSAGE);
            }
            // Procede a borrar si se selecciona un solo producto.
            else {

                int codRowUp = tProductos.getSelectedRow(); // fila seleccionada
                modelProduct = (ModelTableProduct) tProductos.getModel(); // Modelo del Jtable
                // Código del producto seleccionado
                int codeUpdate = modelProduct.getValueCodAt(codRowUp);
                //String nameDel = dbase.returnProduct(codeUpdate).getNombre();

                new FrameUpdate(codeUpdate,dbase,tProductos);

            }
        }

        if (e.getActionCommand().equals("Informes")){
            String informe = dbase.generarInforme();
            JOptionPane.showMessageDialog(panelFieldsEvent, "Informe: "+ informe,"Información",JOptionPane.INFORMATION_MESSAGE,iconFlat);
        }

    }

}
