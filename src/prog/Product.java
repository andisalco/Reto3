package prog;

/**
 * Andrea Salazar - Reto3 - 15082021
 * Product.java
 *
 * Contiene los datos del producto: Código, nombre, precio e inventario.
 */
public class Product {

    // Se definen los atributos de la clase para los datos del producto
    private int codigo;
    private String nombre;
    private double precio;
    private int inventario;

    // Construye la instancia del producto con los datos recibidos.
    public Product(int codigo, String nombre, double precio, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    // Devuelve el código del producto
    public int getCodigo() {
        return codigo;
    }


    // Devuelve el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Modifica el nombre del producto
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve el precio del producto
    public double getPrecio() {
        return precio;
    }

    // Modifica el precio del producto
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Devuelve el inventario del producto
    public int getInventario() {
        return inventario;
    }

    // Modifica el inventario del producto
    public void setInventario(int inventario) {
        this.inventario = inventario;
    }
}