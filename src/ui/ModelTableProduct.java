package ui;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import prog.Product;
import java.util.ArrayList;


public class ModelTableProduct extends AbstractTableModel {
    private ArrayList<Product> productList;
    private String[] columnNames;
    private TableModelListener tableModelListener;


    public ModelTableProduct(ArrayList<Product> productList) {
        this.productList = productList;
        columnNames = new String[] {"Nombre", "Precio", "Inventario"};
    }


    @Override
    public int getRowCount() {
        return productList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return columnNames[0];

            case 1:
                return  columnNames[1];

            case 2:
                return  columnNames[2];

        }
        // Para que siempre retorne un valor, aunque no llegaría aquí.
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return String.class;

            case 1:
                return Double.class;

            case 2:
                return Integer.class;

        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return productList.get(rowIndex).getNombre();

            case 1:
                return productList.get(rowIndex).getPrecio();

            case 2:
                return productList.get(rowIndex).getInventario();

        }
        // Para que siempre retorne un valor, aunque no llegaría aquí.
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Product prod = this.productList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                prod.setNombre((String)aValue);

            case 1:
                prod.setPrecio((double)aValue);


            case 2:
                prod.setInventario((int)aValue);

        }

        this.productList.set(rowIndex,prod);

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        this.tableModelListener = l;

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        this.tableModelListener = null;

    }
    public int getValueCodAt(int rowIndex) {
        return productList.get(rowIndex).getCodigo();
    }

}




