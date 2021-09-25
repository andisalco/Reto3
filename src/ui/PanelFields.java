package ui;

import prog.DatabaseProduct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class PanelFields extends JPanel implements ActionListener {

    private DatabaseProduct dbase;
    private JTable tProductos;

    // Se crean los campos de texto
    private final JTextField textFieldNameProduct = new JTextField(15);
    private final JTextField textFieldPriceProduct= new JTextField(15);
    private final JTextField textFieldStockProduct = new JTextField(15);

    JButton buttonAddProduct = new JButton("Agregar Producto");
    JButton buttonUpdateProduct = new JButton("Actualizar");

    private int codeUpdate;

    // Constructor
    public PanelFields() {

        // Definición Layout para los campos
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder("Agregar Producto"));
        setMaximumSize(new Dimension(400, 800));

        // Se crea label para cada componente
        JLabel labelNameProduct = new JLabel("Nombre: ", JLabel.RIGHT);
        JLabel labelPriceProduct = new JLabel("Precio: ", JLabel.RIGHT);
        JLabel labelStockProduct = new JLabel("Inventario: ", JLabel.RIGHT);

        // Se crea el panel para cada campo
        JPanel panelNameProduct = new JPanel();
        JPanel panelPriceProduct = new JPanel();
        JPanel panelStockProduct = new JPanel();
        JPanel panelButtonAdd = new JPanel();

        // Se crea label asterisk
        JLabel labelNameAsterisk = new JLabel("\u002A");
        JLabel labelPriceAsterisk = new JLabel("\u002A");
        JLabel labelStockAsterisk = new JLabel("\u002A");

        // Create nameProduct
        createComponent(panelNameProduct, labelNameProduct, textFieldNameProduct, labelNameAsterisk);

        // Create priceProduct
        createComponent(panelPriceProduct, labelPriceProduct, textFieldPriceProduct, labelPriceAsterisk);

        // Create priceProduct
        createComponent(panelStockProduct, labelStockProduct, textFieldStockProduct, labelStockAsterisk);

        // Create Button AddProduct
        Dimension dimensionButtonAdd = new Dimension(150, 25);
        buttonAddProduct.setForeground(new InterfaceTools().getColorThree());
        buttonAddProduct.setPreferredSize(dimensionButtonAdd);
        panelButtonAdd.add(buttonAddProduct);

        // Agregar Espacio y botón
        add(Box.createRigidArea(new Dimension(5, 10)));
        add(panelButtonAdd);

   }

    public PanelFields(int codeUpdate,DatabaseProduct dbase, JTable tProductos) {
        this.codeUpdate = codeUpdate;
        this.dbase = dbase;
        this.tProductos = tProductos;

        textFieldNameProduct.setText(dbase.returnProduct(codeUpdate).getNombre());
        textFieldPriceProduct.setText(String.valueOf(dbase.returnProduct(codeUpdate).getPrecio()));
        textFieldStockProduct.setText(String.valueOf(dbase.returnProduct(codeUpdate).getInventario()));

        // Definición Layout para los campos
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(new Dimension(350, 300));


        // Se crea label para cada componente
        JLabel labelNameProduct = new JLabel("Nombre: ", JLabel.RIGHT);
        JLabel labelPriceProduct = new JLabel("Precio: ", JLabel.RIGHT);
        JLabel labelStockProduct = new JLabel("Inventario: ", JLabel.RIGHT);

        // Se crea el panel para cada campo
        JPanel panelNameProduct = new JPanel();
        JPanel panelPriceProduct = new JPanel();
        JPanel panelStockProduct = new JPanel();
        JPanel panelButtonAdd = new JPanel();

        // Se crea label asterisk
        JLabel labelNameAsterisk = new JLabel("\u002A");
        JLabel labelPriceAsterisk = new JLabel("\u002A");
        JLabel labelStockAsterisk = new JLabel("\u002A");

        add(Box.createRigidArea(new Dimension(5, 15)));
        // Create nameProduct
        createComponent(panelNameProduct, labelNameProduct, textFieldNameProduct, labelNameAsterisk);

        // Create priceProduct
        createComponent(panelPriceProduct, labelPriceProduct, textFieldPriceProduct, labelPriceAsterisk);

        // Create priceProduct
        createComponent(panelStockProduct, labelStockProduct, textFieldStockProduct, labelStockAsterisk);

        // Create Button AddProduct
        Dimension dimensionButtonAdd = new Dimension(150, 25);
        buttonUpdateProduct.setForeground(new InterfaceTools().getColorThree());
        buttonUpdateProduct.setPreferredSize(dimensionButtonAdd);
        panelButtonAdd.add(buttonUpdateProduct);

        // Agregar Espacio y botón
        add(Box.createRigidArea(new Dimension(5, 10)));
        validateFields();
        add(panelButtonAdd);

        buttonUpdateProduct.addActionListener(this);

    }

    // Permite crear los componentes del panel Fields
    public void createComponent(JPanel panelComponent, JLabel labelComponent,
                                JTextField textFieldComponent, JLabel labelComponentAsterisk) {

        // Panel
        panelComponent.setPreferredSize(new InterfaceTools().getDimensionPanelField());

        // Label
        labelComponent.setForeground(new InterfaceTools().getColorOne());
        labelComponent.setFont(new InterfaceTools().getFontLabel());
        labelComponent.setPreferredSize(new InterfaceTools().getDimensionLabelField());

        // TextField
        textFieldComponent.setPreferredSize(new InterfaceTools().getDimensionTextField());

        // Asterisk
        labelComponentAsterisk.setForeground(new InterfaceTools().getColorTwo());

        // Agregar componentes al panel
        panelComponent.add(labelComponent);
        panelComponent.add(labelComponentAsterisk);
        panelComponent.add(textFieldComponent);

        validateFields();

        // Agregar al panelFields
        add(panelComponent);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ImageIcon iconFlat = new ImageIcon("src/images/flaticon.png");

        if (e.getActionCommand().equals("Actualizar")){

            // Validar productos obligatorios
            if ((textFieldNameProduct.getText().isEmpty()) ||
                    (textFieldPriceProduct.getText().isEmpty()) ||
                    (textFieldStockProduct.getText().isEmpty())) {
                JOptionPane.showMessageDialog(this, "Todos los campos son oblitatorios",
                        "Error!", JOptionPane.WARNING_MESSAGE);

                // Actualizar
            } else{

                // Se eliminan espacios en blanco en los extremos del String
                String nameAdd = getTextFieldNameProduct().getText().trim();
                // Redondear a una cifra decimal el precio
                double priceAdd = Math.round(Double.parseDouble(getTextFieldPriceProduct().getText()) * 10);
                priceAdd /=10;
                int stockAdd =  Integer.parseInt(getTextFieldStockProduct().getText());

                dbase.actualizarProducto(codeUpdate,nameAdd,priceAdd,stockAdd);
                System.out.println("Actualizado");

                tProductos.setModel(new ModelTableProduct(dbase.getListDatabaseProduct()));

                JOptionPane.showMessageDialog(this, "Producto \""+nameAdd+"\" actualizado exitosamente","Información",JOptionPane.INFORMATION_MESSAGE,iconFlat);

            }

        }
    }

    public  void validateFields(){
        // Evento que permite solo digitar en el campo precio, números y el punto para cifras decimales
        getTextFieldPriceProduct().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                //super.keyTyped(e);
                char keyChar = e.getKeyChar();
                // Rechazar caracteres no numéricos y diferentes a punto
                if (!Character.isDigit(keyChar) && keyChar != '.'){
                    e.consume();
                    // Contiene más de un punto
                }else if (keyChar == '.' && getTextFieldPriceProduct().getText().contains(".") ){
                    e.consume();
                }
            }
        });

        // Evento que permite solo digitar en el campo inventario solamente números
        getTextFieldStockProduct().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                //super.keyTyped(e);
                char keyChar = e.getKeyChar();
                // Rechazar caracteres no numéricos y diferentes a punto
                if (!Character.isDigit(keyChar)) {
                    e.consume();
                }
            }
        });
    }

    public JTextField getTextFieldNameProduct() {
        return textFieldNameProduct;
    }


    public JTextField getTextFieldPriceProduct() {
        return textFieldPriceProduct;
    }

    public JTextField getTextFieldStockProduct() {
        return textFieldStockProduct;
    }

    public JButton getButtonAddProduct() {

        return buttonAddProduct;
    }

}