package prog;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Andrea Salazar - Reto3 - 15082021
 * DatabaseProduct.java
 *
 * Contiene el HashMap utilizado como base de datos.
 */
public class DatabaseProduct {

    private HashMap<Integer, Product> hashMapDatabaseProduct;
    private int indexProduct = 10;

    public DatabaseProduct() {

        hashMapDatabaseProduct = new HashMap<>();

        hashMapDatabaseProduct.put(1,new Product(1,"Manzanas",8000, 550));
        hashMapDatabaseProduct.put(2,new Product(2,"Limones",2300, 15));
        hashMapDatabaseProduct.put(3,new Product(3,"Peras",2500, 38));
        hashMapDatabaseProduct.put(4,new Product(4,"Arandanos",9300, 55));
        hashMapDatabaseProduct.put(5,new Product(5,"Tomates",2100, 42));
        hashMapDatabaseProduct.put(6,new Product(6,"Fresas",4100, 33));
        hashMapDatabaseProduct.put(7,new Product(7,"Helado",4500, 41));
        hashMapDatabaseProduct.put(8,new Product(8,"Galletas",500, 833));
        hashMapDatabaseProduct.put(9,new Product(9,"Chocolates",3900, 999));
        hashMapDatabaseProduct.put(10,new Product(10,"Jamon",17000, 10));
    }


    public ArrayList<Product> getListDatabaseProduct(){
        return new ArrayList<>(hashMapDatabaseProduct.values());
    }



    public boolean verificarExistencia(int codigo){

        return hashMapDatabaseProduct.containsKey(codigo);
    }

    public void agregarProducto(int codigo, String nombre, double precio, int inventario){
        hashMapDatabaseProduct.put(codigo,new Product(codigo,nombre,precio, inventario));
        setIndexProduct(indexProduct+1);
    }

    public void eliminarProducto(int codigo){

        hashMapDatabaseProduct.remove(codigo);
    }

    public void actualizarProducto(int codigo, String nombre, double precio, int inventario){
        Product producto = hashMapDatabaseProduct.get(codigo);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setInventario(inventario);
    }

    public Product returnProduct(int codigo){
        return hashMapDatabaseProduct.get(codigo);
    }


    /**
     *
     * Método sobrecargado para obtener el producto mayor.
     *
     * @return arreglo con el nombre e índice del producto mayor.
     * @param listaHashMap hashmap a revisar
     */
    public String[] productoPrecioMayor(HashMap<Integer, Product> listaHashMap){
        double precioMayor = 0;
        int indexMayor = 0;
        String prodMayor="";
        String[] values = new String[2];

        for (HashMap.Entry<Integer, Product> entry : listaHashMap.entrySet()){
            int key = entry.getKey();
            Product productoMayor = listaHashMap.get(key);
            if (precioMayor<productoMayor.getPrecio()){
                precioMayor=productoMayor.getPrecio();
                prodMayor = productoMayor.getNombre();
                indexMayor = productoMayor.getCodigo();
            }
        }
        values[0]=prodMayor;
        values[1]=String.valueOf(indexMayor);

        return values;
    }

    public String generarInforme() {

        HashMap<Integer, Product> hmProductoMayor = new HashMap<>(hashMapDatabaseProduct);
        String[] productoOrdenado = new String[3];

        String[] productoMayor;

        for (int index = 1; index <4; index ++){
            productoMayor = productoPrecioMayor(hmProductoMayor);
            productoOrdenado[index-1] = productoMayor[0];
            hmProductoMayor.remove(Integer.parseInt(productoMayor[1]));
        }

        return productoOrdenado[0] + " " + productoOrdenado[1] + " " + productoOrdenado[2];
    }

    public int getIndexProduct() {
        return indexProduct;
    }

    public void setIndexProduct(int indexProduct) {
        this.indexProduct = indexProduct;
    }
}
